package webDriverEx;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ReadMultipleRows
{

	public static void main(String[] args)throws Exception
	{
		File f1=new File("C:\\Users\\Lab\\Desktop\\Book1.xls");
		Workbook WB=Workbook.getWorkbook(f1);
		Sheet sheet=WB.getSheet("example");
		int row=sheet.getRows();
		int column=sheet.getColumns();
		
		for(int i=0;i<row;i++)
		{
			
			String str=sheet.getCell(0,i).getContents();
			System.out.println(str);
		}
		

	}

}
