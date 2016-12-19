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
		 // initialize book report object
		 BookStats values = null;
		 
		 // intitialize erreor report
		 String Error = "";
		 
		 // try to get the reviews from goodreads. If the book does not exist on Goodreads or is not 
		 try {
		 	values = GRReviewFactory.getReviews((String) request.getAttribute("var"), Integer.parseInt((String) request.getAttribute("reviewCount")));
		 } catch (BadAPICall i) {
			 Error = i.getMessage();
		 } catch(IOException e) {
			 Error = "There was an error with the servlet";
		 } 
		 
		 // get the page template the results or error
		 RequestDispatcher view = request.getRequestDispatcher("/graph.jsp");
		 request.setAttribute("errorMessage", Error);
		 
		 // add the BookStats object to be displayed by 
		request.setAttribute("emotions", values);
		
		if (values != null) {
			request.setAttribute("emotionJson", Arrays.toString(values.getEmotions()));
		} else {
			request.setAttribute("emotionJson", "");
		}

		   
		 
		 view.forward(request, response);
		 
		 
	 }
	 
}

