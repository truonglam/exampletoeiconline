package vn.myclass.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import vn.myclass.command.ExerciseResultCommand;
import vn.myclass.command.ResultCommand;
import com.fsoft.core.common.util.SessionUtil;
import com.fsoft.core.dto.ExerciseResultDTO;
import com.fsoft.core.dto.ResultDTO;
import vn.myclass.core.service.ExaminationService;
import vn.myclass.core.service.ExerciseResultService;
import vn.myclass.core.service.ExerciseService;
import vn.myclass.core.service.ResultService;
import vn.myclass.core.service.impl.ExaminationServiceImpl;
import vn.myclass.core.service.impl.ExerciseResultServiceImpl;
import vn.myclass.core.service.impl.ExerciseServiceImpl;
import vn.myclass.core.service.impl.ResultServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

@WebServlet(urlPatterns = {"/quan-ly-tai-khoan.html"})
public class UserReportController extends HttpServlet {

	private static final long serialVersionUID = -2052067823186538805L;
	
	private ResultService resultService;
	private ExaminationService examinationService;
	private ExerciseResultService exerciseResultService;
	private ExerciseService exerciseService;

	public UserReportController() {
		resultService = new ResultServiceImpl();
		examinationService = new ExaminationServiceImpl();
		exerciseResultService = new ExerciseResultServiceImpl();
		exerciseService = new ExerciseServiceImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
		if (request.getParameter("urlType") != null && StringUtils.isNotEmpty(request.getParameter("urlType")) && request.getParameter("urlType").equals("ket-qua-thi")) {
			ResultCommand command = FormUtil.populate(ResultCommand.class, request);
			String code = command.getExaminationCode();
			List<ResultDTO> results = resultService.getResultsByUser(userName, command.getExaminationCode());
			command.setExaminations(examinationService.findAll());
			if (code != null && StringUtils.isNotEmpty(code)) {
				request.setAttribute("selectedCode", code);
			}
			command.setListResult(results);
			request.setAttribute(WebConstant.LIST_ITEMS, command);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage/detail.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("urlType") != null && StringUtils.isNotEmpty(request.getParameter("urlType")) && request.getParameter("urlType").equals("ket-qua-bai-tap")) {
			ExerciseResultCommand command = FormUtil.populate(ExerciseResultCommand.class, request);
			Integer exerciseId = command.getExerciseId();
			List<ExerciseResultDTO> exerciseResults = exerciseResultService.getExerciseResultsByUser(userName, exerciseId);
			command.setExercises(exerciseService.getAll());
			if (exerciseId != null && exerciseId != -1) {
				request.setAttribute("selectedExerciseId", exerciseId);
			}
			command.setListResult(exerciseResults);
			request.setAttribute(WebConstant.LIST_ITEMS, command);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage/detail.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/user/manage/list.jsp");
			rd.forward(request, response);
		}
	}
}
