package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	FileInputStream inputStream = null;
	XSSFWorkbook workbook = null;
	File file = null;
	public ExcelConfig(String excelPath) {
		try {
			file = new File(excelPath);
			inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	public String getData(int sheetIndex,int rowNum,int colNum) {
		 XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
		 String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		 return data;
	}
}
