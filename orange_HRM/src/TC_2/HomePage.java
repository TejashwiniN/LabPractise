package TC_2;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage
{

	public static void main(String[] args)throws Exception 
	{
		System.setProperty("webdriver.gecko.driver", "D:\\tet\\Selenium_Demp\\geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		//To Maximize Browser
		driver.manage().window().maximize();
		//To open web page
		driver.get("http://classroom:90/qahrm/login.php");
		Thread.sleep(2000);
		//webDriver wait object
		WebDriverWait wait =new WebDriverWait(driver, 60);
		//create object for actions class
		Actions Act=new Actions(driver);
		
		boolean res=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		if(res)
		{
		System.out.println("home page is displayed");
		}
		//Verify UN,PWD,LOGIN,CLEAR are displayed
		boolean yes=driver.findElement(By.name("txtUserName")).isDisplayed();
		if(yes)
		{
			System.out.println("UserName is Displayed");
		}
		
		//pwd displayed
		boolean pwd=driver.findElement(By.name("txtPassword")).isDisplayed();
		if(pwd)
		{
			System.out.println("Password is Displayed");
		}
		//login displayed
		boolean log=driver.findElement(By.name("Submit")).isDisplayed();
		if(log)
		{
			System.out.println("Login is Displayed");
		}
		boolean clr=driver.findElement(By.name("clear")).isDisplayed();
		if(clr)
		{
			System.out.println("Clear Button is Displayed");
		}
		//-----------------------------------------------------------
		
		WebElement E=driver.findElement(By.name("txtUserName"));
		E.clear();
		E.sendKeys("qaplanet1");
		WebElement P=driver.findElement(By.name("txtPassword"));
		P.clear();
		P.sendKeys("user1");
		WebElement L=driver.findElement(By.name("Submit"));
		L.sendKeys(Keys.ENTER);
		//-------------------------------------------------------------
		Thread.sleep(2000);
		
		boolean W1=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id='option-menu']/li[1]"), "Welcome qaplanet1"));

		if(W1)
		{
			System.out.println("Welcome text Displayed");
		}
		boolean C=driver.findElement(By.linkText("Change Password")).isDisplayed();
		if(C)
		{
			System.out.println("Change password is displayed");
		}
		boolean W2=driver.findElement(By.linkText("Logout")).isDisplayed();
		if(W2)
		{
			System.out.println("Logout is displayed");
		}
		//------------------------------------------------------------------
		
		
		
				
	}

}
