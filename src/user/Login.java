package user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
			HttpSession session=request.getSession();
			String user_name = request.getParameter("user_name");
			String user_password = request.getParameter("user_password");

			session.setAttribute("user_name", user_name);
			session.setAttribute("user_password", user_password);

		}catch(Exception ex){
			ex.printStackTrace();
		}

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/login_fail.jsp");

		rd.forward(request, response);
	}

}
