import java.util.*;
import java.io.*;
public class DreamoonAndStairs 
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int n =s1.nextInt();
        int m =s1.nextInt();
        if(m>n)
        {
        	out.println("-1");
        	out.close();
        	return;
        }
        for(int i=n/2;i>=0;i--)
        {
        	if((n-i) % m == 0)
        	{
        		out.println((n-i));
        		out.close();
        		return;
        	}
        }
    	out.println("-1");
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
        
