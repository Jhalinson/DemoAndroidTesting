package com.qik.qa.utils;

import com.qik.qa.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    private static File file;
    private static FileInputStream fIS;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    private ExcelUtils() {

    }

    public static String getCellStringData(String sheetName, int rowNum, int column) throws Exception {
        file = new File(FrameworkConstants.getExcelPath());
        System.out.println("Excel exits:::: " + file.exists());
        fIS = new FileInputStream(file);
        workbook = new XSSFWorkbook(fIS);
        sheet = workbook.getSheet(sheetName);
        String data;

        try {
            data = sheet.getRow(rowNum).getCell(column).getStringCellValue();
        } catch (Exception e) {
            data = "";
            new Throwable("The data is coming empty for cell");
        }
        return data;

    }

    public static double getCellDataInt(int row, int cell) throws Exception {
        fIS = new FileInputStream(FrameworkConstants.getExcelPath());
        workbook = new XSSFWorkbook(fIS);
        sheet = workbook.getSheet("Sheet1");
        double data = 0;
        try {
            data = sheet.getRow(row).getCell(cell).getNumericCellValue();
        } catch (Exception e) {
            new Throwable("The data is coming empty for cell");
        }
        return data;
    }

}
