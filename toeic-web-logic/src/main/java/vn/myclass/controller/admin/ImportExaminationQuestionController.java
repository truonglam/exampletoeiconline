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
public class ImportExaminationQuestionController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

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
