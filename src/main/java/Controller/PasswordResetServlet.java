package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.DonorCRUDDao;
import dao.PasswordHashDao;

/**
 * Servlet implementation class PasswordResetServlet
 */
@WebServlet("/PasswordResetServlet")
public class PasswordResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;  
    private PasswordHashDao passwordHashDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordResetServlet() {
        this.donorCRUDDao = new DonorCRUDDao();
        this.passwordHashDao = new PasswordHashDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String email = request.getParameter("email");
        String nic = request.getParameter("username");
        String password=request.getParameter("password");
        
       
        String hashedPassword=passwordHashDao.hashPassword(password);
       
         boolean isSuccess = donorCRUDDao.updatePasssword(hashedPassword, nic, email);
	             if (isSuccess) {
	                 // Redirect to DonorHome.jsp if registration is successful
	             	 request.setAttribute("Message", "Password Changed.");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("CampaignListServlet");
	                 dispatcher.forward(request, response);
	             } else {
	                 // Redirect to error page with error message if registration is unsuccessful
	            	 request.setAttribute("Message", "Password  not Changed.");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("CampaignListServlet");
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
