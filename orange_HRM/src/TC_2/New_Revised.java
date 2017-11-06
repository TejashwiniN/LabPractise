package TC_2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class New_Revised
{

	public static void main(String[] args)throws Exception 
	{
       System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		//To Maximize Browser
		driver.manage().window().maximize();
		//To open application
		driver.get("http://classroom:90/qahrm/login.php");
		Thread.sleep(2000);
		//webDriver wait object
		WebDriverWait wait =new WebDriverWait(driver, 60);
		//create object for actions class
		Actions Act=new Actions(driver);
		//wait for home page
		boolean res=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		if(res)
		{
		System.out.println("home page is displayed");
		}
		//create webElements for UN,PWD,LOGIN,CLEAR
		WebElement oUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement oPW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement oLIN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		WebElement oCL=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
		
		// verify UN
		if (oUN.isDisplayed())
		{
			System.out.println("User name Displayed");
		}
		//verify PW
		if (oPW.isDisplayed()) 
		{
			System.out.println("Password is Displayed");
		}
		//verify LIN and CL
		if (oLIN.isDisplayed() && oCL.isDisplayed() ) 
		{
			System.out.println("Login and Clear are displayed");
			
		}
		//------------------------------------------------------------
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
		//wait for OrangeHRM
		boolean title=wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		if (driver.getTitle().equals("OrangeHRM"))
		{
		System.out.println("title is displayed");
		}
		//get qaplanet1
		String sqa=driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//verify welcome qaplanet1
		if (sqa.equals("Welcome "+ sUn))
		{
			System.out.println("welcome "+sUn+"is displayed");
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
			}
		}
		//shift frame
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
		driver.quit();
		
		
		}
			}

