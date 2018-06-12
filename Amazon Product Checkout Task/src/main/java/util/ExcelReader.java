package util;

public class ExcelReader {
	private  final static String excelPath = PropertyReader.getProperty("testDataLocation");
	
	ExcelConfig excelConfig = new ExcelConfig(excelPath);
	
	public String getBrowserType() {
		
		 return excelConfig.getData(0, 0, 0);
	}

	public String getProductName() {
		return excelConfig.getData(0, 1, 0);
	}
}
