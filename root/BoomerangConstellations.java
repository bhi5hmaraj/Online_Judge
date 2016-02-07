import java.util.*;
import java.io.*;
class BoomerangConstellations
{
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB

	static class Point
	{
		long x,y;
		Point(long x , long y)
		{
			this.x = x;
			this.y = y;
		}
		Point()
		{
			this.x = 0;
			this.y = 0;
		}
		@Override
		public String toString() {
			return "("+this.x+" , "+this.y+")";
		}

		long squareOfdist(Point that)
		{
			return square(this.x - that.x) + square(this.y - that.y);
		}
	}

	private static long square(long n)
	{
		return n*n;
	}
	private static <Key> void frequency(Map<Key , java.lang.Long> mp , Key k)
	{
		//Finds frequency of of each element of generic type Key
		Long query = mp.get(k);
		if(query == null)
			mp.put(k, new Long(1));
		else
		{
			mp.put(k, query + 1);
		}
	}
	private static boolean check(long x)
	{
		return x>=(long)-1e4 && x<=(long)1e4;
	}
	private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		for(int z = 1; z <= t; z++)
		{
			int N = s1.nextInt();
			if(!(N>=1 && N<=(int)2e3))
				throw new UnsupportedOperationException("value of N is invalid "+ N);
			Point arr[] = new Point[N];
			for (int i = 0; i < N; i++) {
				long x = s1.nextLong();
				long y = s1.nextLong();
				if(!(check(x) && check(y)))
					throw new UnsupportedOperationException("x or y has invalid value");
				arr[i] = new Point(x, y);
			}
			HashMap<Long, Long> distFreq = null;
			long total = 0;
			for(int i=0;i<N;i++)
			{
				distFreq = new HashMap<>();
				for(int j=0;j<N;j++)
				{
					if(i != j)
					{
						frequency(distFreq, arr[i].squareOfdist(arr[j]));
					}
				}
				long numOfLines = 0;
				for(Map.Entry<Long, Long> e: distFreq.entrySet())
				{
					long freq = e.getValue();
					if(freq >= 2)
					{			
						numOfLines = (freq * (freq-1) ) / 2L ;
						total += numOfLines;
					}
				}
			}
			out.print("Case #"); out.print(z);out.print(": ");
			out.println(total);
		}
	}

	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		//String input  = "C:\\Users\\bhisR\\Documents\\test_files_dump\\facebook1_in.txt";
		//String output = "facebook1_out(checked).txt";
		FastScanner in  = new FastScanner(System.in);  /* These are for debugging */ 
		FastWriter  out = new FastWriter(System.out);
		//FastScanner in  = new  FastScanner(input);
		//FastWriter  out = new  FastWriter(output);
		long start = System.nanoTime();
		solve(in, out);
		long end   = System.nanoTime();
		double timeElapsed = (end - start) / 1e9;
		System.err.printf("Total time elapsed : %.4f s \n",timeElapsed);
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
		public FastWriter(String file){
			try
			{
				writer = new BufferedWriter(new PrintWriter(file));
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
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
