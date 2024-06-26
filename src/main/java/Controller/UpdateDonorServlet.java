package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonorCRUDDao;
import dao.LoginDao;

/**
 * Servlet implementation class UpdateDonorServlet
 */
@WebServlet("/UpdateDonorServlet")
public class UpdateDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao; 
    private LoginDao loginDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDonorServlet() {
        this.donorCRUDDao = new DonorCRUDDao();
        this.loginDao=new LoginDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id = Integer.parseInt(strId);
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String city = request.getParameter("city");
        String birthday = request.getParameter("birthday");
        String bloodType = request.getParameter("bloodType");
        String email = request.getParameter("email");
        String nic = request.getParameter("NIC");
        String mobile = request.getParameter("mobile");
        
        boolean isUpdate= donorCRUDDao.updateDonor(id, firstName, lastName, city, birthday, bloodType, email, nic, mobile);
        if(isUpdate) {
        	request.setAttribute("Message", "User Updated.");
            
        }else {
        	request.setAttribute("Message", "User Not Updated.");
            
        }
        String username= (String) request.getSession().getAttribute("username");
        String user=loginDao.userType(username);
        if (user=="Donor") {
			 
			 	RequestDispatcher dispatcher = request.getRequestDispatcher("DonorDonationListServlet");
	            dispatcher.forward(request, response);
		}else {
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
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
