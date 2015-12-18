import java.util.Scanner;
public class prog9_large {
	public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	System.out.print("Enter numbers (Terminate the stream with a zero)");
	int ct=0;int big=0,temp=0;
	while((temp=s1.nextInt()) != 0)
	{
		if(temp>big)
		{
			big=temp;
			ct=1;
			continue;
		}
		if(temp == big)
			ct++;
	}
	System.out.print("Big = "+big+" Frequency = "+ct);
	}

}
