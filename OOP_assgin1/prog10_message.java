import java.util.Scanner;
public class prog10_message
{
	public static void main(String ar[]) throws InterruptedException
	{
		int n;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of seconds:");
		n=s.nextInt();
		s.close();
		while(n>=0)
		{
			System.out.println(n);
			Thread.sleep(1000);
			n--;
		}
	}

}
