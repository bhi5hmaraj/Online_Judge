import java.util.Scanner;
public class prog5_binary {
private static Scanner s1;

public static String decToBin(int N)
{
	if(N!=0)
	{
		return decToBin(N/2)+(N%2);
	}
	else
	{
		return "";
	}
}

public static void main(String[] args) {
	s1=new Scanner(System.in);
	System.out.print("Enter a positive decimal number :");
	int N=s1.nextInt();
	if(N<0)
	{
		System.out.println("You've entered a negative number");
		return;
	}
	else if(N == 0)
	{
		System.out.println("Binary equivalent = 0");
	}
	else
	{		
		System.out.println("Binary equivalent = "+decToBin(N));
	}
}
}


