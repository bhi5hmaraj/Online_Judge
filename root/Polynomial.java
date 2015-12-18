import java.util.*;
import java.io.*;
import java.math.BigInteger;
import static java.math.BigInteger.*;
class Polynomial
{
    static BigInteger A,B,C;
    static BigInteger K;
    static BigInteger f(BigInteger x)
    {	
	BigInteger t1 = A.multiply(x.pow(2));
	BigInteger t2 = B.multiply(x);
	return t1.add(t2).add(C);
    }
    static long lowerBound()
    {
	long low = 0;
	long high = Integer.MAX_VALUE;
	long mid;
	long n=-1;
	while(low <= high)
	{
	    mid = (low+high)/2;
	    BigInteger fm = f(valueOf(mid));
	    //System.out.println("fm "+fm);
	    if(K.compareTo(fm) > 0)
	    {
		low = mid+1;		
	    }
	    else
	    {
		high = mid-1;
		n = mid;
	    }
	}
	return n;
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
            A = valueOf(s1.nextLong());
            B = valueOf(s1.nextLong());
            C = valueOf(s1.nextLong());
            K = valueOf(s1.nextLong());
            long ans = lowerBound();
            if(ans < 0)
        	out.println("/********************************/");
            sb.append(ans+"\n");         
        }
        out.println(sb);
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
        