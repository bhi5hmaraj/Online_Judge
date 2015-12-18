import java.util.*;
import java.io.*;
public class contest_316B
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int m=s1.nextInt();
        boolean isRight=false;
        if((len-m) > (m-1))
        	isRight=true;
        if(len == 1 && (m==1))
        {
        	out.println("1");
        	out.close();
        	return;
        }
        
        if(isRight)
        	out.println(m+1);
        else
        	out.println(m-1);
        
        out.close();
        
        		
        
        
        
        
        
        //out.close();     
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
        