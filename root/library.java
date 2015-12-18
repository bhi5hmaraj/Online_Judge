import java.util.*;
import java.io.*;
public class library 
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int roll_n;
        String sign="";
        int capacity=0;
        int buffer=0;
        Integer result;
        HashMap<Integer,Integer> mp=new HashMap<Integer,Integer>();
        for(int i=1;i<=len;i++)
        {
            sign=s1.next();
            roll_n=s1.nextInt();
            if(sign.equals("+"))
            {
                mp.put(roll_n,1);
                buffer++;
                capacity=Math.max(capacity,buffer);
            }
            else
            {
                result=mp.get(roll_n);
                if(result != null)
                {
                    if(result == 1)
                    {
                        mp.put(roll_n,0);
                        buffer--;
                    }
                }
                else
                {
                    capacity++;
                }
            }
        }
        out.print(capacity);
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
        