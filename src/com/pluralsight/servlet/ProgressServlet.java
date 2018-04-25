package com.pluralsight.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgressServlet
 */
@WebServlet(urlPatterns = "/ProgressServlet"/*, asyncSupported = true*/)
public class ProgressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgressServlet() {
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
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>Progress</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Enter doGet(), Thread Name: "+ Thread.currentThread().getName() + "</h1>");
		out.println("<progress id=\"progress\" max=\"100\"></progress>");
		if(request.isAsyncSupported()) {
			AsyncContext aContext = request.getAsyncContext();
			aContext.start(()->{
				int i = 0;
				while (i<=100) {
					out.println("<h1>Execute long task using in async, Thread Name: "+ Thread.currentThread().getName() + "</h1>");
					out.println("<script>document.getElementById(\"progress\").value=\"" + i++ + "\"</script>");
					out.flush();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
				out.println("<p>Completed long running task in async</p>");
				aContext.complete();
			});
		} else {
			int i = 0;
			while (i<=100) {
				out.println("<h1>Execute long task using, Thread Name: "+ Thread.currentThread().getName() + "</h1>");
				out.println("<script>document.getElementById(\"progress\").value=\"" + i++ + "\"</script>");
				out.flush();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			out.println("<p>Completed long running task</p>");
		}
		out.println("<h1>Exiting doGet(), Thread Name: "+ Thread.currentThread().getName() + "</h1>");
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
