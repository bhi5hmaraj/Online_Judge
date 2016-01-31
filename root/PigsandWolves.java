import java.util.*;
import java.io.*;
public class PigsandWolves
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static int r,c;
	private static char arr[][] ;
	static boolean isValid(int i,int j)
	{
		if(i<0 || j<0 || i>=r || j>=c || arr[i][j] == '.' || arr[i][j] == 'W')
			return false;
		else
			return true;
	}
	private static void solve(FastScanner s1, FastWriter out){

		r = s1.nextInt();
		c = s1.nextInt();
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		arr = new char[r][c];
		for(int i=0;i<r;i++)
			arr[i] = s1.next().toCharArray();
		
		int ct = 0;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(arr[i][j] == 'W')
				{
					for(int k=0;k<4;k++)
					{
						if(isValid(i+dx[k],j+dy[k]))
						{
							ct++;
							arr[i+dx[k]][j+dy[k]] = '.';
							break;
						}
					}
				}
			}
		}
		out.print(ct);
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
