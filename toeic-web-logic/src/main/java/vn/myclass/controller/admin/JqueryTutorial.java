package vn.myclass.controller.admin;

import vn.myclass.command.JqueryCommand;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 19/8/2017.
 */
@WebServlet(urlPatterns = {"/admin-closest-method.html","/admin-find-method.html"})
public class JqueryTutorial extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JqueryCommand command = FormUtil.populate(JqueryCommand.class, request);
        if (command != null) {
            if (command.getUrlType().equals(WebConstant.URL_CLOSEST_METHOD)) {
                RequestDispatcher rd = request.getRequestDispatcher("/views/jquery_tutorial/closestMethod.jsp");
                rd.forward(request, response);
            }
            if (command.getUrlType().equals(WebConstant.URL_FIND_METHOD)) {
                RequestDispatcher rd = request.getRequestDispatcher("/views/jquery_tutorial/findMethod.jsp");
                rd.forward(request, response);
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
