import java.util.*;
import java.io.*;
public class ValeraandX
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int n = s1.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++)
        {
        	String line = s1.next();
        	for(int j=0;j<n;j++)
        		arr[i][j] = line.charAt(j);
        }
        char ch = arr[0][0];
        char diff = arr[0][1];
        if(ch == diff)
        {
    		out.println("NO");
    		out.close();
    		return;
        }
        int d1=-1;
        int d2=n;
        for(int i=0;i<n;i++)
        {
        	d1++;
        	d2--;
        	if(arr[i][d1] != ch || arr[i][d2]!=ch)
        	{
        		out.println("NO");
        		out.close();
        		return;
        	}
        	for(int j=0;j<n;j++)
        	{
        		if(j!=d1 && j!= d2)
        		{
        			if(arr[i][j] != diff)
        			{
                		out.println("NO");
                		out.close();
                		return;
        			}
        		}
        	}
        }
        out.println("YES");
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

        