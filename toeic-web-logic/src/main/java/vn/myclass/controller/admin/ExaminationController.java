package vn.myclass.controller.admin;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/random.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	//Integer examinationId = 2;
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	list.add(5);
    	list.add(6);
    	
    	Collections.shuffle(list);
    	int randomSeriesLength = 3;
    	List<Integer> randomSeries = list.subList(0, randomSeriesLength);
    	request.setAttribute("randomSeries", randomSeries);
    	RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/random.jsp");
        rd.forward(request, response);
    }
}
