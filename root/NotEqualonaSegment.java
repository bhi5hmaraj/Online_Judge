import java.util.*;
import java.io.*;
public class NotEqualonaSegment
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	
	static class Pair implements Comparable<Pair>
	{
		int index, GLIndex /*Greatest index such that the 2 values at these indices are not equal */;
		Pair(int index,int GLIndex)
		{
			this.index = index;
			this.GLIndex = GLIndex;
		}
		@Override
		public int compareTo(Pair o) {
			return this.index  - o.index;
		}
		@Override
		public String toString() {
			return "Index = "+index+" GLIndex = "+GLIndex;
		}
	}
	private static void solve(FastScanner s1, FastWriter out){

		int len = s1.nextInt();
		int q = s1.nextInt();
		HashMap<Integer,ArrayList<Pair>> mp = new HashMap<>();
		for(int i=1;i<=len;i++)
		{
			int num = s1.nextInt();
			ArrayList<Pair> arl = mp.get(num);
			if(arl == null)
			{
				arl = new ArrayList<>();
				arl.add(new Pair(i, -1));
			}
			else
			{
				int size = arl.size();			
				if((i - arl.get(size-1).index) == 1)
					arl.add(new Pair(i, arl.get(size-1).GLIndex));
				else
					arl.add(new Pair(i, i-1));
			}
			mp.put(num, arl);
		}
		Pair checker = new Pair(-1, -1);
		while(q-->0)
		{
			int l = s1.nextInt();
			int r = s1.nextInt();
			ArrayList<Pair> arl = mp.get(s1.nextInt());
			if(arl == null)
				out.println(l);
			else
			{
				checker.index = l;
				int L_index = Collections.binarySearch(arl, checker);
				if(L_index < 0)
				{
					out.println(l);
					continue;
				}
				checker.index = r;
				int R_index = Collections.binarySearch(arl, checker);
				if(R_index < 0)
				{
					out.println(r);
					continue;
				}
				if((R_index - L_index + 1) == (r - l + 1))
				{
					out.println(-1);
					continue;
				}
				
				if(arl.get(L_index).GLIndex >= l)
				{
					out.println(arl.get(L_index).GLIndex);
					continue;
				}
				if(arl.get(R_index).GLIndex <= r)
				{
					out.println(arl.get(R_index).GLIndex);
					continue;
				}
				
				out.println(-1);
			}
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
