import java.util.Scanner;
class COINS
{
	static 	long arr[]=new long[1000001];
	static final int length=arr.length;
	public static long dp(long n)
	{
		if(n==0)
			return 0;		
		else
		{
			if(n<length)
			{
				if(arr[(int)n] != 0)
					return arr[(int)n];
			}
			long r=n;
			r=(long)Math.max(r, (dp(r/2)+dp(r/3)+dp(r/4)));
			if(n<length)
				arr[(int)n]=r;
			return r;
		}
	}
    public static void main(String args[])
    {
    	Scanner s1=new Scanner(System.in);
    	arr[0]=0;
    	arr[1]=1;
    	int z=1;
        while(z<=10)
        {        
        	int N=s1.nextInt();        	
        	System.out.println(dp(N));        	
        	z++;
        }
        s1.close();
    }
}