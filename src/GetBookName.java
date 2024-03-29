

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetBookName
 */
@WebServlet("/GetBookName")
public class GetBookName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookName() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // get the requested resource
		 RequestDispatcher view = request.getRequestDispatcher("/postBookName.html");
		 
		 // display
		 view.forward(request, response);
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the user input book name
		request.setAttribute("var", request.getParameter("bookname"));
		request.setAttribute("reviewCount", request.getParameter("reviewcount"));

		
		//go forward to the second servlet
		getServletContext().getRequestDispatcher("/servlet").forward(request,response);
		
	}

}
