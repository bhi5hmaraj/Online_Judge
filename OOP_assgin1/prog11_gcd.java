import java.util.Scanner;
public class prog11_gcd {
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int n1=s1.nextInt();
	int n2=s1.nextInt();
	int d=(int)Math.min(n1, n2);
	while(n1%d!=0 || n2%d!=0)
		d--;
	System.out.println("GCD of "+n1+", "+n2+" = "+d);
}
}
