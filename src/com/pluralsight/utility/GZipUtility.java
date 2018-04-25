package com.pluralsight.utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GZipUtility {
	
	public static boolean isGZIPSupported(HttpServletRequest request) {
		String acceptEncoding = request.getHeader("Accept-Encoding");
		return ((acceptEncoding != null) && (acceptEncoding.contains("gzip")));
	}
	
	public static boolean isGZIPDisabled(HttpServletRequest request) {
		String flag = request.getHeader("disableGzip");
		return ((flag != null) && (!flag.equalsIgnoreCase("false")));
	}
	
	public static PrintWriter getGZIPWriter(HttpServletResponse response) throws IOException {
		return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));
	}
	
}
