package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonorCRUDDao;
import model.Donor;


/**
 * Servlet implementation class SearchDonorServlet
 */
@WebServlet("/SearchDonorServlet")
public class SearchDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;
    
	
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDonorServlet() {
        this.donorCRUDDao=new DonorCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = request.getParameter("nic");
		String name = request.getParameter("name");
		
		ArrayList<Donor> donorList= donorCRUDDao.clearDonors();
		donorList=donorCRUDDao.searchDonors(nic, name);
			
			if(donorList==null) {
				request.setAttribute("Message", "No Users Found.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("AdminSearchDonor.jsp");
	            dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("donors", donorList);
		        request.getRequestDispatcher("AdminSearchDonor.jsp").forward(request, response);
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
