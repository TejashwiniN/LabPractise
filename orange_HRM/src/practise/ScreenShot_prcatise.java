package practise;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class ScreenShot_prcatise
{

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Maximize browser
				driver.manage().window().maximize();
				//webdriver wait object
				WebDriverWait wait=new WebDriverWait(driver, 60);
				//Create object for actions class
				Actions Act=new Actions(driver);
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
		
		File xyz=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(xyz,new File("C:\\Users\\Lab\\Desktop\\New folder\\home1.png"));
		 driver.close();
		 driver.quit();
	

	}

}
