import java.util.Scanner;
public class prog16_roman{
public static void main(String[] arg)
{
	Scanner in = new Scanner(System.in);
	String str="";
	String roarr[]={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};	
	System.out.print("Enter no.: ");
	int intarr[]={1,4,5,9,10,40,50,90,100,400,500,900,1000};
	int d=in.nextInt(),n=d;
	while(d!=0)
	{
		int i=intarr.length-1;
		while(n!=0)
		{
			int temp=n/intarr[i];
			if(temp>0)
			{
				n%=intarr[i];
				for(int j=1;j<=temp;j++)
				str+=roarr[i];
			}	
			i--;
		}
		System.out.println("Roman numeral of "+d+" = "+str);
		System.out.print("Enter no.: ");
		d=in.nextInt();
		n=d;
		str="";
	}
	

}
}
