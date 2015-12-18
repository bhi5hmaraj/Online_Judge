import java.util.*;
import java.io.*;
public class divisibility
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int n=s1.nextInt();
        int t=s1.nextInt();
        if(t==10)
        	{
        	if(n==1)
        	{
        		out.println("-1");
        		out.close();
        		return;
        	}
        	out.print("1");
        	for(int i=1;i<=n-1;i++)
        		out.print("0");
        	}
        else
        {
        for(int i=1;i<=n;i++)
        	out.print(t);
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
        