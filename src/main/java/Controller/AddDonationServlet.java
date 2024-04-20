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

import dao.DonationCRUDDao;

/**
 * Servlet implementation class AddDonationServlet
 */
@WebServlet("/AddDonationServlet")
public class AddDonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonationCRUDDao donationCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDonationServlet() {
       this.donationCRUDDao = new DonationCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
		String dateStr = request.getParameter("date");
        String city = request.getParameter("city");
        String bloodType = request.getParameter("bloodType");

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
		
		boolean isSuccess=donationCRUDDao.insertDonation(nic, date, city, bloodType);
		if(isSuccess) {
			request.setAttribute("Message", "New Donation Added.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddDonation.jsp");
            dispatcher.forward(request, response);
		}else {
			request.setAttribute("Message", "New Campaign Not Added.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddDonation.jsp");
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
