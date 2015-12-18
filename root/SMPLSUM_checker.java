import java.util.*;
import java.io.*;
class SMPLSUM_checker
{
	static long bruteSolver(long n)
	{
		long sum =0;
		//System.out.println("\nBrute solver");
		for(long i=1;i<=n;i++)
		{
			sum += (n/gcd(i,n));
			//System.out.print((n/gcd(i,n))+" ");
		}
		return sum;
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
	    for (int i = 2; i * i <= n; i++)
	        if (n % i == 0)
	            return false;
	    return true;
	}

	

	public static int[] eulerSieve (int N) {
	    int [] eulerPhi = new int[N + 1];

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
	static long[] SUM(int N)
	{
		long sum[] = new long[N+1];
		boolean marked[] =new boolean[N+1];
		int phi[] = new int[N+1];
		for(int i=1;i<=N;i++)
		{
			phi[i] = i;
			sum[i] = 1;
		}
		for(int i=2;i<=N;i++)
		{
			if(!marked[i])  //i is prime
			{
				phi[i] = i-1;
				for(int j=i;j<=N;j+=i)
				{
					marked[j]=true;
					phi[j] -= phi[j]/i;
					sum[j] += (i*phi[i]);
				}
			}
			else
			{
				for(int j=i;j<=N;j+=i)
				{
					sum[j] +=(i*phi[i]);
				}
			}
			//System.out.println("phi="+Arrays.toString(phi));
			//System.out.println("sum="+Arrays.toString(sum));
			//System.out.println("marked="+Arrays.toString(marked));
		}
		return sum;
	}
    public static void main(String args[])
    {
    	try
    	{
    		PrintWriter write = new PrintWriter(new File("SPLSUM.txt"));
    		Random rnd = new Random();
    		int t = (int)1e4;
    		write.println(t);
    		for(int i=1;i<=t;i++)
    		{
    			write.println((1+rnd.nextInt((int)1e7)));
    		}
    	write.close();
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	
    	
    	
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        /*  First ACed soln */
        int MAX = (int)1e4;
        ArrayList<Integer> divs[] = divisors(t);
        int phi[] = eulerSieve(t);
        long sum1[] = new long[t+1];
        
        for(int z=1;z<=t;z++)
        {
        	int n =z;
        	if(n<=MAX)
        	{
        	for(Integer d : divs[n])
        	{
        		sum1[n] += (n/d)*phi[n/d];
        		//bruteSolver((long)n);
        	}
        	}
        	else
        	{
        		sum1[n] = bruteSolver((long)n);
        	}
        	//sb.append("brute sum="+bruteSolver(n)+"sum="+sum+"\n");
        	//sb.append(sum+"\n");
        }
        
    
        //long start = System.nanoTime();
        long sum2[] = SUM(t);
        //long end =System.nanoTime() - start;
        ///out.println("time"+end/1e9+"s");
        
        out.println("phi="+Arrays.toString(phi));
        out.println("first="+Arrays.toString(sum1));
        out.println("second="+Arrays.toString(sum2));
        for(int i=1;i<=t;i++)
        {
        	if(sum1[i] != sum2[i])
        		out.println(i+"sum1="+sum1[i]+"sum2="+sum2[i]);
        }
        //out.println(sb);
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
        