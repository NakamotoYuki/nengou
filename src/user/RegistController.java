package user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistController
 */
@WebServlet("/RegistController")
public class RegistController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    System.out.println(simpleDataFormat.format(calendar.getTime()));
	    String crated_at = simpleDataFormat.format(calendar.getTime());
	    String updated_at = simpleDataFormat.format(calendar.getTime());

	    request.setCharacterEncoding("UTF-8");

		UserBean userbean = new UserBean();
		userbean.setUser_name(request.getParameter("user_name"));
		userbean.setUser_mail(request.getParameter("user_mail"));
		userbean.setUser_password(request.getParameter("user_password"));
		userbean.insertUserData(userbean.getUser_name(), userbean.getUser_mail(), userbean.getUser_password(), crated_at, updated_at);

		request.setAttribute("user", userbean);

		ServletContext context=getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/regist_comp.jsp");
		rd.forward(request, response);
	}

}
