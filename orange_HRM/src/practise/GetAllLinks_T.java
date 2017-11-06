package practise;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinks_T 
{

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.calculator.net/");
		driver.manage().window().maximize();
	    List<WebElement>list= driver.findElements(By.tagName("a"));
	    System.out.println(list.size());
	    for(int i=0;i<list.size();i++)
	    {
	    	String s_list=list.get(i).getText();
	    	System.out.println(s_list);
	    	
	    }
		

	}

}
