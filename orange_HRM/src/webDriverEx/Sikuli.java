package webDriverEx;

import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli
{

	public static void main(String[] args) throws Exception 
	{
				App.open("calc.exe");
				
				Screen x=new Screen();
				//verify calc window
				if (x.exists("D:\\123456.sikuli\\claC.png") != null)
				{
					System.out.println("Calc window displayed");
				}
				//click on calc
				x.click("D:\\123456.sikuli\\claC.png");
				//click on 7
				x.click("D:\\123456.sikuli\\seven.png");
				
				//click on *
				x.click("D:\\123456.sikuli\\multiply.png");
				//click on 3
				x.click("D:\\123456.sikuli\\three.png");
				//click on equal
				x.click("D:\\123456.sikuli\\equals.png");
				Thread.sleep(1000);
				
				App.close("calc.exe");
			}
		

	}


