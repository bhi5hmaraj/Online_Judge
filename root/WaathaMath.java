import java.util.*;
import java.io.*;
public class WaathaMath
{
    public static void main(String args[])//Edited in EmEditor
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int m = s1.nextInt();
        int sum = s1.nextInt();
        StringBuffer sb = new StringBuffer();
        if(sum > (9*m) || sum==0)
        {
        	if(sum ==0 && m==1)
        	{
        		out.println("0 0");
        	}
        	else
        	{
        	out.println("-1 -1");
        	}
        	out.close();
        	return;
        }
        else
        {
        	// Finding smallest number with sum
        	int num;
        	int s = sum;
        	for(int i=1;i<=m;i++)
        	{
        		num = s - (9*(m-i));
        		if(num <= 0)
        		{
        			if(i==1)
        			{
        			sb.append("1");
        			s -= 1;
        			}
        			else
        			{
            			sb.append("0");
        			}
        		}
        		else
        		{
        			sb.append(num);
        			s -= num;
        		}
        	}
        	sb.append(" ");
        	// Finding largest number
        	int limit = sum/9;
        	for(int i=1;i<=limit;i++)
        		sb.append("9");
        	if(limit < m)
        	{
        		sb.append(sum%9);
        		for(int i=1;i<=m-limit-1;i++)
        		{
        			sb.append("0");
        		}
        	}
        }
        out.println(sb);
        out.close();
    }
    static class MyScanner2 {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner2() {
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
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
       
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

}
}