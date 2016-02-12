import java.util.*;
import java.io.*;
public class uva10107
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB

	private static void solve1(FastScanner s1, FastWriter out){
		String in;
		ArrayList<Long> arl = new ArrayList<>();
		while((in = s1.nextLine()) != null)
		{			
			in = in.trim();
			long n = Long.parseLong(in);
			arl.add(n);
			Collections.sort(arl);
			int len = arl.size();
			long median = 0;
			if(len % 2 == 1)
				median = arl.get(len / 2);
			else
				median = (long)(arl.get(len / 2) + (long)arl.get((len/2)-1)) / 2;
			out.println(median);
		}
	}
	private static void solve2(FastScanner s1, FastWriter out){
		String in;
		PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		PriorityQueue<Integer> right = new PriorityQueue<>();		
		while((in = s1.nextLine()) != null)
		{
			in = in.trim();
			int n = Integer.parseInt(in);
			int l_size = left.size();
			int r_size = right.size();
			if(l_size == 0)
			{
				left.add(n);				
			}
			else if(r_size == 0)
			{
				int l_max = left.poll();
				if(n < l_max)
				{
					right.add(l_max);
					left.add(n);
				}
				else
				{
					right.add(n);
					left.add(l_max);
				}
			}
			else
			{
				if(l_size <= r_size)
				{
					int r_min = right.poll();
					if(n > r_min)
					{
						left.add(r_min);
						right.add(n);
					}
					else
					{
						left.add(n);
						right.add(r_min);
					}
				}
				else
				{
					int l_max = left.poll();
					if(n < l_max)
					{
						right.add(l_max);
						left.add(n);
					}
					else
					{
						right.add(n);
						left.add(l_max);
					}
				}
			}
			l_size = left.size();
			r_size = right.size();
			//out.println("left "+left);
			//out.println("right "+right);
			if(l_size > r_size)
				out.println(left.peek());
			else if(r_size > l_size)
				out.println(right.peek());
			else
			{
				long l = left.peek();
				long r = right.peek();
				long median = (l + r) / 2L;
				out.println(median);
			}
		}
	}
	/************************ SOLUTION ENDS HERE ************************/



	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		solve2(in, out);
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
