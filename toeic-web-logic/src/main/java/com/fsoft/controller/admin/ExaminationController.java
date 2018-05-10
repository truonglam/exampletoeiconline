package vn.myclass.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import vn.myclass.command.ExaminationCommand;
import com.fsoft.core.common.util.UploadUtil;
import com.fsoft.core.dto.ExaminationDTO;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;
import vn.myclass.core.web.utils.SingletonServiceUtil;
import vn.myclass.core.web.utils.WebCommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/admin-examination-list.html","/admin-examination-edit.html"})
public class ExaminationController extends HttpServlet {
	
	private static final long serialVersionUID = -4994325305651496176L;
	
	private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ExaminationCommand command = FormUtil.populate(ExaminationCommand.class, request);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ResourcesBundle");
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.REDIRECT_DELETE)) {
                List<Integer> ids = new ArrayList<Integer>();
                for (String item: command.getCheckList()) {
                    ids.add(Integer.parseInt(item));
                }
                Integer result = SingletonServiceUtil.getExaminationServiceInstance().delete(ids);
                if (result != ids.size()) {
                    command.setCrudaction(WebConstant.REDIRECT_ERROR);
                }
            }
            executeSearchExamination(request, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage(resourceBundle);
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (command.getPojo() != null && command.getPojo().getExaminationId() != null) {
                command.setPojo(SingletonServiceUtil.getExaminationServiceInstance().findById("examinationId", command.getPojo().getExaminationId()));
            }
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/edit.jsp");
            rd.forward(request, response);
        }
    }

    private Map<String,String> buidMapRedirectMessage(ResourceBundle resourceBundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, resourceBundle.getString("label.listenguideline.add.success"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, resourceBundle.getString("label.listenguideline.update.success"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, resourceBundle.getString("label.listenguideline.delete.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, resourceBundle.getString("label.message.error"));
        return mapMessage;
    }

    private void executeSearchExamination(HttpServletRequest request, ExaminationCommand command) {
        Map<String, Object> properties = buildMapProperties(command);
        RequestUtil.initSearchBean(request, command);
        Object[] objects = SingletonServiceUtil.getExaminationServiceInstance().findExaminationByProperties(properties, command.getSortExpression(), command.getSortDirection(),command.getFirstItem(),command.getMaxPageItems());
        command.setListResult((List<ExaminationDTO>) objects[1]);
        command.setTotalItems(Integer.parseInt(objects[0].toString()));
    }

    private Map<String,Object> buildMapProperties(ExaminationCommand command) {
        Map<String, Object> properties = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(command.getPojo().getName())) {
            properties.put("name", command.getPojo().getName());
        }
        return properties;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ExaminationCommand command = new ExaminationCommand();
        ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> valueTitle = buildSetValueExamination();
        Object[] objects = uploadUtil.writeOrUpdateFile(request, valueTitle, WebConstant.LISTENGUIDELINE);
        boolean checkStatusUploadImage = (Boolean) objects[0];
        if (!checkStatusUploadImage) {
            response.sendRedirect("/admin-examination-list.html?urlType=url_list&&crudaction=redirect_error");
        } else {
            ExaminationDTO dto = command.getPojo();
            Map<String, String> mapValue = (Map<String, String>) objects[3];
            dto = returnValueOfDTO(dto, mapValue);
            if (dto != null) {
                if (dto.getExaminationId() != null) {
                    ExaminationDTO listenGuidelineDTO = SingletonServiceUtil.getExaminationServiceInstance().findById("examinationId", dto.getExaminationId());
                    dto.setCreatedDate(listenGuidelineDTO.getCreatedDate());
                    ExaminationDTO result = SingletonServiceUtil.getExaminationServiceInstance().update(dto);
                    if (result != null) {
                        response.sendRedirect("/admin-examination-list.html?urlType=url_list&&crudaction=redirect_update");
                    } else {
                        response.sendRedirect("/admin-examination-list.html?urlType=url_list&&crudaction=redirect_error");
                    }
                } else {
                    try {
                        SingletonServiceUtil.getExaminationServiceInstance().save(dto);
                        response.sendRedirect("/admin-examination-list.html?urlType=url_list&&crudaction=redirect_insert");
                    } catch (ConstraintViolationException e) {
                        log.error(e.getMessage(), e);
                        response.sendRedirect("/admin-examination-list.html?urlType=url_list&crudaction=redirect_error");
                    }
                }
            }
        }
    }

    private ExaminationDTO returnValueOfDTO(ExaminationDTO dto, Map<String, String> mapValue) {
        for (Map.Entry<String, String> item: mapValue.entrySet()) {
            if (item.getKey().equals("pojo.name")) {
                dto.setName(item.getValue());
            } else if (item.getKey().equals("pojo.code")) {
                dto.setCode(item.getValue());
            } else if (item.getKey().equals("pojo.examinationId")) {
                dto.setExaminationId(Integer.parseInt(item.getValue().toString()));
            }
        }
        return dto;
    }
    private Set<String> buildSetValueExamination() {
        Set<String> returnValue = new HashSet<String>();
        returnValue.add("pojo.name");
        returnValue.add("pojo.code");
        returnValue.add("pojo.examinationId");
        return returnValue;
    }
}
