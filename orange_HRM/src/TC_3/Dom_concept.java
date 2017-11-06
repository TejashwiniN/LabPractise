package TC_3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dom_concept 
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//open application
				driver.get("http://classroom:90/qahrm/login.php");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor) driver;
	   String name="document.getElementsByName('txtUserName')[0].value='qaplanet1'";
	   js.executeScript(name);

	}

}
