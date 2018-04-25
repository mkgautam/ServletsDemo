package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String country = request.getParameter("country");
		String[] language = request.getParameterValues("language");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<div>");
		out.println("<p> Username = " + username + "</p>");
		out.println("<p> Password = " + password + "</p>");
		out.println("<p> Gender = " + gender + "</p>");
		out.println("<p> Hobbies = ");
		for (int i = 0; i < hobbies.length; i++) {
			if((i+1) == hobbies.length) {
				out.print(hobbies[i]);
			} else {
				out.print(hobbies[i] + ", ");
			}
		}
		out.println("</p>");
		out.println("<p> Country = " + country + "</p>");
		out.println("<p> Languages Known = ");
		for (int i = 0; i < language.length; i++) {
			if((i+1) == language.length) {
				out.print(language[i]);
			} else {
				out.print(language[i] + ", ");
			}
		}
		out.println("</p>");
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
