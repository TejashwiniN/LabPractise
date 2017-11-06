package webDriverEx;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex1 {

	public static void main(String[] args) 
	{
		ArrayList<String> AL=new ArrayList<String>();
		AL.add("qap1");
		AL.add("qap2");
		AL.add("qap3");
		
		Iterator<String> ITRT=AL.iterator();
		while(ITRT.hasNext())
		{
			String data=ITRT.next();
			System.out.println(data);
		}
		

	}

}
