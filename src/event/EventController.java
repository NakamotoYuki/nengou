package event;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	@Override
	public String toString() {
		return "EventController [toString()=" + super.toString() + "]";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		HttpSession session = request.getSession();

		String gengou = request.getParameter("gengou");
		String gengoumei = EventBean.getJa_nengou(gengou);

		if(request.getParameter("gengou") != null){
			session.setAttribute("gengoumei", gengoumei);
		} else {
			session.setAttribute("gengoumei", "全部の出来事");
		}


		if(gengou != null){
			try{
				ArrayList<EventBean> eventbean = EventBean.selectGengouList(gengou);
				session.setAttribute("eventbean", eventbean);
			} catch(Exception e){
				e.printStackTrace();
			}

		} else {
			try{
				ArrayList<EventBean> eventbean = EventBean.selectAllList();
				session.setAttribute("eventbean", eventbean);
			} catch(Exception e){
				e.printStackTrace();
			}
		}

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/event.jsp");
		rd.forward(request, response);

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	    String crated_at = simpleDataFormat.format(calendar.getTime());
	    String updated_at = simpleDataFormat.format(calendar.getTime());
		request.setCharacterEncoding("UTF-8");

		EventBean eventbean = new EventBean();
		eventbean.setEvent_title(request.getParameter("event_title"));
		eventbean.setEvent_detail(request.getParameter("event_detail"));
		eventbean.setEvent_date(request.getParameter("event_date"));
		eventbean.setNengou(request.getParameter("nengou"));
		eventbean.setNengou_nen(request.getParameter("nengou_nen"));
		eventbean.setEn_nengou(request.getParameter("nengou"));

		eventbean.insertEventData(eventbean.getEvent_title(), eventbean.getEvent_detail(), eventbean.getNengou(), eventbean.getNengou_nen(),eventbean.getEn_nengou(), eventbean.getEvent_date(), crated_at, updated_at);

		request.setAttribute("eventbean", eventbean);
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/jsp/new.jsp");
		rd.forward(request, response);
	}

}
