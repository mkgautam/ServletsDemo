package com.pluralsight.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(
		fileSizeThreshold = 1021*1024*2, //2MB
		maxFileSize = 1021*1024*10, //10MB
		maxRequestSize = 1021*1024*50 //50MB
)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String SAVE_DIR = "UploadFiles";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		System.out.println("savePath = " + savePath);
		
		File fileSaveDir = new File(savePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		
		for (Part part : request.getParts()) {
			String filename = extractFileName(part);
			if(!filename.isEmpty()) {
				part.write(savePath + File.separator + filename);
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("<title>File Upload Result</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>File Uploaded Successfully</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	private String extractFileName(Part part) {
		// TODO Auto-generated method stub
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("contentDisp = " + contentDisp);
		String[] items = contentDisp.split(";");
		for (String str : items) {
			if(str.trim().startsWith("filename")) {
				return str.substring(str.indexOf("=")+2, str.length()-1);
			}
		}
		return "";
	}

}
