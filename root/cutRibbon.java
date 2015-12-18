import java.util.*;
import java.io.*;
public class cutRibbon
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int n=s1.nextInt();
        int a=s1.nextInt();
        int b=s1.nextInt();
        int c=s1.nextInt();
        int small=Math.min(Math.min(a,b), c);
        int big=Math.max(Math.max(a, b),c);
        int mid=(a+b+c)-(small+big);
        int max = 0;
        for(int i=n/small;i>=0;i--)
        {
            for(int j=n/mid;j>=0;j--)
            {
        	
        	if((n - (i*small)  - (j*mid) ) >=0)
        	{
        	int req_big = (n - (i*small)  - (j*mid))/big;   
        	//out.println("i"+i+"j"+j+"k"+req_big);
        	if(req_big >=0 && req_big<=(n/big) &&( i*small + j*mid + req_big*big == n))
        	{
        	    if(i+j+req_big > max)
        		max = i+j+req_big;
        	}
        	}
            }
        }
        out.println(max);
        out.close();
    }
    static class MyScanner {
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

}
        