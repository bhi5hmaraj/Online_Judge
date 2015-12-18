import java.util.*;
import java.io.*;
public class EvenOdds
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        long n=s1.nextLong();
        long k=s1.nextLong();
        if((n&1)==0)        //Check if n is even
        {
        if(k<= (n/2))
        {
        	out.println((2*k)-1);
        }
        else
        {
        	out.println((2*k)-n);
        }
        }
        else
        {
        	if(k <= (n/2)+1)
        	{
        		out.println((2*k)-1);
        	}
        	else
        	{
        		out.println((2*k)-n-1);
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
        