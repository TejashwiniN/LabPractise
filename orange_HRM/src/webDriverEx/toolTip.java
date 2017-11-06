package webDriverEx;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class toolTip 
{
		public static void main(String[] args) 
		{
			System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe" );
		    WebDriver Brow = new ChromeDriver();
		    
			Brow.manage().window().maximize();
			Brow.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			//------------------------------------------------------------------
			Brow.get("http://www.google.co.in/");
			//Get Title attribute of Edit box
			String ToolTip=Brow.findElement(By.id("lst-ib")).getAttribute("title");
			System.out.println(ToolTip);
			//close browser
			Brow.close();
			//quit object
			Brow.quit();
		}
		
}


