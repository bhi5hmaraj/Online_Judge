import java.util.Scanner;
public class prog15_rev {
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int N=s1.nextInt();
	int d=N,rev=0;
	while(d>0)
	{
		rev=(rev*10)+(d%10);
		d/=10;
	}
	System.out.print("Reverse of "+N+" = "+rev);
}
}
