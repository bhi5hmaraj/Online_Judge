import java.util.*;
public class PrimeUtils {
	static int eulerPhi[];
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
	
	static long gcd(long big,long small)
	{
		 long b = Math.max(big, small);
		 long s = Math.min(big, small);
		 if(s == 0)
			 return b;
		 else
			 return gcd(s,b%s);
	}
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
	
	public static boolean isPrime (int n) {
	    if (n < 2)
	        return false;
	    for (int i = 2; i * i <= n; i++)
	        if (n % i == 0)
	            return false;
	    return true;
	}

	

	public static void eulerSieve (int N) {
	     eulerPhi = new int[N + 1];

	    // set initial value of phi(i) = i
	    for (int i = 1; i <= N; i++)
	        eulerPhi[i] = i;


	    for (int i = 1; i <= N; i++) {
	        if (isPrime(i))
	            for (int j = i; j <= N; j += i)
	                eulerPhi[j] -= eulerPhi[j] / i;
	    }
	    
	}
	public static ArrayList<Integer> sieve(int N)     //Sieve of Erathanoses
	{
		ArrayList<Integer> primes = new ArrayList<>();
		boolean num[] = new boolean[N+1];
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}
		for(int i=2;i<num.length;i++)
			if(!num[i])
				primes.add(i);
		
		return primes;
	}
public static void main(String[] args) {
	Scanner s1 = new Scanner(System.in);
	int n = s1.nextInt();
	long start = System.nanoTime();
	eulerSieve(n);
	long elapsed = System.nanoTime() - start;
	System.out.println("time phi= "+elapsed/1e9+"s");
	System.out.println(Arrays.toString(eulerPhi));
	start = System.nanoTime();
	sieve(n);
	elapsed = System.nanoTime()-start;
	System.out.println("time for sieve="+elapsed/1e9+"s");
	long sum[] = SUM(20);
	for(int i=1;i<=20;i++)
	{
		System.out.println(i+"-->"+sum[i]);
	}
	/*long checkSum[] =new long[n+1];
	for(int i=1;i<=n;i++)
	{
		checkSum[i] = bruteSolver(i);
	}
	*/
	//System.out.println("sum="+Arrays.toString(sum));
	//System.out.println("Check sum="+Arrays.toString(checkSum));
	/*for(int i=1;i<=n;i++)
	{
		System.out.println(i+"-->"+arl_arr[i]);
	}*/
}
}
