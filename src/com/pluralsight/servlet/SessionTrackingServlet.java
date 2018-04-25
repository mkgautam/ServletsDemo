package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SessionTrackingServlet
 */
@WebServlet("/SessionTrackingServlet")
public class SessionTrackingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTrackingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>SessionTrackingServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Welcome: " + username + "</h1>");
		out.println("<form action=\"/ServletAppDemo/PreviewSessionTrackingServlet\" method=\"post\" name=\"guestFormPreview\">");
		out.println("<td><input type=\"hidden\" name=\"username\" value=\""+ username +"\"/></td>");
		out.println("<table>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println("<td>Email:</td>");
		out.println("<td><input type=\"text\" name=\"email\" value=\"\"/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" name=\"previewbtn\" value=\"Preview\"/>&nbsp;</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
