package vn.myclass.controller.web;

import org.apache.commons.collections.map.HashedMap;
import vn.myclass.command.ExerciseQuestionCommand;
import vn.myclass.core.dto.ExerciseQuestionDTO;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/bai-tap-thuc-hanh.html"})
public class ExerciseQuestionController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
		getListenExerciseQuestion(command);
		request.setAttribute(WebConstant.LIST_ITEMS, command);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/exercise/detail.jsp");
		rd.forward(request, response);
	}

	private void getListenExerciseQuestion(ExerciseQuestionCommand command) {
		Map<String, Object> properties = buildMap(command);
		command.setMaxPageItems(1);
		RequestUtil.initSearchBeanManual(command);
		Object[] objects = SingletonServiceUtil.getExerciseQuestionServiceInstance().findExerciseQuestionByProperties(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
		if (objects[1] instanceof ExerciseQuestionDTO) {
			command.setListResult((List<ExerciseQuestionDTO>) objects[1]);
		}
		command.setTotalItems(Integer.parseInt(objects[0].toString()));
		command.setTotalPages((int) Math.ceil((double) command.getTotalItems() / command.getMaxPageItems()));
	}

	private Map<String,Object> buildMap(ExerciseQuestionCommand command) {
		ExerciseQuestionDTO pojo = command.getPojo();
		Map<String,Object> result = new HashMap<String, Object>();
		if (pojo.getExercise() != null && pojo.getExercise().getExerciseId() != null) {
			result.put("exercise.exerciseId", pojo.getExercise().getExerciseId());
		}
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
