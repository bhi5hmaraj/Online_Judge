import java.util.*;
import java.awt.geom.Point2D;
import java.io.*;
public class WateringFlowers
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	private static Point2D.Double f1,f2;
	static class myComparator implements Comparator<Point2D.Double>
	{
		@Override
		public int compare(java.awt.geom.Point2D.Double o1, java.awt.geom.Point2D.Double o2) {
			Double dist1 = f1.distanceSq(o1);
			Double dist2 = f1.distanceSq(o2);
			return dist1.compareTo(dist2);
		}
	}
	
	private static void solve(FastScanner s1, FastWriter out){
	int len = s1.nextInt();
	f1 = new Point2D.Double(s1.nextInt(), s1.nextInt());
	f2 = new Point2D.Double(s1.nextInt(), s1.nextInt());
	Point2D.Double arr[] = new Point2D.Double[len];
	for(int i=0;i<len;i++)
		arr[i] = new Point2D.Double(s1.nextInt(), s1.nextInt());

		Arrays.parallelSort(arr, new myComparator());
		Double min = Double.MAX_VALUE;
		for(int i=-1;i<len;i++)
		{
			Double r1 = (i>=0)?f1.distanceSq(arr[i]):0.0;
			Double r2 = (i==len-1)?0.0:Double.MIN_VALUE;
			for(int j=len-1;j>i;j--)
			{
				r2 = Math.max(r2, f2.distanceSq(arr[j]));
			}
			min = Math.min(min, Math.round(r1) + Math.round(r2));
		}
		out.print(min.longValue());
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
