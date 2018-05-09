package vn.myclass.controller.admin;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import vn.myclass.command.ExaminationQuestionCommand;
import vn.myclass.core.common.util.ExcelPoiUtil;
import vn.myclass.core.common.util.SessionUtil;
import vn.myclass.core.common.util.UploadUtil;
import vn.myclass.core.dto.ExaminationDTO;
import vn.myclass.core.dto.ExaminationQuestionDTO;
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
        }
    }

    private List<ExaminationQuestionImportDTO> fillListExaminationQuestionImport(ExaminationQuestionCommand command, List<ExaminationQuestionImportDTO> ImportDTOS, HttpServletRequest request) {
        command.setMaxPageItems(3);
        RequestUtil.initSearchBean(request, command);
        command.setTotalItems(ImportDTOS.size());
        int fromIndex = command.getFirstItem();
        if (fromIndex > command.getTotalItems()) {
            fromIndex = 0;
            command.setFirstItem(0);
        }
        int toIndex = command.getFirstItem() + command.getMaxPageItems();
        if (ImportDTOS.size() > 0) {
            if (toIndex > ImportDTOS.size()) {
                toIndex = ImportDTOS.size();
            }
        }
        return ImportDTOS.subList(fromIndex, toIndex);
    }

    private Map<String, String> buidMapRedirectMessage(ResourceBundle bundle) {
        Map<String, String> mapMessage = new HashMap<String, String>();
        mapMessage.put(WebConstant.REDIRECT_INSERT, bundle.getString("Thêm thành công"));
        mapMessage.put(WebConstant.REDIRECT_UPDATE, bundle.getString("Cập nhật thành công!"));
        mapMessage.put(WebConstant.REDIRECT_DELETE, bundle.getString("Xóa thành công"));
        mapMessage.put(WebConstant.REDIRECT_ERROR, bundle.getString("Error"));
        return mapMessage;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
                for (Map.Entry<String, String> item : mapValue.entrySet()) {
                    if (item.getKey().equals("urlType")) {
                        urlType = item.getValue();
                    }
                }
                if (urlType != null && urlType.equals(READ_EXCEL)) {
                    String fileLocation = objects[1].toString();
                    String fileName = objects[2].toString();
                    int idExam = Integer.parseInt(request.getParameter("idExam"));
                    List<ExaminationQuestionImportDTO> excelValues = returnValueFromExcel(fileName, fileLocation, idExam);
                    SingletonServiceUtil.getExaminationQuestionServiceInstance().saveImport(excelValues);
                }
            }
            if (command.getUrlType() != null && command.getUrlType().equals(IMPORT_DATA)) {
                List<ExaminationQuestionImportDTO> ImportDTOS = (List<ExaminationQuestionImportDTO>) SessionUtil.getInstance().getValue(request, LIST_EXAM_IMPORT);
                SingletonServiceUtil.getExaminationQuestionServiceInstance().saveImport(ImportDTOS);
                SessionUtil.getInstance().remove(request, LIST_EXAM_IMPORT);
                response.sendRedirect("/admin-exam-list.html?urlType=url_list");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            request.setAttribute(WebConstant.MESSAGE_RESPONSE, WebConstant.REDIRECT_ERROR);
        }
    }

    private List<ExaminationQuestionImportDTO> returnValueFromExcel(String fileName, String fileLocation, int examinationQuestionId) throws IOException {
        Workbook workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
        Sheet sheet = workbook.getSheetAt(0);
        List<ExaminationQuestionImportDTO> excelValues = new ArrayList<ExaminationQuestionImportDTO>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            ExaminationQuestionImportDTO userImportDTO = readDataFromExcel(row, examinationQuestionId);
            excelValues.add(userImportDTO);
        }
        return excelValues;
    }

    private ExaminationQuestionImportDTO readDataFromExcel(Row row, int examinationQuestionId) {
        ExaminationQuestionImportDTO examinationQuestionImportDTO = new ExaminationQuestionImportDTO();
        examinationQuestionImportDTO.setImage(ExcelPoiUtil.getCellValue(row.getCell(0)));
        examinationQuestionImportDTO.setAudio(ExcelPoiUtil.getCellValue(row.getCell(1)));
        examinationQuestionImportDTO.setQuestion(ExcelPoiUtil.getCellValue(row.getCell(2)));
        examinationQuestionImportDTO.setParagraph(ExcelPoiUtil.getCellValue(row.getCell(3)));
        examinationQuestionImportDTO.setOption1(ExcelPoiUtil.getCellValue(row.getCell(4)));
        examinationQuestionImportDTO.setOption2(ExcelPoiUtil.getCellValue(row.getCell(5)));
        examinationQuestionImportDTO.setOption3(ExcelPoiUtil.getCellValue(row.getCell(6)));
        examinationQuestionImportDTO.setOption4(ExcelPoiUtil.getCellValue(row.getCell(7)));
        examinationQuestionImportDTO.setCorrectAnswer(ExcelPoiUtil.getCellValue(row.getCell(8)));
        examinationQuestionImportDTO.setType(ExcelPoiUtil.getCellValue(row.getCell(9)));
        examinationQuestionImportDTO.setExaminationQuestionId(examinationQuestionId);
        return examinationQuestionImportDTO;
    }
}
