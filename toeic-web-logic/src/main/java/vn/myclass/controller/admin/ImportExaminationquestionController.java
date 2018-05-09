package vn.myclass.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import vn.myclass.command.ExaminationCommand;
import vn.myclass.command.ExaminationQuestionCommand;
import vn.myclass.command.UserCommand;
import vn.myclass.core.common.util.ExcelPoiUtil;
import vn.myclass.core.common.util.SessionUtil;
import vn.myclass.core.common.util.UploadUtil;
import vn.myclass.core.dto.*;
import vn.myclass.core.dto.ExaminationQuestionImportDTO;
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


@WebServlet(urlPatterns = {"/admin-exam-list.html", "/ajax-admin-exam-edit.html", "/admin-exam-import.html",
                            "/admin-exam-import-validate.html"})
public class ImportExaminationquestionController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    private final String SHOW_IMPORT_EXAM = "show_import_exam";
    private final String READ_EXCEL = "read_excel";
    private final String VALIDATE_IMPORT = "validate_import";
    private final String LIST_EXAM_IMPORT = "list_exam_import";
    private final String IMPORT_DATA = "import_data";
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ExaminationQuestionCommand command = FormUtil.populate(ExaminationQuestionCommand.class, request);
        ExaminationQuestionDTO pojo = command.getPojo();
        if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_LIST)) {
            Map<String, Object> mapProperty = new HashMap<String, Object>();
            RequestUtil.initSearchBean(request, command);
            Object[] objects = SingletonServiceUtil.getExaminationQuestionServiceInstance().findByProperty(mapProperty, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
            command.setListResult((List<ExaminationQuestionDTO>) objects[1]);
            command.setTotalItems(Integer.parseInt(objects[0].toString()));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            if (command.getCrudaction() != null) {
                Map<String, String> mapMessage = buidMapRedirectMessage(bundle);
                WebCommonUtil.addRedirectMessage(request, command.getCrudaction(), mapMessage);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exam/list.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
            if (pojo != null && pojo.getExaminationQuestionId() != null) {
                command.setPojo(SingletonServiceUtil.getExaminationQuestionServiceInstance().findById(pojo.getExaminationQuestionId()));
            }
            command.setExaminationDTOS(SingletonServiceUtil.getExaminationServiceInstance().findAll());
            request.setAttribute(WebConstant.FORM_ITEM, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exam/edit.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(SHOW_IMPORT_EXAM)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exam/importexam.jsp");
            rd.forward(request, response);
        } else if (command.getUrlType() != null && command.getUrlType().equals(VALIDATE_IMPORT)) {
            List<ExaminationQuestionImportDTO> userImportDTOS = (List<ExaminationQuestionImportDTO>) SessionUtil.getInstance().getValue(request, LIST_EXAM_IMPORT);
            command.setExaminationQuestionImportDTOS(fillListExaminationQuestionImport(command, userImportDTOS, request));
            request.setAttribute(WebConstant.LIST_ITEMS, command);
            RequestDispatcher rd = request.getRequestDispatcher("/views/admin/exam/importexam.jsp");
            rd.forward(request, response);
        }
    }

    private List<ExaminationQuestionImportDTO> fillListExaminationQuestionImport(ExaminationQuestionCommand command, List<ExaminationQuestionImportDTO> userImportDTOS, HttpServletRequest request) {
        command.setMaxPageItems(3);
        RequestUtil.initSearchBean(request, command);
        command.setTotalItems(userImportDTOS.size());
        int fromIndex = command.getFirstItem();
        if (fromIndex > command.getTotalItems()) {
            fromIndex = 0;
            command.setFirstItem(0);
        }
        int toIndex = command.getFirstItem() + command.getMaxPageItems();
        if (userImportDTOS.size() > 0) {
            if (toIndex > userImportDTOS.size()) {
                toIndex = userImportDTOS.size();
            }
        }
        return userImportDTOS.subList(fromIndex, toIndex);
    }

    private Map<String,String> buidMapRedirectMessage(ResourceBundle bundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, bundle.getString("label.user.message.add.success"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, bundle.getString("label.user.message.update.success"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, bundle.getString("label.user.message.delete.success"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("label.message.error"));
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UploadUtil uploadUtil = new UploadUtil();
        Set<String> value = new HashSet<String>();
        value.add("urlType");
        Object[] objects = uploadUtil.writeOrUpdateFile(request, value, "excel");
        try {
            ExaminationQuestionCommand command = FormUtil.populate(ExaminationQuestionCommand.class, request);
            ExaminationQuestionDTO pojo = command.getPojo();
            if (command.getUrlType() != null && command.getUrlType().equals(WebConstant.URL_EDIT)) {
                if (command.getCrudaction() != null && command.getCrudaction().equals(WebConstant.INSERT_UPDATE)) {
                    ExaminationDTO roleDTO = new ExaminationDTO();
                    roleDTO.setExaminationId(command.getExaminationId());
                    pojo.setExamination(roleDTO);
                    if (pojo != null && pojo.getExaminationQuestionId() != null) {
                        SingletonServiceUtil.getExaminationQuestionServiceInstance().update(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_UPDATE);
                    } else {
                        SingletonServiceUtil.getExaminationQuestionServiceInstance().save(pojo);
                        request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_INSERT);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/edit.jsp");
                rd.forward(request, response);
            }
            if (objects != null) {
                String urlType = null;
                Map<String, String> mapValue = (Map<String, String>) objects[3];
                for (Map.Entry<String, String> item: mapValue.entrySet()) {
                    if (item.getKey().equals("urlType")) {
                        urlType = item.getValue();
                    }
                }
                if (urlType != null && urlType.equals(READ_EXCEL)) {
                    String fileLocation = objects[1].toString();
                    String fileName = objects[2].toString();
                    List<ExaminationQuestionImportDTO> excelValues = returnValueFromExcel(fileName, fileLocation);
                    validateData(excelValues);
                    SessionUtil.getInstance().putValue(request, LIST_EXAM_IMPORT, excelValues);
                    response.sendRedirect("/admin-exam-import-validate.html?urlType=validate_import");
                }
            }
            if (command.getUrlType() != null && command.getUrlType().equals(IMPORT_DATA)) {
                List<ExaminationQuestionImportDTO> userImportDTOS = (List<ExaminationQuestionImportDTO>) SessionUtil.getInstance().getValue(request, LIST_EXAM_IMPORT);
                SingletonServiceUtil.getExaminationQuestionServiceInstance().saveImport(userImportDTOS);
                SessionUtil.getInstance().remove(request, LIST_EXAM_IMPORT);
                response.sendRedirect("/admin-exam-list.html?urlType=url_list");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
    }
    private List<ExaminationQuestionImportDTO> returnValueFromExcel(String fileName, String fileLocation) throws IOException{
        Workbook workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
        Sheet sheet = workbook.getSheetAt(0);
        List<ExaminationQuestionImportDTO> excelValues = new ArrayList<ExaminationQuestionImportDTO>();
        for (int i=1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            ExaminationQuestionImportDTO userImportDTO = readDataFromExcel(row);
            excelValues.add(userImportDTO);
        }
        return excelValues;
    }
    private void validateDuplicate(ExaminationQuestionImportDTO item, Set<String> stringSet) {
//        String message = item.getError();
//        if (!stringSet.contains(item.getUserName())) {
//            stringSet.add(item.getUserName());
//        } else {
//            if (item.isValid()) {
//                message += "<br/>";
//                message += bundle.getString("label.username.duplicate");
//            }
//        }
//        if (StringUtils.isNotBlank(message)) {
//            item.setValid(false);
//            item.setError(message);
//        }
        //TODO validateDuplicate
    }

    private void validateRequireField(ExaminationQuestionImportDTO item) {
        String message = "";
        //TODO validateRequireField
//        if (StringUtils.isBlank(item.getUserName())) {
//            message += "<br/>";
//            message += bundle.getString("label.username.notempty");
//        }
//        if (StringUtils.isBlank(item.getPassword())) {
//            message += "<br/>";
//            message += bundle.getString("label.password.notempty");
//        }
//        if (StringUtils.isBlank(item.getRoleName())) {
//            message += "<br/>";
//            message += bundle.getString("label.rolename.notempty");
//        }
        if (StringUtils.isNotBlank(message)) {
            item.setValid(false);
        }
        item.setError(message);
    }

    private void validateData(List<ExaminationQuestionImportDTO> excelValues) {
        Set<String> stringSet = new HashSet<String>();
        for (ExaminationQuestionImportDTO item: excelValues) {
            validateRequireField(item);
            validateDuplicate(item, stringSet);
        }
        SingletonServiceUtil.getExaminationQuestionServiceInstance().validateImportExamination(excelValues);
    }

    private ExaminationQuestionImportDTO readDataFromExcel(Row row) {
        ExaminationQuestionImportDTO examinationQuestionImportDTO = new ExaminationQuestionImportDTO();
//        examinationQuestionImportDTO.setUserName(ExcelPoiUtil.getCellValue(row.getCell(0)));
//TODO
        return examinationQuestionImportDTO;
    }
}
