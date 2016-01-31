import java.util.*;
import java.io.*;
class AlphaPrimes
{
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	static int MAX = (int)1e6 + 10;
	static boolean isComposite[]  = isCompositeArray(MAX);
	static int numOfAlphaPrimes[] = new int[MAX];
	private static void preCalculate()
	{
		for(int i=1;i<=MAX-1;i++)
		{
			if(isAlphaPrime(i))
				numOfAlphaPrimes[i] = numOfAlphaPrimes[i-1] + 1;
			else
				numOfAlphaPrimes[i] = numOfAlphaPrimes[i-1];
		}
	}
	public static boolean[] isCompositeArray(int N)     //Sieve of Erathanoses
	{
		boolean num[] = new boolean[N+1];
		num[1]=true;
		num[0]=true;
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*i;j<num.length;j+=i)
					num[j] = true;			
		}

		return num;
	}
	private static boolean isAlphaPrime(int n)
	{		

		if(!isComposite[n])
			return true;
		else
		{
			while(true)
			{
				if(n < 10)
				{
					return !isComposite[n];
				}
				else
				{
					n = Integer.parseInt(Integer.toString(n).substring(1));
					if(!isComposite[n])
						return true;
				}
			}			
		}

	}
	private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		preCalculate();
		//out.println(Arrays.toString(numOfAlphaPrimes));
		while(t-->0)
		{
			int l =s1.nextInt();
			int r = s1.nextInt();	
			out.println(numOfAlphaPrimes[r]-numOfAlphaPrimes[l-1]);
		}
	}

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
