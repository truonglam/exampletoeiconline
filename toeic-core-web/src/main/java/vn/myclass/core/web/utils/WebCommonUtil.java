package vn.myclass.core.web.utils;

import org.apache.commons.lang.StringUtils;
import vn.myclass.core.web.common.WebConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Admin on 27/8/2017.
 */
public class WebCommonUtil {
    public static void addRedirectMessage(HttpServletRequest request, String crudaction, Map<String, String> mapMessage) {
        if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_INSERT)) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, mapMessage.get(WebConstant.REDIRECT_INSERT));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_UPDATE)) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, mapMessage.get(WebConstant.REDIRECT_UPDATE));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_DELETE)) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_SUCCESS);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, mapMessage.get(WebConstant.REDIRECT_DELETE));
        } else if (StringUtils.isNotBlank(crudaction) && crudaction.equals(WebConstant.REDIRECT_ERROR)) {
            request.setAttribute(WebConstant.ALERT, WebConstant.TYPE_ERROR);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, mapMessage.get(WebConstant.REDIRECT_ERROR));
        }
    }
}
