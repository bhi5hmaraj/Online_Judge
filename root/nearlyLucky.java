import java.util.*;
import java.io.*;
public class nearlyLucky
{
    public static boolean isLucky(String str)
    {
        int len=str.length();
        for(int i=0;i<len;i++)
        {
            if(str.charAt(i) !='4' && str.charAt(i) !='7')
                return false;
        }
        return true;
    }
        
        
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int ct=0;
        String str=s1.next();
        int len=str.length();
        for(int i=0;i<len;i++)
        {
            if(str.charAt(i) =='4' || str.charAt(i) =='7')
                ct++;
        }
        if(isLucky(Integer.toString(ct)))
            out.print("YES");
        else
            out.print("NO");
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
        