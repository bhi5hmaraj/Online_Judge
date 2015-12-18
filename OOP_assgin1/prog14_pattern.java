
public class prog14_pattern {
	static void a()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	static void b()
	{
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.print("* ");
			
			System.out.println();
		}
	}
	
	
	static void c()
	{
		int space=1;
		int temp=5;
		for(int i=1;i<=5;i++)
		{
			for(int k=1;k<space;k++)
				System.out.print(" ");
			for(int j=1;j<=temp;j++)
				System.out.print("* ");
			
			temp--;
			space++;
			System.out.println();
		}
	}
public static void main(String[] args) {
	System.out.println("a).");
	a();
	System.out.println("b).");
	b();
	System.out.println("c).");
	c();
}
}
