import java.io.IOException;
import java.util.Arrays;

import javax.servlet.*;
import javax.servlet.http.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonArray;

import watson.*;


public class Servletin extends  HttpServlet {
	 /** Handle the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */

		 
		 
	 protected void doGet(HttpServletRequest request,
			  HttpServletResponse response)
			  throws ServletException, java.io.IOException {
		 
		 
		 response.setContentType("text/html");
		 java.io.PrintWriter out = response.getWriter();
		 // output your page here
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Servlet</title>");
		 
		 int x = 6;
		 out.println("</head>");
		 out.println("<body>");
		 out.println("Hello, Java Servlets" + x);
		 out.println("</body>");
		 out.println("</html>");
		 out.close();
		 
		 
	 }
		 

	 





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		 RequestDispatcher view = request.getRequestDispatcher("/graph.jsp");
		 
		 request.getAsyncContext()
		
		 JsonArray values = GRReviewFactory.getReviews((String) request.getAttribute("var"), Integer.parseInt((String) request.getAttribute("reviewCount")));
		 
		 request.setAttribute("emotions", values);
		 
		 view.forward(request, response);
		 
		 
		 
//		 response.setContentType("text/html");
//		 java.io.PrintWriter out = response.getWriter();
//		 // output your page here
//		 out.println("<html>");
//		 out.println("<head>");
//		 out.println("<title>Servlet</title>");
//		 Object y = request.getAttribute("var");
//		 int x = 6;
//		 out.println("</head>");
//		 out.println("<body>");
//		 out.println("Hello, Java Servlets trying hard" + x + y);
//		 out.println("</body>");
//		 out.println("</html>");
//		 out.close();
	 }
	 
}

