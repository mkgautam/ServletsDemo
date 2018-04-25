package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		out.println("<h2>Reading data using 'String getParameter(String input)' method</h2>");
		out.println("<div>");
		out.println("<p> FirstName = " + firstName + "</p>");
		out.println("<p> LastName = " + lastName + "</p>");
		out.println("<div>");
		
		out.println("<h2>Reading data using 'String getParameterNames(String input)' method</h2>");
		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<div>");
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>" + paramName + ": " + paramValue + "</p>");
		}
		out.println("</div>");
		
		out.println("<h2>Reading data using 'String getParameterMap()' method</h2>");
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNameSet = paramMap.keySet();
		out.println("<div>");
		for (String paramName : paramNameSet) {
			out.println("<p>" + paramName + ": ") ;
			String[] paramValue = paramMap.get(paramName);
			for (int i = 0; i < paramValue.length; i++) {
				out.println(paramValue[i]);
			}
			out.println("</p>");
		}
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
