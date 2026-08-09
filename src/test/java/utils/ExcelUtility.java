package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {

    private static final String EXCEL_PATH = "testdata/testdata.xlsx";

    public static Object[][] getTestData(String sheetName) {
        List<Object[]> data = new ArrayList<>();

        try (InputStream inputStream = ExcelUtility.class.getClassLoader()
                .getResourceAsStream(EXCEL_PATH)) {

            if (inputStream == null) {
                throw new RuntimeException("Excel file not found on classpath: " + EXCEL_PATH);
            }

            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            // Start from row 1 to skip header row
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Object[] rowData = new Object[colCount];
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[j] = getCellValueAsString(cell);
                }
                data.add(rowData);
            }

            workbook.close();

        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data from sheet: " + sheetName, e);
        }

        return data.toArray(new Object[0][0]);
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}