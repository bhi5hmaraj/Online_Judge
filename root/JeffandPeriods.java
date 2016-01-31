import java.util.*;
import java.io.*;
public class JeffandPeriods
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	static class  MyMap <K , V > extends TreeMap<K,ArrayList<V>>
	{
		private static final long serialVersionUID = 1L;    //don't know what it is but eclipse gives me a warning 
		@Override
		public ArrayList<V> put(K key, ArrayList<V> value) {
			return super.put(key, value);
		}

		public void putInChain(K key,V value)
		{
			ArrayList<V> arl = get(key);
			if(arl == null)			
				arl = new ArrayList<>();		
			
			arl.add(value);
			put(key,arl);
		}
	}
	private static void solve(FastScanner s1, FastWriter out){

		int len = s1.nextInt();
		MyMap<Integer,Integer> mp = new MyMap<>();
		ArrayList<String> op = new ArrayList<>(len);
		for(int i=1;i<=len;i++)
			mp.putInChain(s1.nextInt(), i);
		
		StringBuilder sb = new StringBuilder();
		int ct = 0;
		for(Map.Entry<Integer, ArrayList<Integer>> e:mp.entrySet())
		{
			ArrayList<Integer> arl = e.getValue();
			if(arl.size() == 1)
			{
				ct++;
				op.add(e.getKey() + " 0");
			}
			else
			{
				int diff = arl.get(1).intValue() - arl.get(0).intValue();
				boolean flag = true;
				for(int i=2,l = arl.size();i<l;i++)
				{
					if((arl.get(i).intValue() - arl.get(i-1).intValue()) != diff)
					{
						flag = false;
						break;
					}
				}
				if(flag)
				{
					ct++;
					op.add(e.getKey() + " " + diff);
				}
			}
		}
		if(ct==0)
		{
			out.print("0");
		}
		else
		{
			out.println(ct);
			for(String s:op)
				out.println(s);
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
