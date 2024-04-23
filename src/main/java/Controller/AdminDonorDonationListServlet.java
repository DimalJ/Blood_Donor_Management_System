package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonationCRUDDao;
import model.Donation;

/**
 * Servlet implementation class AdminDonorDonationListServlet
 */
@WebServlet("/AdminDonorDonationListServlet")
public class AdminDonorDonationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private DonationCRUDDao donationCRUDDao;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDonorDonationListServlet() {
    	this.donationCRUDDao = new DonationCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
		
		ArrayList<Donation> donationList= donationCRUDDao.clearDonations();
		donationList= donationCRUDDao.donationsByDonor(nic);
		
			
			if(donationList==null) {
				request.setAttribute("Message", "No records Found.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminDonorDonation.jsp");
	            dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("donations", donationList);
		        request.getRequestDispatcher("AdminDonorDonation.jsp").forward(request, response);
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
