import java.util.Scanner;
public class prog1_triangle {
	private static Scanner s1;

	public static void main(String[] args) {
		s1 = new Scanner(System.in);
		System.out.println("Enter the three sides");
		int a=s1.nextInt();
		int b=s1.nextInt();
		int c=s1.nextInt();
		int sum=a+b+c;
		if(a==0 || b==0 || c==0)
		{
			System.out.println("One of the sides is 0");
			return;
		}
		if((sum-a)>=a && (sum-b)>=b && (sum-c)>=c)
			System.out.println("Triangle can be formed");
		else
			System.out.println("Triangle cannot be formed");
	}

}
