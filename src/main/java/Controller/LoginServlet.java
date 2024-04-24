package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.PasswordHashDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        this.loginDao=new LoginDao();
        new PasswordHashDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username= request.getParameter("username");
		String password =request.getParameter("password");
		
		String user=loginDao.authenticateUser(username, password);
		String  firstName=loginDao.getFirstName(username);	
		
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		session.setAttribute("username", username);
		
		if (user=="Donor") {
			 request.setAttribute("nic", username);
             RequestDispatcher dispatcher = request.getRequestDispatcher("DonorDonationListServlet");
             dispatcher.forward(request, response);
		}else if(user=="Admin"){
			 request.setAttribute("Message", "Login successful.");
             RequestDispatcher dispatcher = request.getRequestDispatcher("AdminHome.jsp");
             dispatcher.forward(request, response);
		}else if(user=="Invalid") {
			request.setAttribute("Message", "Login unsuccessful.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
		}else {
			request.setAttribute("Message", "Error, Login.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
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
