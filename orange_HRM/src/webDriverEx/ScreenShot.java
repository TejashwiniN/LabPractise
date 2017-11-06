
package webDriverEx;

	import java.io.File;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	import org.apache.commons.io.FileUtils;
	
	public class ScreenShot 
	{
		public static void main(String[] args)throws Exception
		{
			System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("http://classroom:90/qahrm");

			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now copy somewhere
			File abc=new File("C:\\Users\\Lab\\Desktop\\New folder\\New1.jpg");
			FileUtils.copyFile(scrFile, abc);
	
			driver.close();
			driver.quit();
		}
	}


     