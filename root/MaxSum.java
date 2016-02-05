import java.util.*;
import java.io.*;
public class MaxSum
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static long maxSubArraySum(int arr[],int start,int end)
	{
		int len = end - start +1 ;
		//System.out.println("start"+start+"end"+end);
		long sum = 0;
		long MAX =Long.MIN_VALUE;
		for(int i=1;i<=len;i++)
		{
			sum = 0;
			for(int j=start;j<start+i;j++)
			{
				sum += arr[j];
			}
			MAX = Math.max(MAX, sum);
			for(int j=start+i;j<=end;j++)
			{
				//System.out.println("i"+i+"j"+j);
				sum += arr[j];
				sum -= arr[ (j-i)];
				MAX = Math.max(MAX, sum);
			}
		}
		return MAX;
	}
	private static void solve1(FastScanner s1, FastWriter out){

		int len = s1.nextInt();
		int arr[] = new int [len+1];
		for(int i=0;i<len;i++)
			arr[i] = s1.nextInt();
		long MAX = 0;
		int start = 0;
		boolean f = true;	
		for(int i=0;i<=len;i++)
		{
			if(arr[i]!=0)
			{
				if(f)
				{
					start = i;
					f = false;
				}
			}
			else if(!f)
			{
				MAX = Math.max(MAX, maxSubArraySum(arr, start, i-1));
				f = true;
			}
		}

		out.print(MAX);
	}
	
	private static void solve2(FastScanner s1, FastWriter out){
		
		int len = s1.nextInt();
		long arr[] = s1.nextLongArray(len);
		int ct = 0;
		for(int i=0;i<len;i++)
		{
			if(arr[i] == 0)
				arr[i] = Long.MIN_VALUE;
			if(arr[i] < 0)ct++;
		}
		if(ct == len)
		{
			out.print(0);
			return;
		}
		long sumSoFar =0, sumEndingHere = 0;		
		for(long a:arr)
		{
			sumEndingHere = Math.max(0, (sumEndingHere + a));
			sumSoFar = Math.max(sumSoFar, sumEndingHere);
		}
		out.print(sumSoFar);
	}
	
	/************************ SOLUTION ENDS HERE ************************/



	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		//solve1(in, out) // Brute force algorithm O(N^2) 
		solve2(in, out); //Kadane's algorithm O(N)
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
