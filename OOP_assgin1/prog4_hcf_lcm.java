import java.util.Scanner;
public class prog4_hcf_lcm {
	private static Scanner s1;
	
	public static int hcf(int small,int big)
	{
		if(small == 0)
			return big;
		else
			return hcf(big%small,small);
		
	}
	public static void main(String[] args) {
		s1=new Scanner(System.in);
		System.out.println("Enter two numbers");
		int a=s1.nextInt();
		int b=s1.nextInt();
		if(a==0 || b==0)
		{
			System.out.println("One of the inputs is 0");
			return;
		}
		else
		{
			int small=Math.min(a, b);
			int big  =Math.max(a, b);
			int hcf=hcf(small,big);
			int lcm=(a*b)/hcf;
			System.out.println("HCF = "+hcf+" LCM = "+lcm);
		}
	}
}
