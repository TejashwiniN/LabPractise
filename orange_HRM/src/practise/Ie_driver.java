package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ie_driver
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.ie.driver", "D:\\tet\\Selenium_Demp\\IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		WebDriverWait wait=new WebDriverWait(driver, 60);
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
		
}

}
