import java.util.*;
import java.io.*;
public class LefthandersandRighthanders
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static String getCorrectOreientation(int i,int j,char arr[])
	{
		if(arr[i] == arr[j])
			return (i+1) + " "+ (j+1);
		else
			return (arr[i] == 'L')?((i+1) + " "+ (j+1)):((j+1) + " "+ (i+1));
	}
	private static void solve(FastScanner s1, FastWriter out){

		int len = s1.nextInt();
		char hand[] = s1.nextLine().toCharArray();
		if((len/2)%2 == 0)
		{
			for(int i=0;i+2< len;i+=4)
				out.println(getCorrectOreientation(i, i+2, hand));
			for(int i=1;i+2< len;i+=4)
				out.println(getCorrectOreientation(i, i+2, hand));
		}
		else
		{
			for(int i=0;i+4<=len;i+=4)
				out.println(getCorrectOreientation(i, i+2, hand));
			for(int i=3;i+2<len;i+=4)
				out.println(getCorrectOreientation(i, i+2, hand));
			
			out.println(getCorrectOreientation(len-2, 1, hand));			
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
		public void print(Object o){
			print(o.toString());
		}
		public void println(Object o){
			print(o.toString());
			print('\n');
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
