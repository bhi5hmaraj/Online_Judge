import java.util.*;
import java.io.*;
public class puzzle
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int n=s1.nextInt();
        int m=s1.nextInt();
        int arr[]=new int[m];
        for(int i=0;i<m;i++)
            arr[i]=s1.nextInt();
        
        Arrays.sort(arr);
        int small=Integer.MAX_VALUE;
        for(int i=0;i<=(m-n);i++)
        {
        	/*if(small==-1)
        		small=arr[i+n-1]-arr[i];
        	else */       		
        		small=(int)Math.min(small, arr[i+n-1]-arr[i]);
        }
        out.println(small);
        //out.print(Math.min((arr[n-1]-arr[0]),(arr[m-1]-arr[m-n])));
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
        