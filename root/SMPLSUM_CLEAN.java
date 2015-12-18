import java.util.*;
import java.io.*;
class SMPLSUM_CLEAN
{
	
	static long fi[];	//euler totient
	static int lp[];	//lowest prime factor of a number
	static final int MAX = (int)1e7;
	
	static long Solver(long n)
	{
		long sum = 1;
		while(n != 1)
		{
			long prime = lp[(int)n];
			long p = prime;
			long temp_sum = 1;
			while(n % prime == 0)
			{
				n /= prime;
				temp_sum += (p*fi[(int)p]);
				p *=prime;
			}
			sum *=temp_sum;
		}
		return sum;
	}
	
	
	static void fastFiSieve(int N)    //complexity O(N) passed but O(nlog(n)) TLEd
	{
		lp= new int[N + 1];		
		fi = new long[N+1];
		int pr[] = new int[N];
		int sz=0;
	    fi[1] = 1;
	    for (int i = 2; i <= N; ++i)
	    {
	        if (lp[i] == 0)
	        {
	            lp[i] = i;
	            fi[i] = i - 1;
	            pr[sz]=i;
	            sz++;
	        }
	        else
	        {
	            //Calculating phi
	            if (lp[i] == lp[i / lp[i]])
	                fi[i] = fi[i / lp[i]] * lp[i];
	            else
	                fi[i] = fi[i / lp[i]] * (lp[i] - 1);
	        }
	        for (int j = 0; j < sz && pr[j] <= lp[i] && i * pr[j] <= N; ++j)
	            lp[i * pr[j]] = pr[j];
	    }
	}
	
	
	
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        fastFiSieve(MAX);  
        int t=s1.nextInt();                         
        for(int z=1;z<=t;z++)
        {	
        	int input = s1.nextInt();
        	sb.append(Solver(input)+"\n");
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
        