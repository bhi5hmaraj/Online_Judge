import java.util.Scanner;
public class prog17_armstrong {
	static boolean isArmstrong(int N)
	{
		int sum=0;
		int d=N;
		while(d>0)
		{
			sum+=(int)Math.pow(d%10, 3);
			d/=10;
		}
		return sum==N;
	}
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int n=s1.nextInt();
	String str=(isArmstrong(n))?n+" is an Armstrong number":n+" is not an Armstrong number";
	System.out.println(str);
	
}
}
