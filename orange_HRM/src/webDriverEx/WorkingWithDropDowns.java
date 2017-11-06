package webDriverEx;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WorkingWithDropDowns 
{

	public static void main(String[] args) throws Exception
	
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(); 
		
		//open application
		driver.get("http://classroom:90/qahrm/login.php");
		Thread.sleep(2000);
		driver.findElement(By.name("txtUserName")).sendKeys("qaplanet1");
		driver.findElement(By.name("txtPassword")).sendKeys("user1");
		driver.findElement(By.name("Submit")).click();
		
		driver.switchTo().frame("rightMenu");
		
		//_ _ _ _ _ _ _ _ _

		//Create WebElement for DropDown
		WebElement E=driver.findElement(By.name("loc_code"));
		//create select option
		Select sel=new Select(E);
		//_ _ _ _ _ _ _ _ _
		//Select item by using visible text
		sel.selectByVisibleText("Emp. First Name");
		Thread.sleep(2000);
		//select item by index
		sel.selectByIndex(0);
		
		
		
		
	}

}
