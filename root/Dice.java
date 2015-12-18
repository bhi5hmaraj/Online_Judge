import java.util.*;
import java.io.*;
public class Dice
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int a= s1.nextInt();
        int b= s1.nextInt();
        int lo =Math.min(a, b);
        int hi =Math.max(a, b);
        if(lo == hi)
        	out.println("0 6 0");
        else
        {
        	if((hi-lo)%2==0)
        	{
        		int mid = (hi+lo)/2;
        		if(lo == a)
        		out.println((mid-1)+" 1 "+(6-mid));
        		else
        			out.println((6-mid)+" 1 "+(mid-1));
        	}
        	else
        	{
        		int mid = (hi+lo)/2;
        		if(lo == a)
        		out.println(mid+" 0 "+(6-mid));
        		else
        			out.println((6-mid)+" 0 "+(mid));
        	}
        }
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

        