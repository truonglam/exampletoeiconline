package vn.myclass.controller.admin;

import com.restfb.types.User;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.fsoft.core.common.util.SessionUtil;
import vn.myclass.core.web.common.RestFB;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.SingletonServiceUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(value = "/login-facebook")
public class LoginFacebookController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String code = request.getParameter("code");
        if (code == null || StringUtils.isBlank(code)) {
            RequestDispatcher dis = request.getRequestDispatcher("/views/web/register.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = RestFB.getToken(code);
            User user = RestFB.getUserInfo(accessToken);
            String username = user.getName();
            String username2 = user.getNameFormat();
            user.setUsername(username);
            boolean isLogined=  SingletonServiceUtil.getUserServiceInstance().loginFacebook(user);
            if(isLogined) {
                SessionUtil.getInstance().putValue(request, WebConstant.LOGIN_NAME, user.getUsername());
                response.sendRedirect("home.html");
            }else{
                RequestDispatcher dis = request.getRequestDispatcher("/views/web/register.jsp");
                dis.forward(request, response);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      doGet(request,response);
    }
}
