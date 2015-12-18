import java.util.*;
import java.io.*;
public class MinimumDifficulty
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len =s1.nextInt();
        int arr[] =s1.nextIntArray(len);
        int init_diff= -1;
        for(int i=1;i<len;i++)
        {
        	if((arr[i]-arr[i-1]) > init_diff)
        		init_diff = (arr[i]-arr[i-1]);
        }
        int curr_diff=-1;
        int low_diff = Integer.MAX_VALUE;
        for(int i=1;i<len-1;i++)
        {
        	curr_diff = Math.max(arr[i+1]-arr[i-1], init_diff);
        	if(curr_diff < low_diff)
        		low_diff = curr_diff;
        }
        out.println(low_diff);
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

        