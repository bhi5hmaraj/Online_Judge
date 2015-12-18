import java.util.*;
import java.io.*;
public class Multiplication
{
	static boolean isPrime(long N)
	{
		long end=(long)Math.sqrt(N);
		if(N==1)
			return false;
		for(long i=2;i<=end;i++)
			if(N%i==0)
				return false;
		
		return true;
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        long n=s1.nextLong();
        long x=s1.nextLong();
        if(isPrime(x))
        {
        	if(n>=x)
        		out.println("2");
        	else
        		out.println("0");
        }
        else
        {
        	int ct=0;
        	if(n<x)
        	{
        	for(int i=2;i<=n;i++)
        		if((x%i==0)&&(x/i)<=n)
        			ct++;
        	out.println(ct);
        	}
        	else
        	{
        		for(long i=1;i<=x;i++)
        			if((x/i)<=n && (x%i==0))
        				ct++;
        		out.println(ct);    //The number is also a divisor
        	}
        }        
        out.close();
        

    }
}
class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
}
        