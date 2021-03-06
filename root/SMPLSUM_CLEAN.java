import java.util.*;
import java.io.*;
class SMPLSUM_CLEAN
{

	static long fi[];	//euler totient
	static int lp[];	//lowest prime factor of a number
	static final int MAX = (int)1e7;
	static long bp[];   //largest prime factor of a number

	static void bigPrimeFactorSieve(int size)
	{
		bp = new long[size+1];
		bp[1] = 1;
		for(int i=2;i<=size;i++)
		{
			if(bp[i] == 0)
			{
				bp[i] = i;
				for(int j=2*i;j<=size;j+=i)
					bp[j] = i;
			}
		}
	}

	static long Solver1(long n)
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
	static long Solver2(long n) //Solves by factorizing using biggest prime factor and finding totient using fi(x) = x-(x/prime_factor)
	{
		long sum = 1;
		while(n != 1)
		{
			long prime = bp[(int)n];
			long p = prime;
			long temp_sum = 1;
			long fi_new = 0;
			while(n % prime == 0)
			{
				fi_new = p - (p/prime);
				n /= prime;
				temp_sum += (p*fi_new);
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
		MyScanner2   s1=new MyScanner2();  
		OutputWriter out = new OutputWriter(System.out);
		//bigPrimeFactorSieve(MAX);  //use this for solver 2
		fastFiSieve(MAX);
		int t=s1.nextInt();                         
		for(int z=1;z<=t;z++)
		{	
			int input = s1.nextInt();
			out.print(Solver1(input));
			out.println();
		}        
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
		static class OutputWriter{
			BufferedWriter writer;
			public OutputWriter(OutputStream stream){
				writer = new BufferedWriter(new OutputStreamWriter(stream));
			}        	
			public void print(long i) {
				try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
			}        	
			public void println(){
				try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
			}        	
			public void close(){
				try{writer.close();} catch(IOException e){e.printStackTrace();}
			}
		}

	

}
