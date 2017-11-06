package vtiger_CRM;

import org.testng.annotations.Test;

import practise.TestNg_practise;

public class TC_2
{
	@Test
	public void m()
	{
		TestNg_practise y=new TestNg_practise();
		y.setup();
		y.HomePage();
		y.Verify_Elements();
		y.Lead();
		
	}
	
}
