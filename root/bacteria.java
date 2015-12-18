import java.util.Scanner;
public class bacteria
{
	static int num(long x)
	{
	    while(x%2==0)        //Divide all powers of 2 as they won't be accounted
	    	x/=2;
	    
		if((x & (x-1)) == 0)
			return 1;
		else if(((x-1) & (x-2)) == 0)
			return 2;
		else
		{
			return 1+num(x/2);
		}		
	}
	public static void main(String args[])
	{
    	Scanner s1 =new Scanner(System.in);
    	long lng=s1.nextLong();
    	System.out.println(num(lng));
	}
}