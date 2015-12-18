import java.util.*;
import java.io.*;
class NUMFACT
{
    static int loPrime[];
    static void loPrimeSieve(int N)
    {
	loPrime= new int[N + 1];		
	int pr[] = new int[N];
	int sz=0;
	for (int i = 2; i <= N; ++i)
	{
	    if (loPrime[i] == 0)
	    {
		loPrime[i] = i;	            
		pr[sz]=i;
		sz++;
	    }
	    for (int j = 0; j < sz && pr[j] <= loPrime[i] && i * pr[j] <= N; ++j)
		loPrime[i * pr[j]] = pr[j];
	}
    }

    static HashMap<Integer,Integer> primeFactorize(int N)   //Dependency : A sieve (loPrime[]) which contains the lowest prime divisor for each number
    {
	HashMap<Integer,Integer> mp = new HashMap<>();
	int ct,prime;
	while(N!=1)
	{
	    prime = loPrime[N];
	    ct = 0;
	    while(N % prime == 0)
	    {
		N /= prime;	
		ct++;
	    }
	    mp.put(prime, ct);
	}
	return mp;
    }
    
    
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuilder sb=new StringBuilder();
        int t=s1.nextInt();
        loPrimeSieve((int)1e6);
        HashMap<Integer,Integer> collect = null;
        while(t-->0)
        {
            int len = s1.nextInt();
            collect = new HashMap<>();
            int input[] = s1.nextIntArray(len);
            for(int N:input)
            {
        	for(Map.Entry<Integer,Integer> e : primeFactorize(N).entrySet())
        	{
        	    Integer query = collect.get(e.getKey());
        	    if(query == null)
        		collect.put(e.getKey(), e.getValue());
        	    else
        		collect.put(e.getKey(), e.getValue()+query);
        	}
            }
            long total = 1;
            for(Map.Entry<Integer, Integer> e:collect.entrySet())
            {
        	total *= (e.getValue()+1);
            }
            sb.append(total+"\n");
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
        