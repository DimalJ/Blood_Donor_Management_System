package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonorCRUDDao;

/**
 * Servlet implementation class DeleteDonorServlet
 */
@WebServlet("/DeleteDonorServlet")
public class DeleteDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDonorServlet() {
       this.donorCRUDDao=new DonorCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strDonorId = request.getParameter("donorId");
		int donorId = Integer.parseInt(strDonorId);
		
        boolean deletionSuccessful = false;
		
		deletionSuccessful = donorCRUDDao.deleteDonor(donorId);
		

        if (deletionSuccessful) {
        	request.setAttribute("Message", "Donor Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminSearchDonor.jsp");
            dispatcher.forward(request, response);
        } else {
        	request.setAttribute("Message", "Donor Not Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminSearchDonor.jsp");
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
