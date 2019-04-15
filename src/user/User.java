package user;
import java.io.Serializable;

public class User implements Serializable {

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
	public String getUser_email() {
		return user_mail;
	}
	public void setUser_mail(String user_email) {
		this.user_mail = user_email;
	}


}
