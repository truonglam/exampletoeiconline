package vn.myclass.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
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
@WebServlet(urlPatterns = {"/register.html"})
public class RegisterController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand command = FormUtil.populate(UserCommand.class, request);
        UserDTO pojo = command.getPojo();
        boolean check = validateRequireField(request, response, pojo);
        if (pojo != null && check == false) {
            Boolean isAddUser = SingletonServiceUtil.getUserServiceInstance().addUser(pojo);
            if (!isAddUser) {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, bundle.getString("label.register.username.duplicate"));
                response.sendRedirect("/register.html");
            } else {
                request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
                request.setAttribute(WebConstant.MESSAGE_RESPONSE, "Đăng ký user thành công ");
                RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
                rd.forward(request, response);
            }
        }
    }

    private boolean validateRequireField(HttpServletRequest request, HttpServletResponse response, UserDTO user) throws IOException, ServletException {
        String message = "";
        if (StringUtils.isBlank(user.getName())) {
            message += "<br/>";
            message += bundle.getString("label.username.notempty");
        }
        if (StringUtils.isBlank(user.getPassword())) {
            message += "<br/>";
            message += bundle.getString("label.password.notempty");
        }
        if (StringUtils.isBlank(user.getFullName())) {
            message += "<br/>";
            message += "Full Name không bỏ trống";
        }
        if (!StringUtils.isBlank(message)) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, message);
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/register.jsp");
            rd.forward(request, response);
            return true;
        }
        return false;
    }
}
