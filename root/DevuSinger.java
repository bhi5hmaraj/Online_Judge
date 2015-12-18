import java.util.*;
import java.io.*;
public class DevuSinger
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int limit = s1.nextInt();
        int total=0;
        int arr[] = new int[len];
        int ct=0;
        for(int i=0;i<len;i++)
        {
        	arr[i] = s1.nextInt();
        	total+=arr[i];
        }
        if(total > limit)
        {
        	out.println("-1");
        	out.close();
        	return;
        }
        else
        {
        	total=0;
        	for(int i=0;i<len-1;i++)
        	{
        		total+=arr[i];
        		total+=10;
        		ct+=2;
        	}
        	total+=arr[len-1];
        	if(total > limit)
        	{
            	out.println("-1");
            	out.close();
            	return;
        	}
        	else
        	{
        		//out.println("ct="+ct+"total="+total+"fuck="+limit);
        		ct+=((int)(limit-total)/5);
        		out.println(ct);
        		out.close();
        	}
        }
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
        