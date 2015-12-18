import java.util.*;
import java.io.*;
public class BankAccount
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        String str=s1.next();
        if(Character.isDigit(str.charAt(0)))
        {
        	out.println(str);
        	out.close();
        	return;
        }
        int n = Integer.parseInt(str);
        int len=str.length();
        	int a=(n/10);
        	int b=Integer.parseInt(str.substring(0, len-2)+str.charAt(len-1));
        	if(a > b)
        		out.println(a);
        	else
        		out.println(b);
        
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
        