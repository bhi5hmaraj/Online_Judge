import java.util.*;
import java.io.*;
public class CountingTriangles
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static void solve(FastScanner s1, FastWriter out){

		HashSet<Long>[] side = (HashSet<Long>[])new HashSet[3];
		side[0] = new HashSet<>();
		side[1] = new HashSet<>();
		side[2] = new HashSet<>();
		HashSet<Long>[] blacklist = (HashSet<Long>[])new HashSet[3];
		blacklist[0] = new HashSet<>();
		blacklist[1] = new HashSet<>();
		blacklist[2] = new HashSet<>();		
		int n = s1.nextInt();
		long matrix[][] = new long[n][3];
		int unique = 0;
		int temp = n;
		while(temp-->0)
		{
			long in[] = s1.nextLongArray(3);
			Arrays.sort(in);
			matrix[temp] = in;
			boolean res = true;
			for(int i=0;i<3;i++)res &= side[i].contains(in[i]);							
			if(res)			
				for(int i=0;i<3;i++)blacklist[i].add(in[i]);								
			else			
				for(int i=0;i<3;i++)side[i].add(in[i]);						
		}
		while(n-->0)
		{
			long in[] = matrix[n];
			boolean res = true;
			for(int i=0;i<3;i++)res &= blacklist[i].contains(in[i]);
			if(!res)
				unique++;
		}
		//out.println(Arrays.deepToString(side));
		//out.println(Arrays.deepToString(blacklist));
		out.print(unique);
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
