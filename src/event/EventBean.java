package event;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class EventBean implements Serializable {
	private int id;
	private String event_title;
	private String event_detail;
	private String event_date;
	private String nengou;
	private String en_nengou;
	private String nengou_nen;

	public String getEvent_detail() {
		return event_detail;
	}

	public void setEvent_detail(String event_detail) {
		this.event_detail = event_detail;
	}

	public String getEvent_title() {
		return event_title;
	}

	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}

	public String getEvent_date() {
		return event_date;
	}

	public void setEvent_date(String event_date) {
		this.event_date = event_date;
	}

	public String getNengou() {
		return nengou;
	}

	public void setNengou(String nengou) {
		this.nengou = nengou;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEn_nengou() {
		return en_nengou;
	}

	public String getNengou_nen() {
		return nengou_nen;
	}

	public void setNengou_nen(String nengou_nen) {
		this.nengou_nen = nengou_nen;
	}

	public void setEn_nengou(String en_nengou) {

	     Map<String, String> nengou_en_list = new HashMap<>();
	     nengou_en_list.put("明治", "meiji");
	     nengou_en_list.put("大正", "taisho");
	     nengou_en_list.put("昭和", "showa");
	     nengou_en_list.put("平成", "heisei");
	     nengou_en_list.put("令和", "reiwa");
		this.en_nengou = nengou_en_list.get(en_nengou);
	}


	public static String getJa_nengou(String en_nengou) {

	     Map<String, String> nengou_ja_list = new HashMap<>();
	     nengou_ja_list.put("meiji", "明治");
	     nengou_ja_list.put("taisho", "大正");
	     nengou_ja_list.put("showa", "昭和");
	     nengou_ja_list.put("heisei", "平成");
	     nengou_ja_list.put("reiwa", "令和");
		return nengou_ja_list.get(en_nengou);
	}

	public static void insertEventData(String event_title, String event_detail, String nengou, String nengou_nen, String en_nengou, String event_date,String created_at, String updated_at){

		Connection conn = null;

		EventBean eventbean = null;
		PreparedStatement st = null;
		System.out.println(en_nengou);
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("insert into event(title, detail, nengou, nengou_nen, en_nengou, event_date, status, created_at, updated_at) values(?,?,?,?,?,?,?,?,?)");
			st.setString(1, event_title);
			st.setString(2, event_detail);
			st.setString(3, nengou);
			st.setString(4, nengou_nen);
			st.setString(5, en_nengou);
			st.setString(6, event_date);
			st.setInt(7, 1);
			st.setString(8, created_at);
			st.setString(9, updated_at);
			st.executeUpdate();
			st.clearParameters();
		} catch(Exception e){
			System.out.println(e.getMessage());

		} finally {
			try{
				st.close();
				conn.close();
			} catch(Exception e){
			}
		}
	}

	public static ArrayList<EventBean> selectAllList() throws SQLException{

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<EventBean> eventlist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id, title, detail, nengou, nengou_nen, DATE_FORMAT(event_date,'%Y-%m-%d') AS event_date FROM event");
			rs.absolute(0);
			while(rs.next()){
				EventBean eb = new EventBean();
				eb.setId(rs.getInt("id"));
				eb.setEvent_title(rs.getString("title"));
				eb.setEvent_detail(rs.getString("detail"));
				eb.setNengou(rs.getString("nengou"));
				eb.setNengou_nen(rs.getString("nengou_nen"));
				eb.setEvent_date(rs.getString("event_date"));
				eventlist.add(eb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				st.close();
				conn.close();
			} catch(SQLException e){

				e.printStackTrace();
			}
		}
	return eventlist;

}

// 元号を選択した場合
	public static ArrayList<EventBean> selectGengouList(String nengou) throws SQLException{

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<EventBean> eventlist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM event where en_nengou = \"" + nengou +"\"");
			rs.absolute(0);
			while(rs.next()){
				EventBean eb = new EventBean();
				eb.setId(rs.getInt("id"));
				eb.setEvent_title(rs.getString("title"));
				eb.setEvent_detail(rs.getString("detail"));
				eb.setEvent_date(rs.getString("event_date"));
				eventlist.add(eb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				st.close();
				conn.close();
			} catch(SQLException e){

				e.printStackTrace();
			}
		}
	return eventlist;

}

// 個別ページの情報を取得
	public static ArrayList<EventBean> getArticleList(String event_id) throws SQLException{

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<EventBean> eventlist = new ArrayList<>();
		try{
			conn = new ResourceFinder().getConnection();
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM event where id = " + event_id);
			rs.absolute(0);
			while(rs.next()){
				EventBean eb = new EventBean();
				eb.setId(rs.getInt("id"));
				eb.setEvent_title(rs.getString("title"));
				eb.setEvent_detail(rs.getString("detail"));
				eb.setEvent_date(rs.getString("event_date"));
				eventlist.add(eb);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			try{
				rs.close();
				st.close();
				conn.close();
			} catch(SQLException e){

				e.printStackTrace();
			}
		}
		return eventlist;

	}
}
