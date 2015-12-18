import java.util.Scanner;
public class prog19_strong {
	
	static int fact(int N)
	{
		if(N<=1)
			return 1;
		else
			return N*fact(N-1);
	}
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int n=s1.nextInt();
	int d=n,sum=0;
	while(d>0)
	{
		sum+=fact(d%10);
		d/=10;
	}
	String str=(sum==n)?n+" is a Strong number":n+" is not a Strong number";
	System.out.println(str);
}
}
