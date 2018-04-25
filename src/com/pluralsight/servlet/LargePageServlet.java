package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pluralsight.utility.GZipUtility;

/**
 * Servlet implementation class LargePageServlet
 */
@WebServlet("/LargePageServlet")
public class LargePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LargePageServlet() {
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
		
		if(GZipUtility.isGZIPSupported(request) && !GZipUtility.isGZIPDisabled(request)) {
			out = GZipUtility.getGZIPWriter(response);
			response.setHeader("Content-Encoding", "gzip");
		} else {
			out = response.getWriter();
		}
		
		String str = "Natural sources of gamma rays on Earth are observed in the gamma decay of radionuclides and secondary radiation from atmospheric interactions with cosmic ray particles. There are rare terrestrial natural sources, such as lightning strikes and terrestrial gamma-ray flashes, that produce gamma rays not of a nuclear origin. Additionally, gamma rays are produced by a number of astronomical processes in which very high-energy electrons are produced, that in turn cause secondary gamma rays via bremsstrahlung, inverse Compton scattering, and synchrotron radiation.";
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Large Page Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>Large Page Servlet Demo</h1>");
		for (int i = 0; i < 10000; i++) {
			out.println(str);
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
