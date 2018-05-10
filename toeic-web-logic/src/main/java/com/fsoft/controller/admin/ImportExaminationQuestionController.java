package vn.myclass.controller.admin;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import vn.myclass.command.ExaminationQuestionCommand;
import com.fsoft.core.common.util.ExcelPoiUtil;
import com.fsoft.core.common.util.UploadUtil;
import com.fsoft.core.dto.ExaminationQuestionDTO;
import vn.myclass.core.service.ExaminationQuestionService;
import vn.myclass.core.service.impl.ExaminationQuestionServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;


@WebServlet(urlPatterns = {"/admin-examination-question-list.html", "/admin-examination-question-import.html"})
public class ImportExaminationQuestionController extends HttpServlet {

	private static final long serialVersionUID = 5690218324653865513L;

	private ExaminationQuestionService examinationQuestionService;

	public ImportExaminationQuestionController() {
		examinationQuestionService = new ExaminationQuestionServiceImpl();
	}

	//private final Logger log = Logger.getLogger(ImportExaminationQuestionController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ExaminationQuestionCommand command = FormUtil.populate(ExaminationQuestionCommand.class, request);
		String examinationIdStr = request.getParameter("id");
		command.setExaminationId(Integer.parseInt(examinationIdStr));
		request.setAttribute("examinationId", command.getExaminationId());
		if (request.getParameter("type") != null && request.getParameter("type").equals("import-question-page")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/examinationquestion/import.jsp");
			rd.forward(request, response);
		} else {
			getExaminationQuestions(request, command);
			request.setAttribute(WebConstant.LIST_ITEMS, command);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/examination/examinationquestion/list.jsp");
			rd.forward(request, response);
		}
	}

	private void getExaminationQuestions(HttpServletRequest request, ExaminationQuestionCommand command) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("examinationId", command.getExaminationId());
		RequestUtil.initSearchBean(request, command);
		Object[] objects = examinationQuestionService.findByProperty(properties, command.getSortExpression(), command.getSortDirection(), command.getFirstItem(), command.getMaxPageItems());
		command.setListResult((List<ExaminationQuestionDTO>) objects[1]);
		command.setTotalItems(Integer.parseInt(objects[0].toString()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UploadUtil uploadUtil = new UploadUtil();
		Set<String> value = new HashSet<String>();
		value.add("examinationId");
		Object[] objects = uploadUtil.writeOrUpdateFile(request, value, "excel");
		Integer examinationId = null;
		if (objects != null) {
			String examinationIdStr = null;
			Map<String, String> mapValue = (Map<String, String>) objects[3];
			for (Map.Entry<String, String> item: mapValue.entrySet()) {
				if (item.getKey().equals("examinationId")) {
					examinationIdStr = item.getValue();
				}
			}
			String fileLocation = objects[1].toString();
			String fileName = objects[2].toString();
			examinationId = Integer.parseInt(examinationIdStr);
			List<ExaminationQuestionDTO> examinationQuestionDTOS = returnValueFromExcel(fileName, fileLocation);
			examinationQuestionService.saveImport(examinationQuestionDTOS, examinationId);
		}
		response.sendRedirect(request.getContextPath()+"/admin-examination-question-list.html?id="+examinationId+"");
	}

	private List<ExaminationQuestionDTO> returnValueFromExcel(String fileName, String fileLocation) throws IOException {
		Workbook workbook = ExcelPoiUtil.getWorkBook(fileName, fileLocation);
		Sheet sheet = workbook.getSheetAt(0);
		List<ExaminationQuestionDTO> excelValues = new ArrayList<ExaminationQuestionDTO>();
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			ExaminationQuestionDTO userImportDTO = readDataFromExcel(row);
			excelValues.add(userImportDTO);
		}
		return excelValues;
	}

	private ExaminationQuestionDTO readDataFromExcel(Row row) {
		ExaminationQuestionDTO examinationQuestionImportDTO = new ExaminationQuestionDTO();
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
		return examinationQuestionImportDTO;
	}
}
