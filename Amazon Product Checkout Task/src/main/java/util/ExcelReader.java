package util;

public class ExcelReader {
	private  final static String excelPath = PropertyReader.getTestDataFilePath("prerequisitesLocation");
	
	ExcelConfig excelConfig = new ExcelConfig(excelPath);
	
	public String getBrowserName() {
		
		 return excelConfig.getData(0, 0, 0);
	}

	public String getAmazonUrl() {
		return excelConfig.getData(0, 1, 0);
	}
}
