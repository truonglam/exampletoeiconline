package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import com.fsoft.core.common.util.SessionUtil;
import com.fsoft.core.dto.CheckLogin;
import com.fsoft.core.dto.UserDTO;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Admin on 8/7/2017.
 */
@WebServlet(urlPatterns = {"/login.html","/logout.html"})
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals(WebConstant.LOGIN)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        } else if(action.equals(WebConstant.LOGOUT)) {
            SessionUtil.getInstance().remove(request, WebConstant.LOGIN_NAME);
            response.sendRedirect(request.getContextPath()+"/home.html");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        if (pojo != null) {
            CheckLogin login = SingletonServiceUtil.getUserServiceInstance().checkLogin(pojo.getName(), pojo.getPassword());
            if (login.isUserExist()) {
                SessionUtil.getInstance().putValue(request, WebConstant.LOGIN_NAME, pojo.getName());
                if (login.getRoleName().equals(WebConstant.ROLE_ADMIN)) {
                    response.sendRedirect(request.getContextPath()+"/admin-home.html");
                } else if (login.getRoleName().equals(WebConstant.ROLE_USER)) {
                    response.sendRedirect(request.getContextPath()+"/home.html");
                }
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.name.password.wrong"));
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
                rd.forward(request, response);
            }
        }
    }
}
