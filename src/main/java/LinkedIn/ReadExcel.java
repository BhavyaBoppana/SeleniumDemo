package LinkedIn;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    String cellData;
    public String readExceldata(String excelPath, int sheetNumber, int rowNumber, int columnNumber) {

        try {
            //object of fileclass
            File excelFile = new File(excelPath);
            //excel filepath
            FileInputStream fis = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //excelsheetnumber
            XSSFSheet excelsheetNumber = workbook.getSheetAt(sheetNumber);
            //row
            XSSFRow row = excelsheetNumber.getRow(rowNumber);
            //column
            XSSFCell column = row.getCell(columnNumber);
            //get value
            cellData = column.getStringCellValue();
            //close excelsheet
            workbook.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return cellData;
    }
}
