package vn.myclass.controller.web;

import org.apache.commons.lang.StringUtils;
import vn.myclass.command.ResultCommand;
import vn.myclass.core.common.util.SessionUtil;
import vn.myclass.core.dto.ResultDTO;
import vn.myclass.core.service.ResultService;
import vn.myclass.core.service.impl.ResultServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/quan-ly-tai-khoan.html"})
public class UserReportController extends HttpServlet {

	private ResultService resultService;

	public UserReportController() {
		resultService = new ResultServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResultCommand command = FormUtil.populate(ResultCommand.class, request);
		if (command.getUrlType() != null && StringUtils.isNotEmpty(command.getUrlType())) {
			String userName = (String) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
			List<ResultDTO> results = resultService.getResultsByUser(command.getUrlType(), userName, command.getSearchValue());
			command.setListResult(results);
			request.setAttribute(WebConstant.LIST_ITEMS, command);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage/detail.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage/list.jsp");
			rd.forward(request, response);
		}
	}
}
