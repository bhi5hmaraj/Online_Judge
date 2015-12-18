import java.util.*;
import java.io.*;
public class contest_316A
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int cand=s1.nextInt();
        int city=s1.nextInt();
        int big=0;
        int temp=0;      
        int pos=0;
        int arr[]=new int[cand];
        for(int i=1;i<=city;i++)
        {
        	pos=0;
        	big=0;
        	for(int j=0;j<cand;j++)
        	{
        		temp=s1.nextInt();
        		if(temp > big)
        		{
        			big=temp;
        			pos=j;
        		}
        	}
        	arr[pos]++;
        	       
        }
        big=0;
        for(int i=0;i<cand;i++)
        {
        	if(arr[i] > big)
        	{
        		big=arr[i];
        		pos=i+1;
        	}
        }
        out.println(pos);
        out.close();
        
        
        
        
        
        
        //out.close();     
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
        