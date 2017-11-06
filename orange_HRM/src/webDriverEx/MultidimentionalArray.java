package webDriverEx;

public class MultidimentionalArray
{

	public static void main(String[] args)
	{
		String[] a={"Mr.","mrs."};
		String[] b={"venu","gopal"};
		String[] c={"vijaya","lakshmi"};
		String[][] x={a,b,c};
		System.out.println(x[0][0]+x[1][0]+x[1][1]);
		System.out.println(x[0][1]+x[2][1]);

	}

}
