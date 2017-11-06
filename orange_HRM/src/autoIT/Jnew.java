package autoIT;

import com.jacob.com.LibraryLoader;

import autoitx4java.AutoItX;

public class Jnew
{

	public static void main(String[] args)
	{
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, "C:\\Users\\Lab\\Desktop\\New folder\\jacob-1.18-x86.dll");
		//create object for AutoIT
		AutoItX x=new AutoItX();
		x.run("notepad.exe");
		x.winWaitActive("Untitled - Notepad");
		//verify notepad window
		if (x.winExists("Untitled - Notepad"))
		{
			System.out.println("note pad verified");
		}
		
		x.send("hello");
		x.winClose("Untitled - Notepad");

	}

}
