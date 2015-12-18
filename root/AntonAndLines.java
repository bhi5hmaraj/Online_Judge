import java.util.*;
import java.io.*;
public class AntonAndLines
{
	static class Pair implements Comparable<Pair>
	{
		int id;long intercept;
		Pair(int a,long b)
		{
			id =a;
			intercept =b;
		}
		public int compareTo(Pair that)
		{
			if(this.intercept > that.intercept)
				return 1;
			else if(this.intercept < that.intercept)
				return -1;
			else
				return 0;
		}
		
	}
    public static void main(String args[])    //http://codeforces.com/predownloaded/e1/a4/e1a45d3c8bd81cfb659ac42a55a5cad5488cd9d9.png  use this as reference
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len =s1.nextInt();
        long x1 = s1.nextLong();
        long x2 = s1.nextLong();
        long m[] = new long[len];
        long c[] = new long[len];
        Pair arr1[] =new Pair[len];
        Pair arr2[] =new Pair[len];
        for(int i=0;i<len;i++)
        {
        	m[i] =s1.nextLong();
        	c[i] =s1.nextLong();
        	arr1[i] = new Pair(i, (m[i]*x1)+c[i]);
        	arr2[i] = new Pair(i, (m[i]*x2)+c[i]);
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<len;i++)
        {
        	double x = (double)(c[arr1[i].id]-c[arr2[i].id]) / (double)(m[arr2[i].id]-m[arr1[i].id]);
        	if(arr1[i].id != arr2[i].id && ((x>x1 && x<x2)))
        	{
        		out.println("YES");
        		out.close();
        		return;
        	}
        }
        out.println("NO");
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
