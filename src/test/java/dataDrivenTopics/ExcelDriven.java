package dataDrivenTopics;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
	public static FileInputStream fir;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row ;
	public static XSSFCell cell;
	
	public static void main(String[] args) throws IOException {
		
		
		 
			String value=getdata(2,2);
			System.out.println(value);
			//String value1=getdata(3,4);
			//System.out.println(value1);
			
			System.out.println(value);

			}


	
		 public static String getdata(int rown, int column) throws IOException {
			 
		fir = new FileInputStream("C:\\Users\\RITHWIK\\My_Work2\\DataDrivenFrmwrk\\Login.xlsx");
		 wb= new XSSFWorkbook(fir);
		sheet = wb.getSheet("Sheet1");
		 row =sheet.getRow(2);
		 cell= row.getCell(2);
		 return cell.getStringCellValue();
	
		
		
	}
	
	
	

}
