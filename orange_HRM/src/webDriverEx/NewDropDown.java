package webDriverEx;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewDropDown {

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(); 
		
		//open application
		driver.get("http://classroom:90/webapp/SelectAWebSite.html");
		
		Thread.sleep(2000);
		
		//_ _ _ _ _ _ _ _ _

		//Create WebElement for DropDown
		WebElement E=driver.findElement(By.name("OptWeb"));
		
		//create select option
		Select sel=new Select(E);
		
		//_ _ _ _ _ _ _ _ _
		//Select item by using visible text
		sel.selectByVisibleText("QAPlanet");
		Thread.sleep(2000);
		
		//select item by index
		sel.selectByIndex(0);
		
		//select item by value property
		sel.selectByValue("Microsoft");
		Thread.sleep(2000);

		
		
		

	}

}
