package webDriverEx;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class example
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "F:\\D-Drive\\FromC\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//Maximize browser
		Driver.manage().window().maximize();
		//webdriver wait object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//Create object for actions class
		Actions Act=new Actions(Driver);
		//----------------------------------------------------------------------------
		//Open application
		Driver.get("http://classroom:90/qahrm/login.php");
		//wait for home page
		boolean blnHomePageres=wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//Verify home page 
		if(blnHomePageres)
		{
			System.out.println("Home Page displayed");
		}
		else
		{
			System.out.println("Failed to display home page");
			return;
		}
		//Create webelements for user name,password,login and clear
		WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
		WebElement objPWD=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
		WebElement objLogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
		WebElement objClear=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
		//--------------------------------------------------------------------------
		//Verify user name
		if(objUN.isDisplayed())
		{
			System.out.println("user name displayed");
		}
		//Verify password
		if(objPWD.isDisplayed())
		{
			System.out.println("Password displayed");
		}
		//Verify login and clear
		if(objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("Login and clear");
		}
		//----------------------------------------------------------------------------------
		String strUN="qaplanet1";
		String strPWD="user1";
		//--------------------------------------------------------------------------------
		//Enter user name
		objUN.clear();
		objUN.sendKeys(strUN);
		//Enter password
		objPWD.clear();
		objPWD.sendKeys(strPWD);
		//Click on login
		objLogin.click();
		//wait for OrangeHRM
		wait.until(ExpectedConditions.titleIs("OrangeHRM"));
		//Verify OrangeHRM
		if(Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("OrangeHRM displayed");
		}			
		else
		{
			System.out.println("Failed to login");
			return;
		}
		//------------------------------------------------------------------------------
		//Get Welcome qaplanet1
		String sWelText=Driver.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
		//Verify Welcome qaplanet1
		if(sWelText.equals("Welcome "+strUN))
		{
			System.out.println("Welcome "+strUN+" displayed");
		}
		//Way 2: Verify only user name
		String[] Arr=sWelText.split(" ");
		//Verify user name
		if(Arr[1].equals(strUN))
		{
			System.out.println(strUN+" displayed");
		}		
		//Create web elements for change password and logout
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));
		//Verify change password and logout
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("change password and logout are displayed");
		}
		//------------------------------------------------------------------------------
		//WebElement for PIM
		WebElement objPIM=Driver.findElement(By.id("pim"));
		//Mouse over on PIM
		Act.moveToElement(objPIM).perform();
		//click on add employee
		Driver.findElement(By.linkText("Add Employee")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		//Verify PIM : Add Employee text
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("PIM : Add Employee"))
		{
			System.out.println("PIM : Add Employee displayed");
		}
		//=-=-----------------------------------------------------
		//Get Employee code
		String sEmpCode=Driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
		//----------------------------------------------------------------------------------
		String sFN="Sreedhar";
		String sLN="M";
		//----------------------------------------------------------------------------
		//Create webelement for Save button'
		WebElement objSave=Driver.findElement(By.id("btnEdit"));
		//Keep all fields as blank and click on submit
		objSave.click();
		//wait for alert 
		Alert A=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message as Last Name Empty!
		if(A.getText().equals("Last Name Empty!"))
		{
			System.out.println("Last Name Empty! alert displayed");
			A.accept();
		}
		//Enter last name
		Driver.findElement(By.name("txtEmpLastName")).sendKeys(sLN);
		//click on save
		objSave.click();
		//wait for alert 
		Alert A1=wait.until(ExpectedConditions.alertIsPresent());
		//Verify alert message as First Name Empty!
		if(A1.getText().equals("First Name Empty!"))
		{
			System.out.println("First Name Empty! alert displayed");
			A1.accept();
		}
		//Enter first name
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);	
		//click on save
		objSave.click();
		//Verify Personal Details text
		boolean blnPersonalDetails=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='mainHeading']/h2"), "Personal Details"));
		if(blnPersonalDetails)
		{
			System.out.println("Personal Details text displayed");
		}
		//switch to top frame
		Driver.switchTo().parentFrame();
		//-----------------------------------------------------------------------------
		//Mouse over on PIM
		Act.moveToElement(objPIM).perform();
		//click on Employee List
		Driver.findElement(By.linkText("Employee List")).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		//Verify Employee Information text
		if(Driver.findElement(By.xpath("//div[@class='mainHeading']/h2")).getText().equals("Employee Information"))
		{
			System.out.println("Employee Information displayed");
		}		
		//-----------------------------------------------------------------------------
		//Get row count
		int rc=Driver.findElements(By.xpath("//table[@class='data-table']/tbody/tr")).size();
		int i;
		for(i=1;i<=rc;i++)
		{
			//Get second column data
			String sEmpID=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[2]")).getText();
			//Get third column data
			String sEmpName=Driver.findElement(By.xpath("//table[@class='data-table']/tbody/tr["+i+"]/td[3]/a")).getText();
			if(sEmpCode.equals(sEmpID) && sEmpName.equals(sFN+" "+sLN))
			{
				System.out.println(sEmpCode+" "+sEmpName+" displayed at: "+i);
				break;
			}
		}
		//Switch to top frame
		Driver.switchTo().defaultContent();
		//------------------------------------------------------------------------------
		//Click on Logout
		objLogout.click();
		//wait for home page
		wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management"));
		//Verify home page 
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Sign off sucessfull & Home Page displayed");
		}
		//-----------------------------------------------------------------------------
		Driver.close();
		Driver.quit();		
	}
}

