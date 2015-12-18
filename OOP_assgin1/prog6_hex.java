import java.util.Scanner;
public class prog6_hex {

	private static Scanner s1;
	private static char arr[];
	public static String decToHex(int N)
	{
		if(N!=0)
		{
			return decToHex(N/16)+arr[N%16];
		}
		else
			return "";
	}
	public static void main(String[] args) {
		s1=new Scanner(System.in);
		System.out.print("Enter a positive decimal number :");
		int N=s1.nextInt();
		arr=new char[16];
		char temp_digit='0';
		char temp_alpha='A';
		for(int i=0;i<16;i++)
		{
			if(i<10)
				arr[i]=temp_digit++;
			else
				arr[i]=temp_alpha++;
		}
		if(N<0)
		{
			System.out.println("You've entered a negative number");
			return;
		}
		else if(N == 0)
		{
			System.out.println("Hexadecimal equivalent = 0");
		}
		else
		{		
			System.out.println("Hexadecimal equivalent = "+decToHex(N));
		}
	}
}
