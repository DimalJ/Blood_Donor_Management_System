package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminCRUDDao;
import model.Admin;

/**
 * Servlet implementation class SearchAdminServlet
 */
@WebServlet("/SearchAdminServlet")
public class SearchAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminCRUDDao adminCRUDDao;  
    private ArrayList<Admin> admins;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAdminServlet() {
        this.adminCRUDDao = new AdminCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		admins=adminCRUDDao.clearAdmins();
		admins=adminCRUDDao.searchDonors(username, name);
			
			if(admins==null) {
				request.setAttribute("Message", "No Users Found.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchAdmin.jsp");
	            dispatcher.forward(request, response);
				
			}else {
				request.setAttribute("admins", admins);
		        request.getRequestDispatcher("SearchAdmin.jsp").forward(request, response);
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
