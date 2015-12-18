import java.util.*;
import java.io.*;
public class Sequences
{
	//1000000
	static int memo []= new int[(int)1e6];
	static final int MAX = memo.length;
	static final int mod = 1000000007 ;
	static int f(int n)
	{
		System.out.println("n="+n);
		if(n < MAX)
			return memo[n];
		else
			return ((f(n-1)%mod)-(f(n-2)%mod))%mod;
	}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        memo[1] = s1.nextInt();
        memo[2] = s1.nextInt();
        for(int i=3;i<MAX;i++)
        {
        	memo[i] = ((memo[i-1]%mod)+(memo[i-2]%mod))%mod;
        }
        int n =s1.nextInt();
        if(n < MAX)
        {
        	if(memo[n] >=0)
        		out.println(memo[n]%mod);
        	else
        		out.println((memo[n]%mod)+mod);
        }        	
        else                              //If n is greater than my length of memo i use a recursive function to compute it
        {
        	int fn = f(n);
        	if(fn < 0)
        		out.println((fn%mod)+mod);
        	else
        		out.println(fn%mod);
       	}
    }
}
class MyScanner2 {
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
        