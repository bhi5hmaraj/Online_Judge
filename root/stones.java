import java.util.*;
import java.io.*;
public class stones
{
    public static int numRemove(String str)
    {
        if(str.length() > 1)
        {
            char ch_i=str.charAt(0);
            char ch_j=str.charAt(1);
            if(ch_i == ch_j)
                return 1+numRemove(ch_i+str.substring(2));
            else
                return numRemove(str.substring(1));
        }
        else
            return 0;
    }
        
        
        
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        String str=s1.next();
        out.print(numRemove(str));
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
        