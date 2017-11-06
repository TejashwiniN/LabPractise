package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openWebPage {

	public static void main(String[] args)
	{

		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//to open webpage
		driver.navigate().to("http://classroom:90/qahrm");
		//to get current driver handle
		String id=driver.getWindowHandle();
		
		
		driver.close();
	}

}
