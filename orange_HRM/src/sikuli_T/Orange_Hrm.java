package sikuli_T;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Orange_Hrm
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
		//create web elements for un,pwd ,login,clear
				WebElement objUN=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
				WebElement objPW=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
				WebElement objLI=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
				WebElement objCL=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("clear")));
				//----------------------------------------------------
				
				
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
				//------------------------------------------------------------
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
				
				//enter first name 
				driver.findElement(By.name("txtEmpFirstName")).sendKeys(sFN);
				//click on browse button
				driver.findElement(By.id("photofile")).click();
				Thread.sleep(5000);

        
			   Screen screen = new Screen();
				Pattern fileNameInput = new Pattern("D:\\abc.sikuli\\filename.png");
				Pattern openButton = new Pattern("D:\\abc.sikuli\\open.png");
 
        
        screen.type(fileNameInput, "D:\\New folder\\Tulips.jpg");
        screen.click(openButton);
        objSave.click();
        
		
		
			
		}

	}


