package utilities;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;

    public class ExcelUtils {
        public static FileInputStream reader;
        public static FileOutputStream write;
        public static XSSFWorkbook workbook;
        public static XSSFSheet sheet;
        public static XSSFRow row;
        public static XSSFCell cell;
        public static XSSFCellStyle cellStyle;

        public static int getRowCount(String filePath, String sheetName) throws IOException {
            reader = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(reader);
            sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            workbook.close();
            reader.close();
            return rowCount;
        }

        public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
            reader = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(reader);
            sheet = workbook.getSheet(sheetName);
            row = sheet.getRow(rowNum);
            int cellCount = row.getLastCellNum();
            workbook.close();
            reader.close();
            return cellCount;
        }
        public static String getCellData(String filePath,String sheetName,int rowNum,int CellNum) throws IOException {
            reader=new FileInputStream(filePath);
            workbook=new XSSFWorkbook(reader);
            sheet=workbook.getSheet(sheetName);
            row=sheet.getRow(rowNum);
            cell=row.getCell(CellNum);

            String data;
            try {
                data=cell.toString(); //one method
        /*DataFormatter formatter=new DataFormatter(); //Another Method
        data=formatter.formatCellValue(cell);*/
            } catch (Exception e) {
                data="";
            }
            workbook.close();
            reader.close();
            return data;
        }
    }


