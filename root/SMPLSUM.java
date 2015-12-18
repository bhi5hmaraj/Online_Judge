import java.util.*;
import java.io.*;
class SMPLSUM
{
	static long phi[];
	static long fi[];
	static boolean marked[];
	static int lp[];
	static long bruteSolver(long n)
	{
		long sum =0;
		int end = (int)Math.sqrt(n);
		for(int i=1;i<=end;i++)
		{
			if(n%i == 0)
			{
				long f1 = i;
				long f2 = n/i;
				if(f1 != f2)
				{
					sum += (f1)*fi[(int)f1];
					sum += (f2)*fi[(int)f2];
				}
				else
				{
					sum += (f1)*fi[(int)f1];
				}
			}
		}
		return sum;
	}
	static long bruteSolverFinal(long n)
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
	static LinkedList<Long> divisorsOf(long N)
	{
		int end = (int)Math.sqrt(N);
		LinkedList<Long> ll = new LinkedList<>();
		for(int i=1;i<=end;i++)
		{
			if(N%i == 0)
			{
				long f1 = i;
				long f2 = N/i;
				if(f1 != f2)
				{
					ll.add(f1);
					ll.add(f2);
				}
				else
				{
					ll.add(f1);
				}
			}
		}
		return ll;
	}
	static long[] newSum(int N)
	{
		long sum[] = new long[N+1];
		for(int i=1;i<=N;i++)
		{
			long temp =i*fi[i];
			for(int j=i;j<=N;j+=i)
			{
				sum[j] += temp;
			}
		}
		return sum;
	}
	
	static void test(int N)
	{
		for(int i=1;i<=N;i++)
			divisorsOf(i);
	}
	
	static void calc_sieve(int N)
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
	

	
	public static long eulerPhi (long n) {
		
		if(n<=MAX)
			return phi[(int)n];
		else
		{
		long result = n;
		//System.out.println("pinged"+n);
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				result -= result / i;

				while (n % i == 0) {
					n /= i;
				}
			}
		}

		if (n > 1) {
			result -= result / n;
		}

		return (long)result;
		}
	}
	
	static long gcd(long big,long small)
	{
		 long b = Math.max(big, small);
		 long s = Math.min(big, small);
		 if(s == 0)
			 return b;
		 else
			 return gcd(s,b%s);
	}
	public static boolean[] isCompositeArray(int N)     //Sieve of Erathanoses
	{
		boolean num[] = new boolean[N+1];
		num[1]=true;
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}
		
		return num;
	}
	
	static ArrayList<Integer>[] divisors(int N)
	{
		ArrayList<Integer>[] arrayLists = (ArrayList<Integer>[])new ArrayList[N+1];
		ArrayList<Integer> arl_arr[] = arrayLists;		
		for(int i=1;i<=N;i++)
		{
			for(int j=i;j<=N;j+=i)
			{
				if(i==1)
				{
					arl_arr[j] = new ArrayList<>();
				}
				arl_arr[j].add(i);
			}
		}
		return arl_arr;
	}
	
	public static boolean isPrime (int n) {
	    if (n < 2)
	        return false;
	    else if(n <=MAX)
	    {
	    	return !marked[n];
	    }
	    else
	    {
	    for (int i = 2; i * i <= n; i++)
	        if (n % i == 0)
	            return false;
	    return true;
	    }
	}

	

	public static int[] eulerSieve (int N) {
	    int [] eulerPhi = new int[N + 1];
	    boolean mark[] = new boolean[N+1];
	    // set initial value of phi(i) = i
	    for (int i = 1; i <= N; i++)
	        eulerPhi[i] = i;


	    for (int i = 1; i <= N; i++) {
	        if (isPrime(i))
	            for (int j = i; j <= N; j += i)
	                eulerPhi[j] -= eulerPhi[j] / i;
	    }
	    return eulerPhi;
	}
	static long[] SUM(int N)   //Works fine till n = 3e6
	{
		long sum[] = new long[N+1];
		marked =new boolean[N+1];
		phi = new long[N+1];
		for(long i=1;i<=N;i++)
		{
			phi[(int)i] = i;
			sum[(int)i] = 1;
		}
		for(long i=2;i<=N;i++)
		{
			if(!marked[(int)i])  //i is prime
			{
				phi[(int)i] = i-1;
				for(long j=i;j<=N;j+=i)
				{
					if(i != j)
					{
						marked[(int)j]=true;
					}
					phi[(int)j] -= phi[(int)j]/i;
					sum[(int)j] += ((long)i*(long)phi[(int)i]);
				}
			}
			else
			{
				for(long j=i;j<=N;j+=i)
				{
					sum[(int)j] +=(long)(i*phi[(int)i]);
				}
			}
		}
		return sum;
	}
	
	static final int MAX = (int)1e7;
	static final int MAX_SUM = (int)1e4;
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();        
        //double total =0;
         //start = System.nanoTime();
        calc_sieve(MAX);
        //end =System.nanoTime() - start;
         //total+=end/1e9;
        //out.println("time for fi = "+end/1e9+"s");
        
         //start = System.nanoTime();
        long sum [] = newSum(MAX_SUM);
        
         //nd =System.nanoTime() - start;
         //total+=end/1e9;
        //out.println("time for sum = "+end/1e9+"s");
        
        for(int z=1;z<=t;z++)
        {	
        	int input = s1.nextInt();
        	
            if(input <= MAX_SUM)
            {
            	sb.append(sum[input]+"\n");
            }
            else
            {
            	sb.append(bruteSolverFinal(input)+"\n");
            }       
            //end =System.nanoTime() - start;
            //total += (end/1e9);
            //out.println("brute final"+bruteSolverFinal(input));
        }        
        out.println(sb);
        //out.println("total="+total+"s");
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
        