package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampaignCRUDDao;

/**
 * Servlet implementation class DeleteCampaignServlet
 */
@WebServlet("/DeleteCampaignServlet")
public class DeleteCampaignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CampaignCRUDDao campaignCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCampaignServlet() {
        this.campaignCRUDDao = new CampaignCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strCampaignId = request.getParameter("campaignId");
		int campaignId = Integer.parseInt(strCampaignId);
		System.out.println(strCampaignId);
		System.out.println(campaignId);
        // Perform deletion of the campaign with the given ID (replace this with your implementation)
        boolean deletionSuccessful = false;
		try {
			deletionSuccessful = campaignCRUDDao.deleteCampaign(campaignId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (deletionSuccessful) {
        	request.setAttribute("Message", "Campaign Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminCampaignListServlet");
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("Message", "Campaign Not Deleted");
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
