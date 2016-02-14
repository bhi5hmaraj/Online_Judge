import java.util.*;
import java.io.*;
public class uva_11926
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB

	static class Interval implements Comparable<Interval>
	{
		int l,r;
		Interval(int l,int r)
		{
			this.l = l;
			this.r = r;
		}
		@Override
		public int compareTo(Interval o) {
			return this.l - o.l;
		}

		@Override
		public String toString() {
			return "("+l+", "+r+")";
		}
	}

	private static boolean isColliding(TreeSet<Interval> set,Interval inter)
	{
		Interval floor = set.floor(inter);
		Interval ceil = set.ceiling(inter);
		if(floor == null && ceil == null)
			return false;
		else if(floor == null)		
			return !(inter.r <= ceil.l);
		else if(ceil == null)
			return !(inter.l >= floor.r);
		else
			return !(inter.l >= floor.r && inter.r <= ceil.l);		
	}
	private static boolean isColliding(BitSet b,int l,int r)
	{
		
		if(l+1 == r)
		{
			return b.get(l) && b.get(r);
		}
		
		
		for(int i=l+1;i<r;i++)
			if(b.get(i))
				return true;

		return false;
	}
	private static void solve2(FastScanner s1, FastWriter out){
		while(true)
		{
			int n = s1.nextInt();
			int m = s1.nextInt();
			if(n == 0 && m == 0)
				return;
			Interval inter = new Interval(-1, -1);
			BitSet b = new BitSet((int)(1e6) + 10);
			boolean flag = false;
			while(n-->0)
			{
				if(!flag)
				{
					inter.l = s1.nextInt();
					inter.r = s1.nextInt();
					if(!isColliding(b, inter.l,inter.r))
						b.set(inter.l, inter.r+1);
					else					
						flag = true;					
					
				}
				else
				{
					s1.nextInt();
					s1.nextInt();
				}
			}
			//System.out.println(flag);
			if(flag)
			{
				while(m-->0){s1.nextInt();s1.nextInt();s1.nextInt();}
				out.println("CONFLICT");
				continue;
			}
			else
			{				
				while(m-->0)
				{
					if(!flag)
					{
						int l = s1.nextInt();
						int r = s1.nextInt();
						int period = s1.nextInt();

						

						outer:
						while(true)
						{
							if(l+1 == r)
							{
								if( b.get(l) && b.get(r))
								{
									flag = true;
									break;
								}
							}
							for(int i=l;i <= r;i++)
							{
								if(i > (int)(1e6))
									break; 	
								if(b.get(i) && i != l && i != r)
								{
									flag = true;
									break outer;
								}
								else
								{
									b.set(i);
								}
							}
							l += period;
							r += period;
							if(l > (int)(1e6))
								break;
						}
					}
					else
					{
						s1.nextInt();s1.nextInt();s1.nextInt();
					}
				}
				if(flag)
					out.println("CONFLICT");
				else
					out.println("NO CONFLICT");
			}

		}

	}


	private static void solve(FastScanner s1, FastWriter out){
		while(true)
		{
			int n = s1.nextInt();
			int m = s1.nextInt();
			if(n == 0 && m == 0)
				return;

			//System.out.println("hi");

			Interval inter = new Interval(-1, -1);
			TreeSet<Interval> set = new TreeSet<>();
			boolean flag = false;
			while(n-->0)
			{
				if(!flag)
				{
					inter.l = s1.nextInt();
					inter.r = s1.nextInt();
					if(!isColliding(set, inter))
						set.add(new Interval(inter.l, inter.r));
					else
					{
						flag = true;					
					}
				}
				else
				{
					s1.nextInt();
					s1.nextInt();
				}
			}
			//System.out.println(flag);
			if(flag)
			{
				while(m-->0){s1.nextInt();s1.nextInt();s1.nextInt();}
				out.println("CONFLICT");
				continue;
			}
			else
			{				
				while(m-->0)
				{
					if(!flag)
					{
						int l = s1.nextInt();
						int r = s1.nextInt();
						int period = s1.nextInt();
						for(int i=0;(period * i)+l <= 100000000;i++)
						{
							inter.l = (period * i)+l;
							inter.r = (period * i)+r;
							if(!isColliding(set, inter))
								set.add(new Interval(inter.l, inter.r));
							else
							{
								flag = true;
								break;
							}
						}
					}
					else
					{
						s1.nextInt();s1.nextInt();s1.nextInt();
					}
				}
				if(flag)
					out.println("CONFLICT");
				else
					out.println("NO CONFLICT");
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
