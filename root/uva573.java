/*
public class uva573 {

}

*/
import java.util.*;
import java.io.*;
public class uva573
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	int H,U,D,F;
	StringBuffer sb = new StringBuffer();
	while((H=s1.nextInt()) != 0)
	{
	    U = s1.nextInt();
	    D = s1.nextInt();
	    F = s1.nextInt();
	    double percent = (100-F)/(double)100;
	    int ct = 0;
	    double curr = U-D;
	    double prev = U;
	    boolean flag = true;
	    while(curr < H && curr>0)
	    {
		System.out.println("curr"+curr+"prev="+prev+"percent"+percent);
		if(((prev*percent)) < 0)
		{
		    flag = false;
		    sb.append("failure on day "+ct+"\n");
		    break;
		}
		curr += ((prev*percent)-D);
		prev *= percent; 
		ct++;
	    }
	    if(flag)
	    {
	    if(curr <= 0)
		sb.append("failure on day "+ct+"\n");
	    else
		sb.append("success on day "+(ct)+"\n");
	    }
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
        