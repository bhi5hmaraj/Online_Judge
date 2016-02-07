import java.util.*;
import java.io.*;
import java.math.BigInteger;
class STROPR
{

	/************************ SOLUTION STARTS HERE ************************/
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	static final long mod = ((long)1e9) + 7;
	static final BigInteger modBig = BigInteger.valueOf(mod);
	private static long mul(long a,long b)
	{
		return ((a%mod)*(b%mod))%mod;
	}
	private static long add(long a,long b)
	{
		return ((a%mod)+(b%mod))%mod;
	}	
	static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		while(t-->0)
		{
			int N = s1.nextInt();
			int x = s1.nextInt();
			long M = s1.nextLong();
			long arr[] = s1.nextLongArray(N);
			long coeff = 1L;
			long ans = 0L;		
			BigInteger c = BigInteger.valueOf(coeff);
			BigInteger a = BigInteger.valueOf(ans);
			double time = 0.0;
			boolean flag = true;
			for(long k=-1;k<=x-2;k++)
			{
				long start = System.nanoTime();
				if(k==-1)
				{
					ans = arr[x-2-(int)(k)];
					a = BigInteger.valueOf(ans);
				}
				else
				{
					long nume = M + k;
					long deno = k + 1L;
					BigInteger n = BigInteger.valueOf(nume);
					BigInteger d = BigInteger.valueOf(deno);					
					c = c.multiply(n);								
					c = c.divide(d);		
					a = a.add(c.multiply(BigInteger.valueOf(arr[x-2-(int)(k)])));
				}
				long stop = System.nanoTime();
				time += (stop - start)/1e9;
				if(time>=(0.3))
				{
					//throw new RuntimeException("TLE");
					solve4(N,x,M,arr,out);
					flag = false;
					break;
				}
			}
			if(flag)
				out.println(a.mod(modBig));
		}
	}
	static void solve2(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		while(t-->0)
		{

			int N = s1.nextInt();
			int x = s1.nextInt();
			int M = s1.nextInt();
			long arr[] = s1.nextLongArray(N);
			long matrix[][] = new long[M+1][x+1];
			for(int i=1;i<=x;i++)
			{
				matrix[0][i] = arr[i-1];
			}
			for(int i=1;i<=M;i++)
			{
				for(int j=1;j<=x;j++)
				{
					matrix[i][j] = add(matrix[i][j-1], matrix[i-1][j]);
				}
			}
			out.println(matrix[M][x]);
		}
	}

	private static long modPow(long a,long b)
	{
		if(b == 0L || a == 1L)
			return 1L;
		else if(b == 1L)
			return a;
		else
		{
			if((b&1L) == 0L)
				return modPow((a * a)%mod,b/2L);
			else
				return (a * modPow((a * a)%mod,((b-1L)/2L)))%mod ;
		}
	}
	private static long inverseMod(long n)
	{
		return modPow(n,mod - 2L);
	}
	static void solve3(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		while(t-->0)
		{

			int N = s1.nextInt();
			int x = s1.nextInt();
			long M = s1.nextLong();
			long arr[] = s1.nextLongArray(N);
			long coeff = 1L;
			long ans = 0L;		
			for(long k=-1;k<=x-2;k++)
			{
				if(k==-1)
				{
					ans = arr[x-2-(int)(k)];					
				}
				else
				{
					long nume = M + k;
					long deno = k + 1L;
					coeff = ((((coeff % mod) * (nume % mod))%mod) * (inverseMod(deno))) % mod;
					ans = add(ans, mul(arr[x-2-(int)(k)], coeff));
				}
			}
			out.println(ans%mod);
		}
	}
	static void solve4(int N,int x,long M,long arr[], FastWriter out)/* This is the actual solution */{

		long coeff = 1L;
		long ans = 0L;		
		for(long k=-1;k<=x-2;k++)
		{
			if(k==-1)
			{
				ans = arr[x-2-(int)(k)];					
			}
			else
			{
				long nume = M + k;
				long deno = k + 1L;
				coeff = ((((coeff % mod) * (nume % mod))%mod) * (inverseMod(deno))) % mod;
				ans = add(ans, mul(arr[x-2-(int)(k)], coeff));
			}
		}
		out.println(ans);		
	}
	/************************ SOLUTION ENDS HERE ************************/

	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		//String input  = "/home/bhishmaraj/Documents/OJ/Java/input.txt";		
		//FastScanner in  = new FastScanner(input);
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		//long start = System.nanoTime();
		solve(in,out);
		//long stop = System.nanoTime();
		//System.err.println((stop-start)/1e9 + " s");
		//solve2(in, out);		
		//solve3(in,out);		 //Atlast solve3 won the show
		in.close();
		out.close();
	}

	static class FastScanner{
		public BufferedReader reader;
		public StringTokenizer st;
		public FastScanner(InputStream stream){
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}
		public FastScanner(String file){
			try
			{
				reader = new BufferedReader(new FileReader(file));
				st = null;
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		public String next(){
			while(st == null || !st.hasMoreTokens()){
				try{
					String line = reader.readLine();
					if(line == null) return null;
					st = new StringTokenizer(line);
				}catch (Exception e){
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}
		public String nextLine(){
			String str = null;
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
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
		public void close(){	
			try{ reader.close(); } catch(IOException e){e.printStackTrace();}
		}
	}
	static class FastWriter{
		BufferedWriter writer;
		public FastWriter(OutputStream stream){
			writer = new BufferedWriter(new OutputStreamWriter(stream));
		}
		public void print(int i) {
			print(Integer.toString(i));
		}
		public void println(int i) {
			print(Integer.toString(i));
			print('\n');
		}
		public void print(long i) {
			print(Long.toString(i));
		}
		public void println(long i) {
			print(Long.toString(i));
			print('\n');
		}
		public void print(double i) {
			print(Double.toString(i));
		}
		public void print(boolean i) {
			print(Boolean.toString(i));
		}
		public void print(char i) {
			try{writer.write(i);} catch(IOException e){e.printStackTrace();}
		}
		public void print(Object o){
			print(o.toString());
		}
		public void println(Object o){
			print(o.toString());
			print('\n');
		}
		public void print(String s){
			try{writer.write(s);} catch(IOException e){e.printStackTrace();}
		}
		public void println(String s){
			try{writer.write(s);writer.write('\n');} catch(IOException e){e.printStackTrace();}
		}
		public void println(){
			try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
		}
		public void print(int arr[])
		{
			for (int i = 0; i < arr.length; i++) {
				print(arr[i]);
				print(' ');
			}
		}
		public void close(){
			try{writer.close();} catch(IOException e){e.printStackTrace();}
		}
	}

	/************************ TEMPLATE ENDS HERE ************************/
}