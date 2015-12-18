import java.util.Scanner;
public class dorm
{
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int n=s1.nextInt();
		int ocup=0,max=0,ct=0;
		for(int i=1;i<=n;i++)
		{
			ocup=s1.nextInt();
			max=s1.nextInt();
			if(max-ocup >= 2)
				ct++;
		}
		System.out.println(ct);
	}
}