import java.util.*;
import java.io.*;
public class Guessanumber
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	static int lo = (int)(-2e9), hi =(int)(2e9);
	private static void process(String choice,int n,char flag)
	{
		if(choice.equals("<"))
		{
			if(flag=='Y')
				hi = (n-1)<hi?n-1:hi;
			else
				lo = n>lo?n:lo;
		}
		else if(choice.equals("<="))
		{
			if(flag=='Y')
				hi = n<hi?n:hi;
			else
				lo = n+1>lo?n+1:lo;
		}
		else if(choice.equals(">"))
		{
			if(flag=='Y')			
				lo = n+1>lo?n+1:lo;
			else
				hi = n<hi?n:hi;
		}
		else
		{
			if(flag=='Y')
				lo = n>lo?n:lo;
			else
				hi = n-1<hi?n-1:hi;
		}
	}
	
	private static void solve(FastScanner s1, FastWriter out){

		int queries = s1.nextInt();
		boolean flag = true;
		while(queries-->0)
		{
			String line[] = s1.nextLine().split(" ");
			process(line[0], Integer.parseInt(line[1]), line[2].charAt(0));
			if(lo > hi)
				flag = false;
		}
		if(flag)
			out.print(lo);
		else
			out.print("Impossible");
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
