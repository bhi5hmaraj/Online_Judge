import java.util.*;
import java.io.*;
public class BeforeanExam
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static int interval[][];
	private static int ans[];
	private static int calls = 0;
	private static boolean recurse(int day , int sum)
	{
		calls++;
		if(day<0)
		{
			if(sum == 0)
				return true;
			else
				return false;
		}
		else
		{
			boolean result = false;
			if(sum < interval[day][0])
				return false;
			for(int i=interval[day][0] ; i<=interval[day][1];i++)
			{				
				 result = recurse(day-1, sum-i);				 
				 if(result)
				 {
					 ans[day] = i;
					 return true;					
				 }
			}
			return result;
		}
	}
	
	
	private static void solve(FastScanner s1, FastWriter out){

		int days = s1.nextInt();
		int sum = s1.nextInt();
		interval = new int[days][2];
		ans = new int[days];
		int maxSum = 0;
		for(int i=0;i<days;i++)
		{
			interval[i][0] = s1.nextInt();
			interval[i][1] = s1.nextInt();
			maxSum += interval[i][1];
		}
		if(sum > maxSum)
		{
			out.print("NO");
		}
		else
		{
			
			if(recurse(days-1,sum))
			{	
				out.println("YES");
				for(int a:ans)
					out.print(a+" ");
			}
			else
			{
				out.print("NO");
			}
			out.println("calls " + calls);
		}

	}
	
	private static void solve2(FastScanner s1 , FastWriter out)
	{
		int days = s1.nextInt();
		int sum = s1.nextInt();
		interval = new int[days][2];
		ans = new int[days];
		int maxSum = 0;
		int minSum = 0;
		for(int i=0;i<days;i++)
		{
			interval[i][0] = s1.nextInt();
			interval[i][1] = s1.nextInt();
			maxSum += interval[i][1];
			minSum += interval[i][0];
		}
		if(sum > maxSum || sum < minSum)
		{
			out.print("NO");
		}
		else
		{
			int need = sum - minSum;
			int ans[] = new int[days];
			for(int i=0;i<days;i++)
			{
				ans[i] = interval[i][0];
				int add = Math.min(need, interval[i][1] - interval[i][0]);
				need -= add;
				ans[i] += add;
			}
			out.println("YES");
			for(int a:ans)
				out.print(a+" ");
		}
	}
	/************************ SOLUTION ENDS HERE ************************/



	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		solve2(in, out);  // Backtrack solution caused tle 
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
