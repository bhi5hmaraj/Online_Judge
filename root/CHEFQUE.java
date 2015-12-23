import java.util.*;
import java.io.*;
class CHEFQUE       //Java Bitset runs in 0.92 s
{
    
    static class MyBitset
    {
	private long bits[];
	public MyBitset() {
	    bits = new long[1<<26];
	}
	public void set(int index,boolean b)
	{
	    int bucket = index / 64;
	    boolean alreadySet = get(index);
	    if(b && !alreadySet)
	    {
		long setter = 1 << ((64-(index%64))-1);
		bits[bucket] |= setter;
	    }
	    else
	    {
		if(alreadySet)
		{
		    long setter = 1 << ((64-(index%64))-1);
		    bits[bucket] ^= setter;
		}
	    }
	}
	public void set(int index)
	{
	    set(index,true);
	}
	public boolean get(int index)
	{
	    int bucket = index/64;
	    return (bits[bucket]&(1 << ((64-(index%64))-1))) != 0;
	}
    }
    private static void solve(MyScanner2 s1,PrintWriter out)
    {
	long q=s1.nextLong();
        long s_prev = s1.nextLong(),s_curr=s_prev;
        long A = s1.nextLong();
        long B= s1.nextLong();
        final long MOD = 4294967296L;
        //out.println(MOD);
        BitSet b = new BitSet();
        long sum = 0;
        long start  =System.nanoTime();
        while(q-->0)
        {
            //out.println(b);
            if((s_curr & 1)==1)
            {
        	if(!b.get((int)(s_curr/2)))
        	{
        	    b.set((int)(s_curr/2));
        	    sum += (s_curr/2);
        	}
            }
            else
            {	
        	if(b.get((int)(s_curr/2)))
        	{
        	    b.set((int)(s_curr/2), false);
        	    sum -= (s_curr/2);
        	}
            }
            s_curr = ((A*s_prev)%MOD + B%MOD) %MOD;
            s_prev = s_curr;
        }
        long end = System.nanoTime() - start;
        out.println("time "+end/1e9+" s");
        out.println(sum);
        out.close();
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        //StringBuilder sb=new StringBuilder();     
        solve(s1,out);
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
        