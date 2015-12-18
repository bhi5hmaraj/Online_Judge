import java.util.*;
import java.io.*;
public class LunchRush
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        int k = s1.nextInt();
        int arr1[] = new int[n];
        int arr2[] = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
        	arr1[i] = s1.nextInt();
        	arr2[i] = s1.nextInt();
        }
        for(int i=0;i<n;i++)
        {
        	int fi = arr1[i];
        	int ti = arr2[i];
        	int joy = 0;
        	if(ti > k)
        		joy = fi-(ti-k);
        	else
        		joy = fi;
        	if(joy > max)
        		max = joy;
        }
        out.println(max);
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
        