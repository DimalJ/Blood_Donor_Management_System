package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CampaignListDao;
import dao.DonorCRUDDao;
import model.Campaign;
import model.Donor;

/**
 * Servlet implementation class DonorCampaignList
 */
@WebServlet("/DonorCampaignListServlet")
public class DonorCampaignListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;   
    private CampaignListDao campaignListDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorCampaignListServlet() {
        this.campaignListDao = new CampaignListDao();
        this.donorCRUDDao = new DonorCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = (String) request.getSession().getAttribute("username");
		Donor donor = donorCRUDDao.getDonorByNic(nic);
		String city =donor.getCity();
		ArrayList<Campaign> campaigns = campaignListDao.clearCampaigns();
		campaigns=campaignListDao.getCampaignByCity(city);
		request.setAttribute("campaigns", campaigns);
        request.getRequestDispatcher("DonorCampaignList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
