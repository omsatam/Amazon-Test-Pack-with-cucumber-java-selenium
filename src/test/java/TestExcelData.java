import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.*;

public class TestExcelData {
    public static void main (String [] args) throws IOException {
//Path of the excel file
        FileInputStream fs = new FileInputStream("C:/Intel/test.xlsx");
//Creating a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        sheet.getRow(1).getCell(1).setCellValue(3);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        Row row7 = sheet.createRow(5);
        Cell cell7 = row7.createCell(7);
        cell7.setCellValue(9);
        Row row8 = sheet.createRow(5);
        Cell cell8 = row8.createCell(7);
        cell8.setCellValue(5);
        System.out.println(sheet.getRow(5).getCell(7));
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));
        FileOutputStream out = new FileOutputStream(
                new File("C:/Intel/test.xlsx"));

        workbook.write(out);
//String cellval = cell.getStringCellValue();
//System.out.println(cellval);
    }
}
