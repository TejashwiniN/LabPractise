package practise;

import java.io.File;
import java.io.IOException;

public class Create_File
{

	public static void main(String[] args)throws  Exception
	{
		File x=new File("D:\\Login_Results.xls");
		if (!(x.exists()))
		{
			x.createNewFile();
		}
		if(x.exists()) {
			System.out.println("File Exists");
		}

	}

}
