import java.util.*;
import java.io.*;
public class Bath
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	
	private static double getT(int t1,int t2,int y1,int y2)
	{
		double t = (double)((y1*t1) + (y2*t2)) / (double)(y1+y2);
		return t;
	}
	private static void solve(FastScanner s1, FastWriter out){

			int t1 = s1.nextInt();
			int t2 = s1.nextInt();
			int x1 = s1.nextInt();
			int x2 = s1.nextInt();
			int t0 = s1.nextInt();
			int x=-1,y=-1;
			double t = getT(t1,t2,x1,x2);
			
			if(t1 == t2 )
			{
				if(x1>x2)
					out.print(x1+" 0");
				else
					out.print("0 "+x2);
				return;
			}
			for(int i=x1;i>=0;i--)
			{
				double y2 = (double)(i * (t0 - t1)) / ((double)(t2 - t0));
				if(i == 0)
					y2 = x2;
				//System.out.println("y2"+y2);
				int floor = (int) Math.floor(y2);
				int ceil = 	(int) Math.ceil(y2);
				//System.out.println("ceil"+ceil);
				if(floor>=0 && floor<=x2)
				{
					double currT = getT(t1, t2, i, floor);
					//System.out.println(currT);
					if(currT >= t0)
					{
					if(Math.abs(currT - (double)t0) < Math.abs(t - (double)t0))
					{
						t = currT;
						x = i;
						y = floor;
						//System.out.println("x="+x+"y="+y);
					}
					}
				}
				if(ceil>=0 && ceil<=x2)
				{
					double currT = getT(t1, t2, i, ceil);
					//System.out.println(currT);
					if(currT >= t0)
					{
					if(Math.abs(currT - (double)t0) < Math.abs(t - (double)t0))
					{
						t = currT;
						x = i;
						y = ceil;
						//System.out.println("x="+x+"y="+y);
					}	
					}
				}
			}
			out.print(x+" "+y);
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
