package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class readTextboxdata {

	@DataProvider(name = "textBoxData")
	public static Object getTextboxTestData() throws IOException {
		Object testData = readTestDataExcelData("emailTextField");
		return testData;
	}

	public static Object[][] readTestDataExcelData(String sheetName) throws IOException {
		FileInputStream fileStream = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\testData\\textboxData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowcount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rowcount][colCount];
		for(int i=0; i<rowcount; i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			for(int j=0; j<colCount; j++)
			{
				XSSFCell cell = row.getCell(j);
				
				CellType cellType = cell.getCellType();
				switch(cellType) 
	               {
	               case STRING:
	            	   data[i][j] = cell.getStringCellValue();
	            	   break;
	               case NUMERIC:
	            	   data[i][j] = Integer.toString((int)cell.getNumericCellValue());
	            	   break;
	               case BOOLEAN:
	            	   data[i][j] = cell.getBooleanCellValue();
	               }
			}
		}
		return data;
	}
}
