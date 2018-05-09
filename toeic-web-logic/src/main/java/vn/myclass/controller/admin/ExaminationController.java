package vn.myclass.controller.admin;

import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.impl.ExaminationQuestionServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin-random-examination.html" })
public class ExaminationController extends HttpServlet {

	private static final long serialVersionUID = -7996941419505633163L;

	private ExaminationQuestionService examinationQuestionService;

	public ExaminationController() {
		examinationQuestionService = new ExaminationQuestionServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/random.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
			Integer examinationId = 2;
			examinationQuestionService.randomExaminationQuestion(examinationId);
    	RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/random.jsp");
        rd.forward(request, response);
    }
}
