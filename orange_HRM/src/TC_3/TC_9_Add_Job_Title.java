package TC_3;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_9_Add_Job_Title
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
				
				
				//-----------------------------------------------------------------------
				//click on JobTitles
				objJobTitles.click();
				driver.switchTo().frame("rightMenu");
				//verify company info page
				WebElement Job_Title=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[1]/h2")));
				if (Job_Title.isDisplayed())
				{
					System.out.println("Job_Title page is Displayed");
				}
				
				//create web elements for search by,search edit box,search button , reset,add,delete buttons
				
				WebElement objSearchBy=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loc_code']")));
				WebElement objSearchEditBox=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loc_name']")));
				WebElement objSearchButton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[2]")));
				WebElement objReset=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[2]/input[3]")));
				WebElement objAdd=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]")));
				WebElement objDelete=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[2]")));
				//verify search by,search edit box,search button , reset,add,delete buttons
				if (objSearchBy.isDisplayed() && objSearchEditBox.isDisplayed() && objSearchButton.isDisplayed() &&  objReset.isDisplayed() && objAdd.isDisplayed() && objDelete.isDisplayed()) 
				{
					System.out.println("Verified search by,search edit box,search button , reset,add,delete buttons");
				}
				//click on add
				objAdd.click();
				//verify Job_Title page
				WebElement objJob_TitlePage=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/div/h2")));
				if (objJob_TitlePage.isDisplayed())
				{
				System.out.println("verified Job_Title Page");	
				}
				//verify all fields
				WebElement objJob_Name=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/input[3]")));
				WebElement obj_Job_Description=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[2]/div[2]/form/textarea[1]")));
				WebElement obj_Job_Specifications=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/select[1]")));
				WebElement objSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/div[2]/input[1]")));
				WebElement objReset1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/div[2]/input[2]")));
			
				if (objJob_Name.isDisplayed() && obj_Job_Description.isDisplayed() && obj_Job_Specifications.isDisplayed() )
				{
					System.out.println("verified all fields");
				}
				
				/*//create reference object for alert
				Alert A1=driver.switchTo().alert();
				//verify alert message 
				if (A1.getText().equals("Job Title Name should be specified"))
				{
					System.out.println("alert is displayed");
					A1.accept();
				}*/
				//enter job title and click on save
				objJob_Name.sendKeys("Trainee");
				
				/*//create reference object for alert
				Alert A1=driver.switchTo().alert();
				//verify alert message 
				if (A1.getText().equals("Job Description should be specified"))
				{
					System.out.println("alert is displayed");
					A1.accept();
				}*/
				//enter job description and save
				obj_Job_Description.sendKeys("Trainee must undergo training for a couple of months");
				//click on save
				objSave.click();
				//verify employee status fields must be displayed
				WebElement obj_Employe_Status=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/select[3]")));
				WebElement obj_Employe_Status1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[2]/div[2]/div[2]/form/select[4]")));
				if (obj_Employe_Status.isDisplayed() && obj_Employe_Status1.isDisplayed())
				{
				System.out.println("employee status fields are displayed");	
				}
				//click on edit button
				driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/form/div[4]/input[1]")).click();
				//select employee status
				driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/form/select[3]/option")).click();
				
				//create select object
				Select sel=new Select(obj_Employe_Status1);
				//select item 
				sel.selectByVisibleText("Full Time Permanent");
				WebElement save1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/form/div[4]/input[1]"));
				WebElement name1=driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/form/input[3]"));
				name1.clear();
				name1.sendKeys("New Trainee");
				//click on save
				save1.click();
				
				
				//verify edited job title name in list
				int rc=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
			System.out.println(rc);
			
				for (int j=1;j<=rc;j++)
				{
					String table=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]")).getText();
					if (table.equals("New Trainee")) 
					{
						System.out.println("verified name in the list");
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a"));
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr/td[1]/input")).click();
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[4]/div[1]/input[2]")).click();
						driver.switchTo().alert().accept();
						WebElement message=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[2]/span")));
						if (message.isDisplayed())
						{
							System.out.println("successfully deleted message is displayed");
							
						}

						break;
					}
					
				}
					//------------------------------------------------------------------------------------
				
				
				
				//wait until message deleted displayed
				

	}

}
