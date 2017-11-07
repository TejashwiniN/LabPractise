package Excel_Examples;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class Ex_2 {

	public static void main(String[] args)throws Exception
	{
		//to take input from files
		File F1=new File("C:\\Users\\Lab\\Desktop\\Book1.xls");
		//to load workbook
		Workbook WB_1=Workbook.getWorkbook(F1);
		//to go to specific sheet
		Sheet Sheet=WB_1.getSheet("example");
		String S1=Sheet.getCell(1,1).getContents();
		System.out.println(S1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*//to take input from files
		File EXCEL=new File("C:\\Users\\Lab\\Desktop\\Book1.xls"); 
		//to load work book
		
		Workbook Book=Workbook.getWorkbook(EXCEL);
		//to get specific sheet
		Sheet Sheet1=Book.getSheet("example");
		String s1=Sheet1.getCell(1,0).getContents();
		System.out.println(s1);
*/
	}

}
