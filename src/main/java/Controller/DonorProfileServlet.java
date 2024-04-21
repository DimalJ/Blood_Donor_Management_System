package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonorCRUDDao;
import model.Donor;

/**
 * Servlet implementation class DonorPorfileServlet
 */
@WebServlet("/DonorProfileServlet")
public class DonorProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    private DonorCRUDDao donorCRUDDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorProfileServlet() {
        this.donorCRUDDao = new DonorCRUDDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nic = (String) request.getSession().getAttribute("username");

		Donor donor = donorCRUDDao.getDonorByNic(nic);
        request.setAttribute("donor",donor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("DonorProfile.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
