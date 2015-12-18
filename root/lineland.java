import java.util.*;
import java.io.*;
public class lineland
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int len=s1.nextInt();
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt();
        }
        int adj_l,adj_r,end_l=arr[0],end_r=arr[len-1];
        for(int i=0;i<len;i++)
        {
            if(i==0)
            {
                adj_r=arr[1];
                sb.append((adj_r-arr[i])+" "+(end_r-arr[i])+"\n");
            }
            else if(i==len-1)
            {
                adj_l=arr[len-2];
                sb.append((arr[i]-adj_l)+" "+(arr[i]-end_l)+"\n");
            }
            else
            {
                adj_l=arr[i-1];
                adj_r=arr[i+1];
                sb.append(Math.min((arr[i]-adj_l),(adj_r-arr[i]))+" "+Math.max((arr[i]-end_l),end_r-arr[i])+"\n");
            }
        }
        out.println(sb);
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