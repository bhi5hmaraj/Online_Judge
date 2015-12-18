import java.util.*;
import java.io.*;
public class flowers
{
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
		long len=s1.nextLong();
		long arr[]=new long[(int)len];
		long small=0,big=0;
		for(int i=0;i<len;i++)
		{
			arr[i]=s1.nextInt();
			if(i==0)
				small=arr[i];
			else
			{
				if(arr[i]<small)
					small=arr[i];
			}
			if(arr[i]>big)
				big=arr[i];
		}
		if(big == small)
		{
			long shit=((len)*(len-1))/2;
			out.println("0 "+shit);
			return;
		}
		long T_big=0,T_small=0;
		for(long temp:arr)
		{
			if(temp == small)
				T_small++;
			if(temp == big)
				T_big++;
		}
		out.println((big-small)+" "+(T_small*T_big));
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
        