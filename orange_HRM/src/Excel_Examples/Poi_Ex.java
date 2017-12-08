package Excel_Examples;


import java.io.FileOutputStream;




import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Poi_Ex 
{

	public static void main(String args[]) throws Exception
	{

		/*XSSFWorkbook wb=new XSSFWorkbook();
		FileOutputStream fileOut=new FileOutputStream("D:\\practise Sheet.xlsx.xlsx");
		wb.write(fileOut);
		fileOut.close();
		wb.close();*/
		
		
		
		
		
		 	XSSFWorkbook wb = new XSSFWorkbook();
		    FileOutputStream fileOut = new FileOutputStream("C:\\Users\\admin\\Documents\\Book1.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
	}
}
