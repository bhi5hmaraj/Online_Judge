import java.util.*;
import java.io.*;
public class HelpVasilisatheWise
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static int c1,c2,d1,d2,r1,r2;
	private static int arr[] = new int[4];
	private static boolean check(int a,int b,int c,int d)
	{		
		return a+b==r1 && c+d == r2 && a+c==c1 && b+d == c2 && a+d==d1 && b+c==d2;
	}
	private static int[] recurse(int ct)
	{
		if(ct == 4)
		{
			if( check(arr[0],arr[1],arr[2],arr[3]))
				return arr;
			else
				return null;
		}
		else
		{
			int a[] = null;
			for(int i=1;i<=9;i++)
			{
				arr[ct] = i;
				a = recurse(ct+1);
				if(a!=null)
					return a;
			}
			return a;
		}
	}
	private static void solve(FastScanner s1, FastWriter out){

		r1 = s1.nextInt();
		r2 = s1.nextInt();
		c1 = s1.nextInt();
		c2 = s1.nextInt();
		d1 = s1.nextInt();
		d2 = s1.nextInt();
		int ans[] = recurse(0);
		if(ans == null)
			out.print("-1");
		else
		{
			int freq[] = new int [10];
			for(int a:ans)
				freq[a]++;
			for(int f:freq)
				if(f>1)
				{
					out.print("-1");
					return;
				}
			out.print(ans[0]+" "+ans[1]+"\n"+ans[2]+" "+ans[3]);
		}
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
