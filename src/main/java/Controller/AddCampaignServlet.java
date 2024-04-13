package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampaignCRUDDao;

/**
 * Servlet implementation class AddCampaignServlet
 */
@WebServlet("/AddCampaignServlet")
public class AddCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CampaignCRUDDao campaignCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCampaignServlet() {
        this.campaignCRUDDao=new CampaignCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateStr = request.getParameter("date");
        String location = request.getParameter("location");
        String city = request.getParameter("city");

        // Convert date string to java.util.Date
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateStr);
            
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp"); // Redirect to error page if date parsing fails
            return;
        }
		
		boolean isSuccess=campaignCRUDDao.insertCampaign(date, location, city);
		if(isSuccess) {
			request.setAttribute("Message", "New Campaign Added.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
            dispatcher.forward(request, response);
		}else {
			request.setAttribute("Message", "New Campaign Not Added.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
            dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
