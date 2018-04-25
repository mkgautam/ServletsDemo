package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowRequestHeadersServlet
 */
@WebServlet("/ShowRequestHeadersServlet")
public class ShowRequestHeadersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowRequestHeadersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out;
		out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Showing All Request Headers</title>");
		out.println("</head>");
		out.println("<body>");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM-YYY 'at' hh:mm:ss a");
		String str = sdf.format(date);
		out.println("<p>Page Last Refreshed at: " + str + "</p>");
		response.setIntHeader("Refresh", 1);
		
		out.println("<h1>All Request Headers</h1>");
		out.println("<p> <b>Request Method</b> = " + request.getMethod() + "</p>");
		out.println("<p> <b>Request URI</b> = " + request.getRequestURI() + "</p>");
		out.println("<p> <b>Request Protocol</b> = " + request.getProtocol() + "</p>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.println("<p> <b>" + headerName + "</b> = " + request.getHeader(headerName) + "</p>");
		}
		
		out.println("</body>");
		out.println("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
