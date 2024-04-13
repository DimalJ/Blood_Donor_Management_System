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
 * Servlet implementation class DonorRegisterServlet
 */
@WebServlet("/DonorRegisterServlet")
public class DonorRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorRegisterServlet() {
       this.donorCRUDDao=new DonorCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // Retrieve form parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String birthday = request.getParameter("birthday");
        String bloodType = request.getParameter("bloodType");
        String email = request.getParameter("email");
        String nic = request.getParameter("NIC");
        String password=request.getParameter("password");
        String mobile = request.getParameter("mobile");
        
       boolean isTrue=donorCRUDDao.isNICUsed(nic);
        if(isTrue) {
        	 request.setAttribute("errorMessage", "NIC already used. Please try again.");
             RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
             dispatcher.forward(request, response);
        }else {
	        	 boolean isSuccess = donorCRUDDao.insertDonor(firstName, lastName, city, birthday, bloodType, email, nic, password, mobile);
	             if (isSuccess) {
	                 // Redirect to DonorHome.jsp if registration is successful
	             	request.setAttribute("Message", "Registration successful.");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("DonorHome.jsp");
	                 dispatcher.forward(request, response);
	             } else {
	                 // Redirect to error page with error message if registration is unsuccessful
	                 request.setAttribute("errorMessage", "Registration unsuccessful. Please try again.");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
	                 dispatcher.forward(request, response);
	             }
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
