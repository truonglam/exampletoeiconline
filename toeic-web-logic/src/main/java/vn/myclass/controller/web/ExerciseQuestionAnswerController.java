package vn.myclass.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.myclass.command.ExerciseQuestionCommand;
import vn.myclass.core.common.util.SessionUtil;
import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.service.ExerciseQuestionService;
import vn.myclass.core.service.ExerciseResultService;
import vn.myclass.core.service.impl.ExerciseQuestionServiceImpl;
import vn.myclass.core.service.impl.ExerciseResultServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

@WebServlet(urlPatterns = {"/ajax-xac-nhan-cham-diem-bai-tap.html","/ajax-cham-diem-bai-tap.html"})
public class ExerciseQuestionAnswerController extends HttpServlet {
	
	private ExerciseQuestionService exerciseQuestionService;
	private ExerciseResultService exerciseResultService;
	
	public ExerciseQuestionAnswerController() {
		exerciseQuestionService = new ExerciseQuestionServiceImpl();
		exerciseResultService = new ExerciseResultServiceImpl();
	}
	
	private static final long serialVersionUID = -8803444210235152094L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
		Integer exerciseQuestionId = command.getPojo().getExerciseQuestionId();
		String answerUser = command.getAnswerUser();
		ExerciseQuestionDTO exerciseQuestionDTO = exerciseQuestionService.confirmExercisePoint(exerciseQuestionId, answerUser);
		List<ExerciseQuestionDTO> exerciseQuestionDTOs = getExerciseQuestions(request, exerciseQuestionDTO);
		if (command.getUrlType() != null && command.getUrlType().equals("check-point")) {
			String loginName = (String) SessionUtil.getInstance().getValue(request, WebConstant.LOGIN_NAME);
			exerciseResultService.saveExerciseResult(exerciseQuestionDTOs, command.getExerciseId(), loginName);
			SessionUtil.getInstance().remove(request, "confirm-point-exercise");
			out.print("ajax-cham-diem-bai-tap");
		} else {
			SessionUtil.getInstance().putValue(request, "confirm-point-exercise", exerciseQuestionDTOs);
			out.print("ajax-xac-nhan-cham-diem-bai-tap");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	private List<ExerciseQuestionDTO> getExerciseQuestions(HttpServletRequest request, ExerciseQuestionDTO exerciseQuestionDTO) {
		List<ExerciseQuestionDTO> exerciseQuestionDTOs = new ArrayList<>();
		if (SessionUtil.getInstance().getValue(request, "confirm-point-exercise") != null) {
			exerciseQuestionDTOs = (List<ExerciseQuestionDTO>) SessionUtil.getInstance().getValue(request, "confirm-point-exercise");
			exerciseQuestionDTOs.add(exerciseQuestionDTO);
			SessionUtil.getInstance().remove(request, "confirm-point-exercise");
		} else {
			exerciseQuestionDTOs.add(exerciseQuestionDTO);
		}
		return exerciseQuestionDTOs;
	}
}
