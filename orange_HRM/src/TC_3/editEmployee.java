package TC_3;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editEmployee
{

	public static void main(String[] args)throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//To Maximize Browser
		driver.manage().window().maximize();
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
		//get employee code
		String sEmpCode=driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		//-------------------------------------------------------
		String sFN="Tejashwini";
		String sLN="N";
		//----------------------------------------
		//create wwebelement  for save button
		WebElement objSave=driver.findElement(By.id("btnEdit"));
		//keep all fields as blank and click on save
		objSave.click();
		//wait for alert
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		//verify alert message as Last Name Empty!
		if (A.getText().equals("Last Name Empty!"))
		{
			System.out.println("alert is displayed");
			A.accept();
		}
		
		//enter last name
		driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//click on save
		objSave.click();
		//verify alert displayed
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//verify alert message
		if (A1.getText().equals("First Name Empty!"))
		{
		System.out.println("alert is displayed");
		A1.accept();
		}
		//enter first name 
		driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
		//click on save
		objSave.click();
		//verify personal details page displayed
		boolean blnPersonalDetails=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details"));
		if (blnPersonalDetails) 
		{
			System.out.println("Personal Details displayed");
		}
		//switch frame
		driver.switchTo().parentFrame();
		//focus on PIM
		Act.moveToElement(objPIM).perform();
		driver.findElement(By.linkText("Employee List")).click();
		//switch to frame
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		//verify
		
		if (driver.findElement(By.xpath("//div[@ class='mainHeading']/h2")).getText().equals("Employee Information"));
		{
		System.out.println("Employee Information is displayed");	
		}
		//---------------------------------------------------
		//get row count
		int rc=driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for (i=1;i<=rc;i++) 
		{
			//get second column data
			String sEmpId=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			//get third column data
			String sEmpName=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if (sEmpCode.equals(sEmpId) && sEmpName.equals(sFN+" "+sLN))
			{
				System.out.println(sEmpCode+" "+sEmpName+" is displayed at:" +i);
				driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).click();
			break;
			}
		}
		//-----------------------------------------------------------------------------------------
		//click on edit button
		WebElement objEdit=driver.findElement(By.name("EditMain"));
		objEdit.click();
		//--------------------------------------------------------------------------------------------
		//make changes in first name
		WebElement objE=driver.findElement(By.name("txtEmpFirstName"));
		objE.clear();
		objE.sendKeys("teja");
		//--------------------------------------------------------------------------------------------------
		WebElement objEdit1=driver.findElement(By.name("EditMain"));
		objEdit1.click();
		//----------------------------------------------------------------------------------------------------
		//switch frame
				driver.switchTo().parentFrame();
				//focus on PIM
				Act.moveToElement(objPIM).perform();
				driver.findElement(By.linkText("Employee List")).click();
				//switch to frame
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
				//verify
				
				if (driver.findElement(By.xpath("//div[@ class='mainHeading']/h2")).getText().equals("Employee Information"));
				{
				System.out.println("Employee Information is displayed");	
				}
				//---------------------------------------------------
				//get row count
				int rc1=driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
				int j;
				for (j=1;j<=rc1;j++) 
				{
					//get second column data
					String sEmpId=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+j+"]/td[2]")).getText();
					//get third column data
					String sEmpName=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+j+"]/td[3]/a")).getText();
					if (sEmpCode.equals(sEmpId) && sEmpName.equals("teja"+" "+sLN))
					{
						System.out.println(sEmpCode+" "+sEmpName+" is displayed at:" +i);
					break;
					}
				}
				/*driver.manage().timeouts().implicitlyWait(arg0, arg1)
				driver.manage().timeouts().setScriptTimeout(arg0, arg1)
				driver.manage().timeouts().pageLoadTimeout(arg0, arg1)*/
		/*
		WebElement steja=driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr[1]/td[2]"));
		Act.moveToElement(steja).perform();
		Thread.sleep(5000);
		//----------------------------------
	
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*//shift frame
		driver.switchTo().defaultContent();
		//click on logout
		logOut.click();
		//wait for home page
				wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
				//Verify home page 
				if(driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
				{
					System.out.println("Sign off sucessfull & Home Page displayed");
				}

				//--------------------------------------
				driver.close();
				driver.quit();*/
				
	}

}
