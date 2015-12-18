/*
public class IgorGenerator {

}

*/
import java.util.*;
import java.io.*;
public class IgorGenerator
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();
	PrintWriter out = null;
	try
	{
	    out=new PrintWriter(new File("IgorTest.txt"));  //Close the output stream after use
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
        int n = s1.nextInt();
        Random rand = new Random();
	out.println(n+" "+n);
	for(int i=1;i<=n;i++)
	    out.print("*");
	out.println();
	for(int i=1;i<=n-2;i++)
	{
	    out.print("*");
	    for(int j=1;j<=n-2;j++)
		{
			if(rand.nextBoolean())
			    out.print(".");
			else
			    out.print("*");
		}
	    out.println("*");
	}
	for(int i=1;i<=n;i++)
	    out.print("*");
	out.println();
	System.out.println("Sucessfully written "+n);
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
        