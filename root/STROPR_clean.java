import java.util.*;
import java.io.*;
class STROPR_clean
{

	/************************ SOLUTION STARTS HERE ************************/
	
	
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	static final long mod = ((long)1e9) + 7L;

	private static long mul(long a,long b)      /* Modular multiplication */
	{
		return ((a%mod)*(b%mod))%mod;
	}
	private static long add(long a,long b)		/* Modular addition */
	{
		return ((a%mod)+(b%mod))%mod;
	}	
	private static long modPow(long a,long b)   /* Modular exponentiation  */
	{
		if(b == 0L || a == 1L)
			return 1L;
		else if(b == 1L)
			return a;
		else
		{
			if((b & 1L) == 0L)  		//Checking whether b is even (fast)  
				return modPow((a * a) % mod,b / 2L);
			else
				return (a * modPow((a * a) % mod,((b - 1L) / 2L))) % mod ;
		}
	}
	private static long inverseMod(long n) /* Fermat's little theorem , used it to find the modular inverse of the denominator*/
	{
		return modPow(n,mod - 2L);
	}
	static void solve3(FastScanner s1, FastWriter out)/* This is the actual solution */{
		
		/*
		 * 
		 * Useful resources : https://nrich.maths.org/1437 
		 * 					  https://www.hackerearth.com/notes/abhinav92003/why-output-the-answer-modulo-109-7/#c46855
		 * 					  https://comeoncodeon.wordpress.com/tag/fermat/
		 * 
		 */
		
		
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
					coeff = mul(mul(coeff,nume),inverseMod(deno));
					ans = add(ans, mul(arr[x-2-(int)(k)], coeff));
				}
			}
			out.println(ans % mod);  //This costed me a WA
		}
	}
	/************************ SOLUTION ENDS HERE ************************/

	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);	
		solve3(in,out);		 //Atlast solve3 won the show
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