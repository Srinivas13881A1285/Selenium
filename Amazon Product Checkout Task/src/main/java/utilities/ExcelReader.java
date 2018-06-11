package utilities;

public class ExcelReader {
	static String excelPath = PropertyReader.getProperty("testDataLocation");
	public String getBrowserType() {
		 ExcelConfig excelConfig = new ExcelConfig(excelPath);
		 return excelConfig.getData(0, 0, 0);
	}

}
