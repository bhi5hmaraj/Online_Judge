import java.util.*;
import java.io.*;
public class FactorialLengthSum
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static final int MAX = (int)1e6 + 10;
	private static int bigPrime[] = new int[MAX];
	private static int cache[] = new int[MAX];
	
	private static void bigPrimeSieve()
	{
		bigPrime[1] = 1;
		for(int i=2;i<MAX;i++)
		{
			if(bigPrime[i] == 0)
			{
				for(int j=i;j<MAX;j+=i)
					bigPrime[j] = i;
			}
		}
	}
	private static int factorialLength(int N)
	{
		if(N==1)
			return 0;
		else
		{
			int ct = 0;
			while(N != 1)
			{
				int prime = bigPrime[N];
				while(N % prime == 0)
				{
					N /= prime;
					ct++;
				}
			}
			return ct;
		}	
	}
	private static void preCompute()
	{
		cache[1] = 0;
		for(int i=2;i<MAX;i++)
		{
			int fLen = factorialLength(i);
			cache[i] = fLen + cache[i-1];
		}
	}
	private static long pleasingValue(int arr[],int curr)
	{
		int len = arr.length;
		long sum = 0;
		for(int i=0;i<len;i++)
		{
			if(((curr>>i)&1)==1)
				sum += (long)cache[arr[i]];
		}
		return sum;
	}
	/*****All necessary pre calculations are done in the static block******/
	static {
		bigPrimeSieve();
		preCompute();
	}
	private static void solve(FastScanner s1, FastWriter out){
		int len = s1.nextInt();
		int arr[] = s1.nextIntArray(len);
		int end = 1<<len;
		long sum = 0;
		for(int i=1;i<end;i++)
		{
			long please = pleasingValue(arr, i);
			if(please % 2 == 0)
				sum += please;
		}
		out.print(sum);
	}

	/************************ SOLUTION ENDS HERE ************************/



	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		solve(in, out);
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
