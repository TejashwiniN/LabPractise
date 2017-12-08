package practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingWithMultipleBrowser
{


	public static void main(String[] args)throws Exception
	{/*
		System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaplanet.in/");
		Thread.sleep(2000);
		//String ID_1=driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[4]/a/img")).click();
		Thread.sleep(2000);*/
		//String ID_2=driver.getWindowHandle();
		//System.out.println(ID_1);
		//System.out.println(ID_2);
		//driver.switchTo().window(ID_1);
		//driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[5]/a/img")).click();
		//Thread.sleep(2000);
	//	String ID_3=driver.getWindowHandle();
	//	System.out.println(ID_3);
		/*Set<String> IDS=driver.getWindowHandles();
		for(String ID:IDS)
		{
			System.out.println(ID);
		}
		System.out.println(IDS);
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://qaplanet.in/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[4]/a/img")).click();
		Thread.sleep(2000);		
		Set<String> IDS=driver.getWindowHandles();
		Iterator<String> ITR=IDS.iterator();
		String First_ID=ITR.next();
		String Second_ID=ITR.next();
		Thread.sleep(4000);
		driver.switchTo().window(First_ID);
		driver.findElement(By.xpath("//*[@id='section-tophat']/div[1]/div/div[2]/ul/li[5]/a/img")).click();
		String id_3=driver.getWindowHandle();
		System.out.println(id_3+"++++++++++++++");
		/*for(String ID:IDS)
		{
			System.out.println(ID);
		}*/
		System.out.println(IDS+"*********");
		//driver.switchTo().window(First_ID);
		

		

	}

}
