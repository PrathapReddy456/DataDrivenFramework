package dataDrivenTopics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SetCellData {
	public static FileInputStream fir;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row ;
	public static XSSFCell cell;
	
	public static void main(String[] args) throws IOException {
		
		
			String value=setdata("test987"2,2);
			System.out.println(value);
			}


	
		 public static String setdata(int rown, int column) throws IOException {
			 
		fir = new FileInputStream("C:\\Users\\RITHWIK\\My_Work2\\DataDrivenFrmwrk\\Login.xlsx");
		 wb= new XSSFWorkbook(fir);
		sheet = wb.getSheet("Sheet1");
		 row =sheet.getRow(2);
		 cell= row.getCell(2);
		 cell.setCellValue(value);
		 String celldata1 = cell.getStringCellValue();
		 return celldata1;
	
		
		
	}
	
}
