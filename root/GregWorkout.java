import java.util.*;
import java.io.*;
public class GregWorkout
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len =s1.nextInt();
        //int arr[] =s1.nextIntArray(len);
        int arr[] = new int[len];
        for(int i=0;i<len;i++)
        	arr[i] = s1.nextInt();
        int exer[] = new int [3];
        for(int i=0;i<len;i++)
        {
        	exer[i%3]+=arr[i];
        }
        if(exer[0] > exer[1] && exer[0] > exer[2])
        	out.println("chest");
        else if(exer[1] > exer[0] && exer[1] > exer[2])
        	out.println("biceps");
        else
        	out.println("back");
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

        