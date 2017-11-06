package vtiger_CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC_1
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//maximize window
		driver.manage().window().maximize();
		//create object for wait commands
		WebDriverWait wait=new WebDriverWait(driver, 60);
		//object for actions class
		Actions Act=new Actions (driver);
		//------------------------------------------
		//open application
		driver.get("http://classroom:8888/");
		//verify home page
		 boolean Homepage=wait.until(ExpectedConditions.titleIs("vtiger CRM 5 - Commercial Open Source CRM"));
		 if (Homepage) 
		 {
			System.out.println("Home Page is Displayed");
		}
		 //verify username
		WebElement obj_UN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
		if (obj_UN.isDisplayed()) 
		{
			System.out.println("username is displayed");
		}
		//verify password
		WebElement obj_PW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("user_password")));
		if (obj_PW.isDisplayed()) 
		{
			System.out.println("password  is displayed");
		}
		//mouse over to sign out
		//click on logout
		

	}

}
