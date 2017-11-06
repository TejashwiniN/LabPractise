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

public class TC_5_AddLocation
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
		//click on locations
		objLocations.click();
		driver.switchTo().frame("rightMenu");

		//verify company info page
		WebElement comp_info=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/form/div[1]/h2")));
		if (comp_info.isDisplayed())
		{
			System.out.println("Company info. page is Displayed");
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
		
		//verify locations page
		WebElement objLoc_Page=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[3]/div[2]/div/h2")));
		if (objLoc_Page.isDisplayed())
		{
		System.out.println("verified locations page");	
		}
		//verify all fields
		WebElement objName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='txtLocDescription']")));
		if (objName.isDisplayed()) 
		{
		System.out.println("Name field is displayed");	
		}
		//----
		WebElement objCountry=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='cmbCountry']")));
		WebElement objAddress=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='txtAddress']")));
		WebElement objZipCode=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='txtZIP']")));
		WebElement objSave=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='editBtn']")));
		WebElement objReset1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='frmLocation']/div[2]/input[2]")));
	
		if (objCountry.isDisplayed() && objAddress.isDisplayed() && objZipCode.isDisplayed() )
		{
			System.out.println("verified all fields");
		}
		
		/*//create reference object for alert
				Alert A1=driver.switchTo().alert();
				//verify alert message 
				if (A1.getText().equals("Please correct the following\n\n	- Location Name has to be specified\n	- Country should be selected!\n	- Address should be specified\n	- Zip Code should be specified\n"))
				{
					System.out.println("alert is displayed");
					A1.accept();
				}*/
				//Create WebElement for DropDown
				WebElement E=driver.findElement(By.name("cmbCountry"));
				
				//create select object
				Select sel=new Select(E);
				
				//_ _ _ _ _ _ _ _ _
				//Select item by using visible text
				sel.selectByValue("IN");
				Thread.sleep(2000);
				
				//-----------------------------------------------------
				String strName="name";
				//enter only name and check pop up message
			    WebElement objName1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='txtLocDescription']")));
			    objName1.sendKeys(strName);
			
				/*//verify alert message
				if (A1.getText().equals("Please correct the following\n\n	- Address should be specified\n	- Zip Code should be specified\n")) 
				{
					System.out.println("Address and zip code alert verified");
				}*/
				//enter address and save
				String Add="new_address";
				objAddress.sendKeys(Add);
		
				
				/*//verify alert message
				if (A1.getText().equals("Please correct the following\n\n	- Zip Code should be specified\n")) 
				{
					System.out.println("only zip code alert verified");
				}*/
				
				//enter zip code
				String str="1234";
				objZipCode.sendKeys(str);
				
				//click on save
				objSave.click();	
				Thread.sleep(2000);
				//----------------------------------------------
				//get row count
				int rc1=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
				System.out.println(rc1);
				int i;
				for (i=1;i<=rc1;i++) 
				{
					//get third column data
					String sNAME=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
					if (sNAME.equals(strName)) 
					{
						System.out.println("Given name verified in the list  .......");
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
						break;
					}

				}
				
				
				//click on edit button
				WebElement objEdit=driver.findElement(By.id("editBtn"));
				objEdit.click();
				//--------------------------------------------
				//create object for name
				WebElement objEditName=driver.findElement(By.name("txtLocDescription"));
				objEditName.clear();
				objEditName.sendKeys("New");
				WebElement objS=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/form/div[2]/input[1]"));
				objS.click();
				Thread.sleep(2000);
				
			//get row count
				int rc2=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
				int j;
				for (j=1;j<=rc2;j++) 
				{
					
						driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[1]/input")).click();
					 
					  
					  driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr[5]/td[1]/input")).click();
					  driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[4]/div[1]/input[2]")).click();

						driver.switchTo().alert().accept();
						
					WebElement msg=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/form/div[2]/span")));
					if (msg.isDisplayed())
					{
						System.out.println("succesfully deleted");
					}

				
	}

}}


	








