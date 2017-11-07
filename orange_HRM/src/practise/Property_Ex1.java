package practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Property_Ex1 
{

	public static void main(String[] args)throws Exception 
	{
		Properties obj=new Properties();
		obj.load(new FileInputStream("C:\\Users\\Lab\\git\\LabPractise\\orange_HRM\\src\\webDriverEx\\example.property"));
		String Surl=obj.getProperty("URl");
		String UN=obj.getProperty("UN");
		String PW=obj.getProperty("PW");
		//--------------------------------------
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		//************************************
		WebDriver driver=new ChromeDriver();
	     
	     driver.navigate().to(Surl);
	     driver.manage().window().maximize();
	     Thread.sleep(2000);
	     driver.findElement(By.name("txtUserName")).clear();
	     driver.findElement(By.name("txtUserName")).sendKeys(UN);
	     driver.findElement(By.name("txtPassword")).sendKeys(PW);
	     driver.findElement(By.name("Submit")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();		
			driver.close();
			driver.quit();
	}

}
