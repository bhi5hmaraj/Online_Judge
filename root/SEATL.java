import java.util.*;
import java.io.*;
class SEATL
{

	/************************ SOLUTION STARTS HERE ************************/
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
    public static <Key> void frequency(Map<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    }
	
	private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt();
		while(t-->0)
		{
			int N = s1.nextInt();
			int M = s1.nextInt();
			int max = Integer.MIN_VALUE;
			int arr[][] = new int[N][M];
			HashMap<Integer,Integer>[] row =(HashMap<Integer,Integer>[]) new HashMap[N];
			HashMap<Integer,Integer>[] col =(HashMap<Integer,Integer>[]) new HashMap[M];

			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
				{
					arr[i][j] = s1.nextInt();
					if(row[i] == null)
						row[i] = new HashMap<>();
					if(col[j] == null)
						col[j] = new HashMap<>();
					frequency(row[i], arr[i][j]);
					frequency(col[j], arr[i][j]);					
				}
			//out.println(Arrays.deepToString(row));
			//out.println(Arrays.deepToString(col));
			for(int i=0;i<N;i++)
			{				
				for(int j=0;j<M;j++)
				{
					HashMap<Integer,Integer> freq = new HashMap<>(row[i]);
					freq.put(arr[i][j], freq.get(arr[i][j]) - 1);
					for (Map.Entry<Integer,Integer> e : col[j].entrySet()) 
					{
						int key = e.getKey();
						int val = e.getValue();
						Integer query = freq.get(key);				    
				    	if(query == null)
				    		freq.put(key, val);
				    	else				    	
				    		freq.put(key, query + val);				    	
					}
					//out.println("i = "+i+" j = "+j+" freq "+freq);
					for (Map.Entry<Integer,Integer> e : freq.entrySet()) 
					{
						max = Math.max(max, e.getValue());
					}
				}
			}
			out.println(max);
		}
	}


	/************************ SOLUTION ENDS HERE ************************/

	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		//String input  = "/home/bhishmaraj/Documents/OJ/Java/input.txt";		
		//FastScanner in  = new FastScanner(input);
		FastWriter  out = new FastWriter(System.out);
		//long start = System.nanoTime();		
		solve(in, out);
		//long stop = System.nanoTime();
		//System.err.println("Time : "+((stop-start)/1e9) + " s");
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
		public void print(Object o){
			print(o.toString());
		}
		public void println(Object o){
			print(o.toString());
			print('\n');
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
