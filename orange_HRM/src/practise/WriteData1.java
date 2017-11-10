package practise;






import java.io.File;
import java.sql.Driver;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class WriteData1 
{

	public static void main(String[] args)throws Exception
	{
		WritableWorkbook WB=Workbook.createWorkbook(new File("D:\\WB1.xls"));
		WritableSheet Sheet=WB.createSheet("new", 1);
		WritableSheet Sheet1=WB.createSheet("sheet2",0);
		Label L1= new Label(0, 0, "content");
		Label L2= new Label(0, 0, "empty");
		Sheet.addCell(L1);
		Sheet1.addCell(L2);
		WB.write();
		WB.close();
	
		
		
		
		
		
		
		
		
		
		
		/*WritableWorkbook WORKBOOK=Workbook.createWorkbook(new File("D:\\new.xls"));
		WritableSheet WSheet=WORKBOOK.createSheet("HRM", 0);
		WritableSheet WSheet1=WORKBOOK.createSheet("CRM", 1);
		Label l=new jxl.write.Label(0, 0, "abcd");
		WSheet.addCell(l);
		WORKBOOK.write();
		WORKBOOK.close();*/
	}

}
