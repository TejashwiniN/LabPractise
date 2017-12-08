package TC_3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_15_AddQualification
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
		//---------------------------------------------------------------------
		//focus on qualification
	      Act.moveToElement(objQualification).perform();
	      //verify education and click on it
	      driver.findElement(By.xpath("//html/body/div[4]/ul/li[1]/ul/li[3]/ul/li[1]/a/span")).click();
	      //switch to frame
	      driver.switchTo().frame("rightMenu");
	      //find add button and click it
	      driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[3]/div[1]/input[1]")).click();
	      //verify institute and type name
	      WebElement obj_NAME=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/div[2]/form/input[2]")));
	      obj_NAME.click();
	      obj_NAME.sendKeys("INSTITUTE_NAME123");
	      //verify course name and enter it
	      WebElement obj_COURSE=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[1]/div[2]/div[2]/form/input[3]")));
	      obj_COURSE.click();
	      String objN="COURSE_NAME123";
	      obj_COURSE.sendKeys(objN);
	      //click on save button
	      WebElement obj_SAVE=driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div/input[1]"));
	      obj_SAVE.click();
	      //check in the list
	      int table=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
	      System.out.println(table);
	      int i;
	      for(i=1;i<=table;i++)
	      {
	    	 String s_table= driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).getText();
	    	 if (s_table.equals(objN))
	    	 {
				System.out.println("course is present in the list");
				driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+i+"]/td[3]/a")).click();
				break;
			}
	      }
	      //click on edit button
	      driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div/input[1]")).click();
	      //edit the course
	      WebElement objN1=driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/input[4]"));
	      objN1.clear();
	      String NN="course_name123";
	      objN1.sendKeys(NN);
	      //click on save button
	      driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[2]/form/div/input[1]")).click();
	      //check edited element in the list
	     int obj_list=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
	     int k;
	     for(k=1;k<=obj_list;k++)
	     {
	    	 String obj=driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+k+"]/td[3]/a")).getText();
	    	 if (obj.equals(NN)) 
	    	 {
				System.out.println("edited course verified in the list");
				//click on checkbox
				driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+k+"]/td[1]/input")).click();
				//click on delete button
				 driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/div[4]/div[1]/input[2]")).click();
			      
			      break;
			}
	     }
	     driver.switchTo().alert().accept();
	     driver.switchTo().defaultContent();
	     driver.switchTo().parentFrame();
	    
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	      
	    /*//check in the list
	      int table1=driver.findElements(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr")).size();
	      System.out.println(table1);
	      int j;
	      for(j=1;j<=table1;j++)
	      {
	    	 String s_table1= driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[3]/a")).getText();
	    	 if (s_table1.equals(objN))
	    	 {
				System.out.println("edited course is present in the list");
				
				
	    	 driver.findElement(By.xpath("//html/body/div[1]/div[2]/form/table/tbody/tr["+j+"]/td[1]/input")).click();
	    	 break;
	      }*/
	      }
	      
	}


