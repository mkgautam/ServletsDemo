package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionPreview
 */
@WebServlet("/SessionPreview")
public class SessionPreview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionPreview() {
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
		String email = request.getParameter("email");
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>PreviewSessionTrackingServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Please confirm your information:</h1>");
		out.println("<h1>UserName: " + username + "</h1>");
		out.println("<h1>Email: " + email + "</h1>");
		session.setAttribute("email", email);
		out.println("<table>");
		out.println("<tbody>");
		out.println("<form action=\"/ServletAppDemo/SessionSaveData\" method=\"post\" name=\"saveFormPreview\">");
		out.println("<tr>");
		out.println("<td><input type=\"submit\" name=\"submitbtn\" value=\"Submit\"/>&nbsp;</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
