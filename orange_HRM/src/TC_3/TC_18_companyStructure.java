package TC_3;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_18_companyStructure
{

	public static void main(String[] args)
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
		
		//create web elements for change password and logout
		WebElement CP=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Change Password")));
		WebElement logOut=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));
		if (CP.isDisplayed() && logOut.isDisplayed())
		{
		System.out.println("Change password and logout are displayed");	
		}
		//--------------------------------------------------------------------------------------------
		//webelement for admin
		WebElement objAdmin=driver.findElement(By.xpath("//*[@id='admin']/a/span"));
		//mouse over on Admin
		Act.moveToElement(objAdmin).perform();
		//-----------------------------------------------------------------
		//create webelement for company info,job,etc
		WebElement objCompanyInfo=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='admin']/ul/li[1]/a/span")));
		WebElement objJob=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='admin']/ul/li[2]/a/span")));
		WebElement objQualification=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='admin']/ul/li[3]/a/span")));
		//verify company info.,job,qualification,skills..etc
		if (objCompanyInfo.isDisplayed() && objJob.isDisplayed() && objQualification.isDisplayed() )
		{
			System.out.println("Verified Company Info and Job and Qualification ");
		}
		//---------------------------------------------------------------------------------------
		//mouse over on company info
		Act.moveToElement(objCompanyInfo).perform();
		//webElement to general,locations,structure ,properties
		WebElement objGeneral=driver.findElement(By.xpath("//*[@id='admin']/ul/li[1]/ul/li[1]/a/span"));
		WebElement objLocations=driver.findElement(By.xpath("//*[@id='admin']/ul/li[1]/ul/li[2]/a/span"));
		WebElement objStructure=driver.findElement(By.xpath(".//*[@id='admin']/ul/li[1]/ul/li[3]/a/span"));
		WebElement objProperties=driver.findElement(By.xpath("//*[@id='admin']/ul/li[1]/ul/li[4]/a/span"));
		//verify  general,locations,structure ,properties
		if (objGeneral.isDisplayed() && objLocations.isDisplayed() && objStructure.isDisplayed() && objProperties.isDisplayed()) 
		{
			System.out.println("Verified general,locations,structure ,properties ");
		}
		//click on company structure
		objStructure.click();
		driver.switchTo().frame("rightMenu");
		//verify page
		WebElement obj_title=driver.findElement(By.xpath("//html/body/div[1]/h2"));
		if (obj_title.isDisplayed()) 
		{
			System.out.println("company structure is displayed");
		}
		
		//click on add
		driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr[1]/td[2]/a")).click();
		//verify add a subdivisionn to qa planet
		WebElement obj_t2=driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/div/h3"));
		if (obj_t2.isDisplayed())
		{
			System.out.println("add a sub division page is displayed");
		}
		//enter all fields 
		WebElement obj_D=driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/form/input[4]"));
		obj_D.sendKeys("9909876543221");
		driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/form/input[5]")).sendKeys("NEW_NAME");
		//select from drop down
		//create web element for select class
		WebElement E=driver.findElement(By.name("cmbType"));
		//create select class object
		Select sel=new Select(E);
		sel.selectByValue("Department");
		//create web element for another select
		WebElement E1=driver.findElement(By.id("cmbLocation"));
		Select sel1=new Select(E1);
		sel1.selectByValue("LOC362");
		//click on save
		driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/form/div/input[1]")).click();
		
		//check in the list
		int Tab=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
		System.out.println(Tab);
		driver.findElement(By.linkText("ETL Testing Sravan Department")).sendKeys(Keys.DOWN);
		
		int i;
		for(i=1;i<=Tab;i++)
		{
			String s_name=driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]")).getText();
			
			//System.out.println(s_name);
			if (s_name.equals("9909876543221"+" NEW_NAME"+" Department")) 
			{
				System.out.println("verified in the list");
				driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+i+"]/td[1]")).click();
				break;
			}
		}
		//to edit company structure
		WebElement obj_name=driver.findElement(By.id("txtTitle"));
		obj_name.clear();
		String s="Company name";
		obj_name.sendKeys(s);
		//click on save
		driver.findElement(By.xpath("//html/body/div[2]/div[1]/div[2]/form/div/input[1]")).click();
		//to verify in the list
		int x=driver.findElements(By.xpath("//html/body/div[1]/table/tbody/tr")).size();
		System.out.println(x);
		driver.findElement(By.linkText("ETL Testing Sravan Department")).sendKeys(Keys.DOWN);
		//------------------------------------------------------------
		for(int y=1;y<=x;y++)
		{
			String str_new=driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+y+"]/td[1]")).getText();
			if (str_new.equals("9909876543221"+" Company name"+" Department")) 
			{
				System.out.println("name is present in the list");
				driver.findElement(By.xpath("//html/body/div[1]/table/tbody/tr["+y+"]/td[4]/a")).click();
				driver.switchTo().alert().accept();
				break;
			}
		}

	}

}
