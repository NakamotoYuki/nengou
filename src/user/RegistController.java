package user;

import java.io.IOException;

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
		request.setCharacterEncoding("UTF-8");

		User user = new User();
		user.setUser_name(request.getParameter("user_name"));
		user.setUser_name(request.getParameter("user_mail"));

		request.setAttribute("user", user);

		ServletContext context=getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/regist_comp.jsp");
		rd.forward(request, response);
	}

}
