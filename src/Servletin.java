import javax.servlet.*;
import javax.servlet.http.*;


public class Servletin extends  HttpServlet {
	 /** Handle the HTTP <code>GET</code> method.
	 * @param request servlet request
	 * @param response servlet response
	 */
	 protected void doGet(HttpServletRequest request,
			 			  HttpServletResponse response)
			 			  throws ServletException, java.io.IOException {
		 
//		 RequestDispatcher view = request.getRequestDispatcher("tester.html");
//		 
//		 view.forward(request, response);
		 
		 
		 response.setContentType("text/html");
		 
//		 response.sendRedirect("http://localhost:8080/HelloWorld/test");

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
	 
	 protected void doPost() {
		 
	 }
	 
}

