package TC_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_12_JoBSpecification 
{

	public static void main(String[] args) throws Exception 
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
		//---------------------------------------------
		//mouse over on job
		Act.moveToElement(objJob).perform();
		//webElement to job title,job specification,paygrade
				WebElement objJobTitles=driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[2]/ul/li[1]/a/span"));
				WebElement objJobSpecifications=driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[2]/ul/li[2]/a/span"));
				WebElement objPayGrades=driver.findElement(By.xpath(".//html/body/div[4]/ul/li[1]/ul/li[2]/ul/li[2]/a/span"));
				WebElement objEmploymentStatus=driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[2]/ul/li[4]/a/span"));
				//verify  general,locations,structure ,properties
				if (objJobTitles.isDisplayed() && objJobSpecifications.isDisplayed() && objPayGrades.isDisplayed() && objEmploymentStatus.isDisplayed()) 
				{
					System.out.println("Verified job title,job specification,paygrade ");
				}
				
				//click on job specification
				objJobSpecifications.click();
				//switch to frame
				driver.switchTo().frame("rightMenu");
				//for add button
				WebElement AddButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]")));
				AddButton.click();
				String objName="apple";
				//for name
				WebElement Name_1=driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/input[3]"));
				Name_1.sendKeys(objName);
				//save button
				driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div[2]/input[1]")).click();
				//------------------------------------------------------
				//check in the list
				int size=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
				System.out.println(size);
				int j;
				for ( j=1; j<=size; j++)
				{
					String ssName=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
					if (ssName.equals(objName)) 
					{
						System.out.println("verified");
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).click();
					}
					
				}
				//click on edit
				driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div[2]/input[1]")).click();
				//rename
				WebElement obj_NEW=driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/input[3]"));
				obj_NEW.clear();
				String bb="CHANGED_NAME1";
				obj_NEW.sendKeys(bb);
				//click on save
				driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div[2]/input[1]")).click();
				//delete the saved name
				int x=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
				int y;
				for(y=1;y<=x;y++)
				{
					String aa=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+y+"]/td[3]/a")).getText();
					if (aa.equals(bb))
					{
						//click on checkBox
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+y+"]/td[1]/input")).click();
					//click on delete button
					driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[4]/div[1]/input[2]")).click();
					break;
					}
				}
				driver.switchTo().alert().accept();
				
			
			
				
				
	

}}