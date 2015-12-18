import java.util.*;
import java.io.*;
public class Counterexample
{
	static long gcd(long big,long small)
	{
		 long b = Math.max(big, small);
		 long s = Math.min(big, small);
		 if(s == 0)
			 return b;
		 else
			 return gcd(s,b%s);
	}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        long l = s1.nextLong();
        long r = s1.nextLong();
        if(r-l < 2)
        {
        	out.println("-1");
        	out.close();
        	return;
        }
        else
        {
        	for(long a = l;a<=r-2;a++)
        	{
        		for(long b=a+1;b<=r-1;b++)
        		{
        			if(gcd(a,b) == 1)        //2 numbers are coprime if their gcd is 1
        			{
        				for(long c=b+1;c<=r;c++)
        				{
        					if(gcd(b,c) == 1 && gcd(a,c) !=1)
        					{
        						out.println(a+" "+b+" "+c);
        						return;
        					}
        				}
        			}
        		}
        	}
        }
        out.println("-1");
        out.close();
    }
    static class MyScanner2 {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner2() {
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
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
       
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

}
}

        