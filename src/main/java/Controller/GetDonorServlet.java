package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonorCRUDDao;
import model.Donor;

/**
 * Servlet implementation class GetDonorServlet
 */
@WebServlet("/GetDonorServlet")
public class GetDonorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DonorCRUDDao donorCRUDDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDonorServlet() {
        this.donorCRUDDao = new DonorCRUDDao();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int  id = Integer.parseInt(strId);
		Donor donor= donorCRUDDao.getDonor(id);
		request.setAttribute("donor", donor);
        request.getRequestDispatcher("updateDonor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
