package Excel_Examples;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class Ex_1 
{

	public static void main(String[] args)throws Exception
	{
		//to tak efiles as input
		File f1=new File("C:\\Users\\admin\\Desktop\\Book1.xls");
		//Load workbook
		Workbook WB=Workbook.getWorkbook(f1);
		//Get specific sheet
		Sheet S1=WB.getSheet("example");
		int i=0;
		//sheet.getcell(Column index,row index)
		String grow=S1.getCell(0,i).getContents();
		System.out.println(grow);
		System.out.println("hello");

	}
	

}
