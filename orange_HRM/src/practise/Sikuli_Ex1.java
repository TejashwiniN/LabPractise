package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Sikuli_Ex1 
{

	public static void main(String[] args)throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//To Maximize Browser
		//driver.manage().window().maximize();
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		
		Screen screen=new Screen();
		Pattern File_UN=new Pattern("D:\\orange_hrm.sikuli\\USERNAME.png");
		Pattern File_PW=new Pattern("D:\\orange_hrm.sikuli\\passWord.png");
		//Pattern File_LogIn=new Pattern("D:\\orange_hrm.sikuli\\login.png");
		screen.type(File_UN,"qaplanet1");
		screen.type(File_PW,"lab1");


	}

}
