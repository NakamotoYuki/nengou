package user;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;

import event.EventBean;
import event.ResourceFinder;

public class UserBean implements Serializable {

	private String user_name;
	private String user_password;
	private String user_mail;

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_email) {
		this.user_mail = user_email;
	}

	public static void insertUserData(String user_name, String user_mail, String user_password, String created_at, String updated_at){

		Connection conn = null;

		EventBean eventbean = null;
		PreparedStatement st = null;

		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("insert into user(user_name, user_mail, user_password, status, created_at, updated_at) values(?,?,?,?,?,?)");
			st.setString(1, user_name);
			st.setString(2, user_mail);
			st.setString(3, user_password);
			st.setInt(4, 1);
			st.setString(5, created_at);
			st.setString(6, updated_at);
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

	public static void selectUserData(String user_name,String user_password){

		Connection conn = null;
		String uesr_id = null;
		EventBean eventbean = null;
		PreparedStatement st = null;

		try{
			conn = new ResourceFinder().getConnection();
			st = conn.prepareStatement("select id from user where user_name = ? AMD user_passsword ?");
			st.setString(1, user_name);
			st.setString(2, user_password);
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
}
