import java.util.*;
import java.awt.geom.Point2D;
import java.io.*;
class TRIANGCL
{
	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	/************************ SOLUTION STARTS HERE ************************/

	static final double epsilon = Math.pow(2, -53);
	

	private static boolean isEqual(double a,double b)
	{
		double div = a / b;
		return Math.abs(div - 1.0) < epsilon;			
	}

	private static void subtask1(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int t = s1.nextInt(); 
		
		while(t-->0)
		{
			Point2D.Double p1 = new Point2D.Double(s1.nextInt(), s1.nextInt()); 
			Point2D.Double p2 = new Point2D.Double(s1.nextInt(), s1.nextInt());
			Point2D.Double p3 = new Point2D.Double(s1.nextInt(), s1.nextInt());
			Double d1 = p1.distanceSq(p2);
			Double d2 = p1.distanceSq(p3);
			Double d3 = p2.distanceSq(p3);
			if(!(isEqual(d1, d2) || isEqual(d2, d3) || isEqual(d1, d3)))
				out.println("Scalene triangle");
			else
				out.println("Isosceles triangle");
		}
	}
	private static boolean greater(double a,double b)
	{
		double div = a / b;
		return (div - 1.0) > epsilon;	
	}
	private static void subtask2(FastScanner s1, FastWriter out)/* This is the actual solution */{

		int t = s1.nextInt();
		while(t-->0)
		{
			Point2D.Double p1 = new Point2D.Double(s1.nextInt(), s1.nextInt()); 
			Point2D.Double p2 = new Point2D.Double(s1.nextInt(), s1.nextInt());
			Point2D.Double p3 = new Point2D.Double(s1.nextInt(), s1.nextInt());

			Double d1 = p1.distanceSq(p2);
			Double d2 = p1.distanceSq(p3);
			Double d3 = p2.distanceSq(p3);
			StringBuilder sb = new StringBuilder();
			if(!(isEqual(d1, d2) || isEqual(d2, d3) || isEqual(d1, d3)))
				sb.append("Scalene ");
			else
				sb.append("Isosceles ");
			
			double arr[] = new double[3];
			arr[0] = d1;
			arr[1] = d2;
			arr[2] = d3;
			Arrays.sort(arr);
			if(isEqual(arr[0]+arr[1], arr[2]))
				sb.append("right ");
			else if(greater(arr[0]+arr[1], arr[2]))
				sb.append("acute ");
			else
				sb.append("obtuse ");
			
			sb.append("triangle");
			out.println(sb.toString());
		}

	}

	private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
		int subId = s1.nextInt();
		if(subId == 1)
			subtask1(s1, out);
		else
			subtask2(s1, out);
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
