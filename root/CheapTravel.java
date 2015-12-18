import java.util.*;
import java.io.*;
public class CheapTravel
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        int n=s1.nextInt();
        int m=s1.nextInt();
        int a=s1.nextInt();
        int b=s1.nextInt();
        int cost = Integer.MAX_VALUE;
        int temp_cost;
        for(int i =0;i<=(n/m);i++)
        {
        	int j = n-(i*m);
        	temp_cost=(j*a)+(i*b);
        	if(temp_cost < cost)
        		cost=temp_cost;
        }
        if(n%m !=0)
        {
        	if(((n/m)+1)*b < cost)
        		cost=((n/m)+1)*b;
        }
        out.println(cost);
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
        