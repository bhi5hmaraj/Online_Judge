/*
public class Supercentral {

}

*/
import java.util.*;
import java.io.*;
public class Supercentral
{
    static int x[],y[];
    static boolean isSuper(int p)
    {
	int len = x.length;
	int l=0,r=0,u=0,d=0;
	for(int i=0;i<len;i++)
	{
	    if(i != p)
	    {
		if(y[i] == y[p])
		{
		    if(x[i] > x[p])
			r++;
		    else
			l++;
		}
		else if ( x[i] == x[p])
		{
		    if(y[i] > y[p])
			u++;
		    else
			d++;
		}
	    }
	}
	if(l*r*u*d > 0)
	    return true;
	else 
	    return false;
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	int n = s1.nextInt();
	x = new int[n];
	y = new int[n];
	for(int i =0;i<n;i++)
	{
	    x[i] = s1.nextInt();
	    y[i] = s1.nextInt();
	}
	int ct =0;
	for(int i=0;i<n;i++)
	    if(isSuper(i))
		ct++;
	out.println(ct);
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
        