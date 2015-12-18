/*
public class uva11942 {

}

*/
import java.util.*;
import java.io.*;
public class uva11942
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	StringBuffer sb = new StringBuffer();
        int t =s1.nextInt();
        int arr[];
        boolean asc,dsc;
        sb.append("Lumberjacks:\n");
	while(t-->0)
	{
	    asc = true;
	    dsc = true;
	    arr =s1.nextIntArray(10);
	    for(int i=1;i<10;i++)
	    {
		if(arr[i] < arr[i-1])
		{		    	
		    asc = false;
		    break;
		}
	    }
	    for(int i=1;i<10;i++)
	    {
		if(arr[i] > arr[i-1])
		{
		    dsc =false;
		    break;
		}
	    }
	    if(asc|dsc)
		sb.append("Ordered\n");
	    else
		sb.append("Unordered\n");
	}
	out.print(sb);
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
        