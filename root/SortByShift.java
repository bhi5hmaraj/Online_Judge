import java.util.*;
import java.io.*;
public class SortByShift
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int arr[] = s1.nextIntArray(len);
        int pos = -1;
        int numIncSeq = 0;
        for(int i=0;i<len-1;i++)
        {
        	if(arr[i] > arr[i+1])
        	{
        		numIncSeq++;
        		pos=i+1;
        	}
        }
        if(numIncSeq == 0)           //there should be only 2 increasing sequences and the max of 2nd should be less than the min of the first sequence
        	out.println("0");
        else
        {
        	if(numIncSeq>1)
        		out.println("-1");
        	else
        	{
        		if(arr[len-1]<=arr[0])
        			out.println(len-pos);
        		else
        			out.println("-1");
        	}
        }
        out.close();
    }
}
class MyScanner2 {
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
        