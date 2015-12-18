/*
public class excep {

}

*/
import java.util.*;
import java.io.*;
public class excep
{
    public static void main(String args[])
    {
	try
	{                   
	    System.out.println("hey");            
	    try
	    {
		int k = 8/0;
		return;
	    }
	    catch(ArithmeticException e)
	    {
		int i = 5/0; 
		System.out.println("div by 0");
		throw new RuntimeException("fuck");
	    }
        }
        catch(Exception e)
        {            
            e.printStackTrace();
           
        }        
        finally
        {
            System.out.println("finally");
        }
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
        