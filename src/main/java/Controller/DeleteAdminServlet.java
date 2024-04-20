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
 * Servlet implementation class DeleteAdminServlet
 */
@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminCRUDDao adminCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
        this.adminCRUDDao = new AdminCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strAdminId = request.getParameter("adminId");
		int adminId = Integer.parseInt(strAdminId);
		String strPassword = request.getParameter("password");
		int password = Integer.parseInt(strPassword);
		System.out.println(adminId+" "+password);
		int number = adminCRUDDao.deleteAdmin(password,adminId);
		

        if (number==1) {
        	request.setAttribute("Message", "User Deleted");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchAdmin.jsp");
            dispatcher.forward(request, response);
        } else if(number==3) {
        	request.setAttribute("Message", "Wrong Admin Password ");
            RequestDispatcher dispatcher = request.getRequestDispatcher("SearchAdmin.jsp");
            dispatcher.forward(request, response);
            }else{
            	request.setAttribute("Message", "Deletion Failed");
                RequestDispatcher dispatcher = request.getRequestDispatcher("SearchAdmin.jsp");
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
