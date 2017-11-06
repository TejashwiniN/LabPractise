package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllLinksInOrange_HRM
{

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("http://classroom:90/qahrm");

		WebElement oUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement oPW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement oLIN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		//-------------------------------------------------------------------------
		String sUn="qaplanet1";
		String sPW="user1";
		//------------------------------------------------------------
		//For Username
		
		oUN.clear();
		oUN.sendKeys(sUn);
		//for password
		oPW.clear();
		oPW.sendKeys(sPW);
		//for login
		oLIN.click();
		List<WebElement> list=driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
    	{
			String s_list=list.get(i).getText();
			System.out.println(s_list);
			
		}

	}

}
