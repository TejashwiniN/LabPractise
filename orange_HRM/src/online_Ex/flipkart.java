package online_Ex;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipkart
{

	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//create object for actions class 
		Actions Act=new Actions(driver);
		
		//---------------------------------------------------------
		//open application
		driver.get("https://www.flipkart.com/");
		Thread.sleep(7000);
		//driver.findElement(By.xpath("//div[@class='_3Njdz7']/button")).click();
		//driver.switchTo().alert().dismiss();
		//mouse over on electronics
		WebElement Obj_Elects=driver.findElement(By.xpath("//html/body/div/div/header/div[2]/div/ul/li[1]/a/span"));
        Act.moveToElement(Obj_Elects).perform();
        Thread.sleep(6000);
       driver.findElement(By.xpath("//html/body/div/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a/span")).click();
       Thread.sleep(7000);
       //click on view all
        driver.findElement(By.xpath("//html/body/div/div/div[1]/div/div/div[3]/div/div/div[1]/div[1]/div/div/a/span")).click();
        Thread.sleep(4000);
       //click on price high to low
        driver.findElement(By.xpath("//html/body/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/section/ul/li[3]")).click();
        //driver.findElements(By.className("3wU53n"));
        
        int rc=driver.findElements(By.xpath("//html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[1]/div[1]")).size();
        System.out.println(rc);
        for (int i = 1; i <=rc; i++) {
        	 String str=driver.findElement(By.xpath("//html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div["+i+"]/div/a/div[2]/div[1]/div[1]")).getText();
             System.out.println(str);
		}
        
       
       // driver.close();
	}

}
