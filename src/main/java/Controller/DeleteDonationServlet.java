package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonationCRUDDao;

/**
 * Servlet implementation class DeleteDonationServlet
 */
@WebServlet("/DeleteDonationServlet")
public class DeleteDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonationCRUDDao donationCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDonationServlet() {
    	this.donationCRUDDao = new DonationCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strDonationId = request.getParameter("id");
		int donationId = Integer.parseInt(strDonationId);
		
        boolean deletionSuccessful = false;
		try {
			deletionSuccessful = donationCRUDDao.deleteDonation(donationId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (deletionSuccessful) {
        	request.setAttribute("Message", "Record Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchDonation.jsp");
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("Message", "Record Not Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchDonation.jsp");
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
