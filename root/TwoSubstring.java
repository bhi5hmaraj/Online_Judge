import java.util.*;
import java.io.*;
public class TwoSubstring
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        String str=s1.next();
        int fuck1=str.indexOf("AB");
        int fuck2=str.indexOf("BA");
        if(fuck1>=0 && fuck2>=0)
        {
        	if(((str.substring(fuck1+2).indexOf("BA")) >= 0) ||((str.substring(fuck2+2).indexOf("AB")) >= 0))
        		System.out.print("YES");
        	else
        		System.out.print("NO");
        }
        else
        	System.out.print("NO");

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