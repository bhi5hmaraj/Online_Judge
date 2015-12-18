import java.util.*;
import java.io.*;
public class taxi
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int arr[]=new int[5];
        int taxi=0;
        for(int i=0;i<len;i++)
        	arr[s1.nextInt()]++;
        taxi+=arr[4];
        taxi+=arr[2]/2;
        arr[2]%=2;
        if(arr[1]<=arr[3])
        {
        	taxi+=arr[1];
        	arr[3]-=arr[1];
        	taxi+=arr[3];
        }
        else
        {
        	taxi+=arr[3];
        	arr[1]-=arr[3];
        	if(arr[2] == 1)
        	{
        		taxi+=1;
        		arr[2]--;
        		arr[1]-=2;
        	}
        	if(arr[1]>0)        		
        		taxi+=(arr[1]%4==0)?(arr[1]/4):(arr[1]/4)+1;
        }
        taxi+=arr[2];
        	
        out.println(taxi);
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
        