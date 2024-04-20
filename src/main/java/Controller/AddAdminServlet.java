package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.AdminCRUDDao;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminCRUDDao adminCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
        this.adminCRUDDao = new AdminCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password=request.getParameter("password");
       
       boolean isTrue=adminCRUDDao.isUsernameUsed(username);
        if(isTrue) {
        	 request.setAttribute("Message", "Usernaeme already used. Please try again.");
             RequestDispatcher dispatcher = request.getRequestDispatcher("AddAdmin.jsp");
             dispatcher.forward(request, response);
        }else {
	        	 boolean isSuccess = adminCRUDDao.insertAdmin(firstName, lastName, username, password);
	             if (isSuccess) {
	                 // Redirect to DonorHome.jsp if registration is successful
	             	 request.setAttribute("Message", "New Admin User Created");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
	                 dispatcher.forward(request, response);
	             } else {
	                 // Redirect to error page with error message if registration is unsuccessful
	                 request.setAttribute("Message", "New Admin User creation unsuccessful. Please try again.");
	                 RequestDispatcher dispatcher = request.getRequestDispatcher("AddAdmin.jsp");
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
