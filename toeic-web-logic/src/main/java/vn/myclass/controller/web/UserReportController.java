package vn.myclass.controller.web;

import vn.myclass.core.common.util.SessionUtil;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/quan-ly-tai-khoan.html"})
public class UserReportController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlType = null;
		if (request.getParameter("type") != null) {
			urlType = request.getParameter("type");
		}
		if (urlType != null && urlType.equals("ket-qua-thi")) {
			String userName = (String) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
			//get user by username

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage.jsp");
			rd.forward(request, response);
		}
	}
}
