import java.util.*;
import java.io.*;
class COOKMACH
{
    public static boolean isPower(int N)
{
            int lg=(int)((Math.log(N))/Math.log(2));
        if(Math.pow(2,lg) == N)
            return true;
        else
            return false;
}
    
    public static int log2(int N)
    {
        int temp=(int)((Math.log(N))/Math.log(2));
        return temp;
    }
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int t=s1.nextInt();
        int start,end;
        for(int i=1;i<=t;i++)
        {
            start=s1.nextInt();
            end=s1.nextInt();
            if(isPower(start))
            {
                out.println(Math.abs(log2(end) - log2(start)));
            }
            else
            {
                out.println(log2(start) + log2(end));
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
        