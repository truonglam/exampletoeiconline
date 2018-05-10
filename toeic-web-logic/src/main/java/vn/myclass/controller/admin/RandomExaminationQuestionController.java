package vn.myclass.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.myclass.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.impl.ExaminationQuestionServiceImpl;
import vn.myclass.core.web.common.WebConstant;

@WebServlet(urlPatterns = { "/admin-random-examination-question.html" })
public class RandomExaminationQuestionController extends HttpServlet {

	private static final long serialVersionUID = -7996941419505633163L;

	private ExaminationQuestionService examinationQuestionService;

	public RandomExaminationQuestionController() {
		examinationQuestionService = new ExaminationQuestionServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String examinationIdStr = request.getParameter("id");
		Integer examinationId = Integer.parseInt(examinationIdStr);
		examinationQuestionService.saveExaminationQuestionRandoms(examinationId, 4);
		response.sendRedirect(request.getContextPath()+"/admin-examination-question-list.html?id="+examinationId+"");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
