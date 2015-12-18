import java.util.*;
import java.io.*;
public class DZYString
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        String str = s1.next();
        int len = str.length();
        int k = s1.nextInt();
        int val[] = new int [26];
        for(int i=0;i<26;i++)
        	val[i] = s1.nextInt();
        int max = Arrays.stream(val).max().getAsInt();
        long sum = 0;
        for(int i=0;i<len+k;i++)
        {
        	if(i<len)
        		sum+=(i+1)*val[str.charAt(i)-'a'];
        	else
        		sum+=(i+1)*max;
        }
        out.println(sum);
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
        