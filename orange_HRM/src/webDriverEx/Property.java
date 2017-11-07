package webDriverEx;


import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Property 
{
	public static void main(String[] args)throws Exception
	{
		Properties obj=new Properties();
		obj.load(new FileInputStream("C:\\Users\\Lab\\git\\LabPractise\\orange_HRM\\src\\webDriverEx\\example.property"));
		String strurl=obj.getProperty("URl");
		String strUN=obj.getProperty("UN");
		String strPWD=obj.getProperty("PW");	
		//************************************
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		//************************************
		WebDriver Br=new ChromeDriver();
		Br.navigate().to(strurl);
		Thread.sleep(2000);
		Br.findElement(By.name("txtUserName")).clear();
		Br.findElement(By.name("txtUserName")).sendKeys(strUN);
		Br.findElement(By.name("txtPassword")).sendKeys(strPWD);
		Br.findElement(By.name("Submit")).click();
		Thread.sleep(2000);
		Br.findElement(By.linkText("Logout")).click();		
		Br.close();
		Br.quit();	
		
	}
}


