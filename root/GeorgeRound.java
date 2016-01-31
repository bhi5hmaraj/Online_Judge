import java.util.*;
import java.io.*;
public class GeorgeRound
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
    static class MultiSet <T> extends TreeMap<T,Integer>
    {
	public void add(T key)
	{
	    Integer q = super.get(key);
	    if(q == null)
		super.put(key, 1);
	    else
		super.put(key, q+1);
	}
	@Override
	public Integer remove(Object key) {
	    Integer q = super.get(key);
	    if(q != null)
	    {
		if(q == 1)
		    super.remove(key);
		else
		    super.put((T)key, q-1);
	    }
	    else
		throw new NullPointerException("The specified key cannot be removed from the map");

	    return q;
	}
    }
	private static void solve(FastScanner s1, FastWriter out){

		MultiSet<Integer> mp = new MultiSet<>();
		int n = s1.nextInt();
		int m = s1.nextInt();
		int arr[] = s1.nextIntArray(n);
		for(int i=1;i<=m;i++)
			mp.add(s1.nextInt());
		
		int ct = 0;
		for(int a:arr)
		{
			Integer ceil = mp.ceilingKey(a);
			if(ceil == null)
				ct++;
			else
				mp.remove(ceil);
			
			//System.out.println(mp);
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
