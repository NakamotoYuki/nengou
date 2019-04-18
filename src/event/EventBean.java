package event;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class EventBean implements Serializable {
	private String event_title;
	private String event_detail;
	private String event_date;
	private String nengou;

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

	public static void insertEventData(String event_title, String event_detail, String event_date, String nengou, String created_at, String updated_at){

		Connection conn = null;

		EventBean eventbean = null;
		PreparedStatement st = null;

		try{
			conn = new ResourceFinder().getConnectionpuser();
			st = conn.prepareStatement("insert into event(title, detail, nengou, event_date, status, created_at, updated_at) values(?,?,?,?,?,?,?)");
			st.setString(1, event_title);
			st.setString(2, event_detail);
			st.setString(3, event_date);
			st.setString(4, nengou);
			st.setInt(5, 1);
			st.setString(6, created_at);
			st.setString(7, updated_at);
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
}
