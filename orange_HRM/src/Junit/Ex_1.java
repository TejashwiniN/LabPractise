package Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




public class Ex_1
{
	@Before
	public  void Method1()
	{
		System.out.println("Method1");
	}
	@After
	public  void method2()
	{
		System.out.println("Method2");
	}
	@Test
	public void method3()
	{
		System.out.println("m3");
	}
	@Test
	public void method4()
	{
		System.out.println("m4");
	}
}
