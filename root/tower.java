import java.io.*;
import java.util.*;
 
 
 
public class tower{
     
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        //out = new PrintWriter(new BufferedOutputStream(System.out), true);
        // Start writing your solution here. -------------------------------------
         int N=sc.nextInt();
         int length;
         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
         Integer query;
         int big=0;
         for(int i=1;i<=N;i++)
         {
             length=sc.nextInt();
             query=map.get(length);
             if(query == null)
             {
                 map.put(length,1);
             }
             else
             {
                 map.put(length,query+1);
             }
             query=map.get(length);
             if(query > big)
                 big=(int)query;
              
         }
         
         System.out.println(big+" "+map.size());
    }
        
 
 
     
 
 
 
 
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
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
    //--------------------------------------------------------
}