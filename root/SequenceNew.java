import java.util.*;
import java.io.*;
public class SequenceNew
{
	static int f1,f2;
	static int mod =1000000007;
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        f1 = s1.nextInt();
        f2 = s1.nextInt();
        int n = s1.nextInt();
        int fn = 0;
        if(n==1)
        	fn = f1;
        else if(n==2)
        	fn = f2;
        else
        {        	
        	for(int i=3;i<=n;i++)
        	{
        		fn = ((f2%mod)-(f1%mod))%mod;
        		f1 = f2;
        		f2 = fn;
        	}
        }
    	if(fn < 0)
    		out.println((fn%mod)+mod);
    	else
    		out.println(fn%mod);
        out.close();
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
        