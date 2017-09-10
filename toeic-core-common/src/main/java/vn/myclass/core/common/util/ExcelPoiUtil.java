package vn.myclass.core.common.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Admin on 10/9/2017.
 */
public class ExcelPoiUtil {

    public static Workbook getWorkBook(String fileName, String fileLocation) throws IOException {
        FileInputStream excelFile = new FileInputStream(new File(fileLocation));
        Workbook workbook = null;
        if (fileName.endsWith("xls")) {
            workbook = new HSSFWorkbook(excelFile);
        } else if (fileName.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(excelFile);
        }
        return workbook;
    }
}
