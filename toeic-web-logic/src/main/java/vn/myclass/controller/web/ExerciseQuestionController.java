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

@WebServlet(urlPatterns = {"/bai-tap-thuc-hanh.html","/ajax-bai-tap-dap-an.html"})
public class ExerciseQuestionController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
		getListenExerciseQuestion(command);
		request.setAttribute(WebConstant.LIST_ITEMS, command);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/exercise/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExerciseQuestionCommand command = FormUtil.populate(ExerciseQuestionCommand.class, request);
		getListenExerciseQuestion(command);
		for (ExerciseQuestionDTO item: command.getListResult()) {
			if (!command.getAnswerUser().equals(item.getCorrectAnswer())) {
				command.setCheckAnswer(true);
			}
		}
		request.setAttribute(WebConstant.LIST_ITEMS, command);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/exercise/result.jsp");
		rd.forward(request, response);
	}

	private void getListenExerciseQuestion(ExerciseQuestionCommand command) {
		command.setMaxPageItems(1);
		RequestUtil.initSearchBeanManual(command);
		Object[] objects = SingletonServiceUtil.getExerciseQuestionServiceInstance().findExerciseQuestionByProperties(new HashMap<String, Object>(), command.getSortExpression(),
				command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems(), command.getExerciseId());
		command.setListResult((List<ExerciseQuestionDTO>) objects[1]);
		command.setTotalItems(Integer.parseInt(objects[0].toString()));
		command.setTotalPages((int) Math.ceil((double) command.getTotalItems() / command.getMaxPageItems()));
	}
}
