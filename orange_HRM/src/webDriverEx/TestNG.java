package webDriverEx;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG 
{

	@BeforeClass
	public void method1()
	{
		System.out.println("Method1");
	}
	@AfterClass
	public void method2()
	{
		System.out.println("Method2");
	}
	@Test(priority=2)
	public void method3()
	{
		System.out.println("Method3");
		Reporter.log("TestNg Report2");
	}
	@Test(priority=1)
	public void Method4()
	{
		System.out.println("Method4");
		Reporter.log("TestNg Report1");
	}
}
