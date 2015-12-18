
import java.util.*;
import java.io.*;
public class QueriesonaString
{
	
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        String str = s1.next();
        StringBuffer curr = new StringBuffer(str);
        StringBuffer temp = new StringBuffer(str);
        int q = s1.nextInt();
        for(int t=1;t<=q;t++)
        {
        	int l = s1.nextInt();
        	int r = s1.nextInt();
        	int k = s1.nextInt();
        	int len = r-l+1;
        	k %= len;
        	if(k != 0)
        	{        		
        		for(int i=0;i<k;i++)
        		{
        			curr.setCharAt(l+i-1, temp.charAt(r-k+i));
        		}
        		for(int i=0;i<(len-k);i++)
        		{
        			curr.setCharAt(l+k+i-1, temp.charAt(l+i-1));
        		}
        		//out.println(curr);
        		temp = new StringBuffer(curr);
        	}
        }
        out.println(curr);
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

        