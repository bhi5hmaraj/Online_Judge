/*
public class uva11340 {

}

*/
import java.util.*;
import java.io.*;
public class uva11340
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	//StringBuffer sb = new StringBuffer();
        int t = s1.nextInt();
	while(t-->0)
	{
	    int num = s1.nextInt();
	    int total =0;
	    HashMap<Character,Integer> cost = new HashMap<>();
	    for(int i=1;i<=num;i++)
		cost.put((s1.next().charAt(0)), s1.nextInt());
	    int nLines = s1.nextInt();
	    for(int i=1;i<=nLines;i++)
	    {
		String line = s1.nextLine();
		for(int j=0,len=line.length();j<len;j++)
		{
		    Integer c = cost.get(line.charAt(j));
		    if(c != null)
			total += c;
		}
	    }
	    double costD = total/(double)100;
	    System.out.printf("%.2f$\n", costD);
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
        