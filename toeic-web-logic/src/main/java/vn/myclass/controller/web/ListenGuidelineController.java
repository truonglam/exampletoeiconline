package vn.myclass.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 24/11/2017.
 */
@WebServlet(urlPatterns = {"/danh-sach-huong-dan-nghe.html","/noi-dung-bai-huong-dan-nghe.html"})
public class ListenGuidelineController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/listenguideline/detail.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/listenguideline/list.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
