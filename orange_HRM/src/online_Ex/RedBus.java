package online_Ex;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBus
{

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);

		
		//create object for actions class
		Actions Act=new Actions(driver);
		//create wait object
		WebDriverWait wait= new WebDriverWait(driver, 60);
		//----------------------------------------------
		//open application
		driver.get("https://www.redbus.in/");
		//enter from
		WebElement obj_From=driver.findElement(By.xpath("//html/body/section/div[2]/main/section/div/div[2]/section/div/div[1]/div/input"));
		obj_From.clear();
		obj_From.sendKeys("Banglore");
		Thread.sleep(2000);
		//enter to address
		WebElement obj_To=driver.findElement(By.xpath("//html/body/section/div[2]/main/section/div/div[2]/section/div/div[2]/div/input"));
		obj_To.clear();
		obj_To.sendKeys("Hyderabad");
		Thread.sleep(2000);
		//enter onward date
		driver.findElement(By.xpath("//html/body/section/div[2]/main/section/div/div[2]/section/div/div[3]/div/label")).click();
		//Thread.sleep(12000);
		//driver.findElement(By.xpath("html/body/div[5]/table/tbody/tr[5]/td[4]")).click();
		//sThread.sleep(2000);
		//enter return date
		//driver.findElement(By.xpath("html/body/section/div[2]/main/section/div/div[2]/section/div/div[4]/div/label")).click();
		//driver.findElement(By.xpath("html/body/div[6]/table/tbody/tr[6]/td[5]")).click();
		

	}

}
