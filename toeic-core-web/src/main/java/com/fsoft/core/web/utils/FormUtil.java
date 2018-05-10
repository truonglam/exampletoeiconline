package vn.myclass.core.web.utils;

import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Admin on 9/7/2017.
 */
public class FormUtil {
    public static <T> T populate(Class<T> clazz, HttpServletRequest request)  {
        T object = null;
        try {
            object = (T) clazz.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return object;
    }
}
