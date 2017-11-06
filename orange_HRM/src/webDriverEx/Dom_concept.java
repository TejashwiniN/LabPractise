package webDriverEx;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Dom_concept 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//open application
		driver.get("http://classroom:90/qahrm/login.php");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String jsUN="document.getElementsByName('txtUserName')[0].value='qaplanet1'";
		
		//String name="document.getElementsByName('txtUserName')[0].value='qaplanet1'";
		js.executeScript(jsUN);
		String jsPW="document.getElementsByName('txtPassword')[0].value='user1'";
		js.executeScript(jsPW);
		driver.findElement(By.cssSelector("input.button")).click();
		
		

	}

}
