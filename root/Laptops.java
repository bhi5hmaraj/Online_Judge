import java.util.*;
import java.io.*;
public class Laptops
{
	static class Pair implements Comparable<Pair> {
		  public  int first;
		  public  int second;

		  public Pair( int first,  int second) {
		    this.first = first;
		    this.second = second;
		  }

		   public boolean equals(Pair that)
		   {
		        return this.first==that.first && this.second==that.second;
		   }
		   public int compareTo(Pair that)
		   {
			   return this.first - that.first;
		   }
		}  
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        Pair arr[] = new Pair[len];
        for(int i=0;i<len;i++)
        {
        	arr[i] = new Pair(s1.nextInt(),s1.nextInt());
        }
        Arrays.sort(arr);
        for(int i=0;i<len-1;i++)
        {
        	if(arr[i].second > arr[i+1].second)
        	{
        		out.println("Happy Alex");
        		out.close();
        		return;
        	}
        }
        out.println( "Poor Alex");
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

   