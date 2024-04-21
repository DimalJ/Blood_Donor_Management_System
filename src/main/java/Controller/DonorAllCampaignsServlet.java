package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampaignListDao;
import model.Campaign;

/**
 * Servlet implementation class DonorAllCampaignsServlet
 */
@WebServlet("/DonorAllCampaignsServlet")
public class DonorAllCampaignsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CampaignListDao campaignListDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorAllCampaignsServlet() {
    	this.campaignListDao=new CampaignListDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Campaign> campaigns = campaignListDao.clearCampaigns();
		campaigns=campaignListDao.getCampaignList();
		request.setAttribute("campaigns", campaigns);
        request.getRequestDispatcher("DonorAllCampaigns.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
