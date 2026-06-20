package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    public static String getCellData(String filePath, String sheetName, String colName, int rowNum) throws IOException {
        try {
            File file=new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet(sheetName);

            Row headerRow = sheet.getRow(0); // first row for column names
            int colIndex = -1;

            // Find column index by name
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().equalsIgnoreCase(colName)) {

                    colIndex = cell.getColumnIndex();
                    break;
                }
            }
            if (colIndex == -1) {
                return "Column not found";
            }

            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colIndex);

            return cell.getStringCellValue();
        }catch (Exception e) {
            e.printStackTrace();
            return "";
        }}
}
