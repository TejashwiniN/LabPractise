package TC_3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AWT_1 
{

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//To Maximize Browser
		//driver.manage().window().maximize();
		//webdriver wait object
		WebDriverWait wait=new WebDriverWait(driver,60);
		//actions class
		Actions Act=new Actions(driver);
		
		//----------------------------------------------------------------
		//open application
		driver.get("http://classroom:90/qahrm/login.php");
		//verify title
		boolean title=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		if (title) 
		{
			System.out.println("Home Page Displayed");	
		}
		//create web elements for un,pwd ,login,clear
		WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement objLI=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		WebElement objCL=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
		//verify un
		if (objUN.isDisplayed())
		{
			System.out.println("User name displayed");
		}
		//verify password
		if (objPW.isDisplayed())
		{
		System.out.println("Password is Displayed");	
		}
		//verify Login and Clear buttons
		if (objLI.isDisplayed() && objCL.isDisplayed())
		{
			System.out.println("Login and Clear Buttons are displyed");
		}
		//--------------------------------------------------------------------------
		String sUN="qaplanet1";
		String sPW="user1";
		//------------------------------------------------------------------------
		objUN.clear();
		objUN.sendKeys(sUN);
		//-------------------------------------------------------------------------
		objPW.clear();
		objPW.sendKeys(sPW);
		//-----------------------------------------------------------------------
		objLI.click();
		//----------------------------------------------------------------------------
		//wait for Orange_HRM
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		if (driver.getTitle().equals("OrangeHRM")) 
		{
		System.out.println("OrangeHRM is Displayed");	
		}
		else
		{
		System.out.println("Failed to Login");	
		}
		//-------------------------------------------
		//verify welcome ,change pwd,logout
		String sqa=driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//verify welcome qaplanet1
		if (sqa.equals("Welcome "+ sUN))
		{
			System.out.println("welcome "+sUN+"is displayed");
		}
		
		//create web elements for change password and login
		WebElement CP=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Change Password")));
		WebElement logOut=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
		if (CP.isDisplayed() && logOut.isDisplayed())
		{
		System.out.println("Change password and logout are displayed");	
		}
		//-------------------------------------------------------------
		//webElement for PIM
		WebElement objPIM=driver.findElement(By.id("pim"));
		Act.moveToElement(objPIM).perform();
		//click on add employee
		driver.findElement(By.linkText("Add Employee")).click();
		//wait for frame and shift to it 
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		if (driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee")) 
		{
		System.out.println("PIM : Add Employee is displayed");	
		}
		else {
			System.out.println("add employee not found");
		}
		//------------------------------------------------
		String sFN="Tejashwini";
		String sLN="N";
		//----------------------------------------
		//create wwebelement  for save button
		WebElement objSave=driver.findElement(By.id("btnEdit"));
		
		//enter last name
				driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//enter first name 
				driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
				
				
				
				//create object for robot class
				Robot rt= new Robot();
				//click on photo file
				WebElement objBrowse=driver.findElement(By.name("photofile"));
				objBrowse.click();
				// load image path file
				StringSelection ss=new StringSelection("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
				//select image path to default window
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				rt.delay(1000);
				//-----------------------
				//rt.keyPress(keycode);
				rt.keyPress(KeyEvent.VK_CONTROL);
				rt.keyPress(KeyEvent.VK_V);
				
				rt.keyRelease(KeyEvent.VK_V);
				rt.keyRelease(KeyEvent.VK_CONTROL);
				rt.delay(2000);
				rt.keyPress(KeyEvent.VK_ENTER);
				rt.delay(1000);
				rt.keyRelease(KeyEvent.VK_ENTER);
				rt.delay(1000);
				
				
				objSave.click();
				
				
				
				
				
	}

}
