package webDriverEx;

public class Dog 
{
	String name;
	void bark()
	{
		System.out.println(name+" "+ "says bow");
	}
	public static void main(String[] args)
	{
		Dog d1=new Dog();d1.name="snoopy";
		Dog d2=new Dog();d2.name="jimmy";
		Dog d3=new Dog();d3.name="brownzee";
		Dog[] D=new Dog[3];
		D[0]=d1;
		D[1]=d2;
		D[2]=d3;
		for(int i=0;i<=2;i++)
		{
			D[i].bark();
		}
		
	}
}
