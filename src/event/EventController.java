package event;

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
 * Servlet implementation class EventController
 */
@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     System.out.println(simpleDataFormat.format(calendar.getTime()));
	     String crated_at = simpleDataFormat.format(calendar.getTime());
	     String updated_at = simpleDataFormat.format(calendar.getTime());

		request.setCharacterEncoding("UTF-8");
		EventBean eventbean = new EventBean();
		eventbean.setEvent_title(request.getParameter("event_title"));
		eventbean.setEvent_detail(request.getParameter("event_detail"));
		eventbean.setEvent_date(request.getParameter("event_date"));
		System.out.println(request.getParameter("event_date"));
		eventbean.setNengou(request.getParameter("nengou"));
		eventbean.insertEventData(eventbean.getEvent_title(), eventbean.getEvent_detail(), eventbean.getNengou(), eventbean.getEvent_date(), crated_at, updated_at);

		request.setAttribute("eventbean", eventbean);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/show.jsp");
		rd.forward(request, response);
	}

}
