import java.util.Scanner;
public class prog3_SumDigit {
	private static Scanner s1;
	public static void main(String[] args) {
		s1=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int N=s1.nextInt();
		int sum=0;
		while(N>0)
		{
			sum+=(N%10);
			N/=10;
		}
		System.out.println("Sum of digits = "+sum);
	}
}
