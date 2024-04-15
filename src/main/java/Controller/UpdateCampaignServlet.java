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
 * Servlet implementation class UpdateCampaignServlet
 */
@WebServlet("/UpdateCampaignServlet")
public class UpdateCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CampaignCRUDDao campaignCRUDDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCampaignServlet() {
    	this.campaignCRUDDao=new CampaignCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int  id = Integer.parseInt(strId);
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
		
		boolean isSuccess=campaignCRUDDao.updateCampaign(id,date, location, city);
		if(isSuccess) {
			request.setAttribute("Message", "Campaign Updated.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminCampaignListServlet");
            dispatcher.forward(request, response);
		}else {
			request.setAttribute("Message", "campaign Not updated.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminCampaignListServlet");
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
