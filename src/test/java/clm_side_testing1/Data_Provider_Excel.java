package clm_side_testing1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.DataProvider;

import clm_side_testing1.XLUtility;

public class Data_Provider_Excel {
	
	
	@DataProvider(name="LoginData")
	public Object [][] getData() throws Exception
	{
		String path = "D:\\New folder (2)\\ExcelFile.xlsx";

		int rows = XLUtility.getRowCount(path, "Sheet1");
		int columns = XLUtility.getCellCount(path, "Sheet1", 1);

		String[][] empdata = new String[rows][columns];

		for (int i = 1; i <= rows; i++) 
		{
			for (int j = 0; j <columns; j++)
			{
				empdata[i - 1][j] = XLUtility.getCellData(path, "Sheet1", i, j);
			}
		}

		return empdata;
        
	}
	
	 public String[][] getExcelData(String fileName, String sheetName) throws IOException 
	 {
	        String[][] data = null;
	        try {
	 
	            FileInputStream fis = new FileInputStream(fileName);
	            
	            XSSFWorkbook workbook = new XSSFWorkbook(fis);
	            
	            XSSFSheet sheet = workbook.getSheet(sheetName);
	            
	            XSSFRow row = sheet.getRow(0);
	            
	            int noOfRows = sheet.getPhysicalNumberOfRows();
	            
	            int noOfCols = row.getLastCellNum();
	            
	            Cell cell;
	            
	            data = new String[noOfRows - 1][noOfCols];
	 
	            for (int i = 1; i < noOfRows; i++) {
//	                for (int j = 0; j < noOfCols; j++) {
	                    row = sheet.getRow(i);
	                   // cell = row.getCell(j);
	                    data[i - 1][0] = row.getCell(0).getStringCellValue();
	                    data[i - 1][1] = row.getCell(1).getStringCellValue();
	             //   }
	            }
	        } catch (Exception e) {
	            System.out.println("The exception is: " + e.getMessage());
	        }
	        return data;
	  }

	

}
