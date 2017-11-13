package vn.myclass.controller;

import vn.myclass.core.common.constant.CoreConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Admin on 13/11/2017.
 */
public class DisplayImage extends HttpServlet {

	private final String imagesBase = "/"+ CoreConstant.FOLDER_UPLOAD;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String imageUrl = request.getRequestURI();
		String relativeImagePath = imageUrl.substring("/repository/".length());
		ServletOutputStream outStream;
		outStream = response.getOutputStream();
		FileInputStream fin = new FileInputStream(imagesBase + File.separator + relativeImagePath);
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(outStream);
		int ch =0; ;
		while((ch=bin.read())!=-1)
			bout.write(ch);
		bin.close();
		fin.close();
		bout.close();
		outStream.close();
	}
}
