
import java.util.*;
import java.io.*;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.*;;
public class Constellation
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB

	private static boolean contains(Polygon poly,Point2D.Double p)
	{
		int x[]= poly.xpoints;
		int y[]= poly.ypoints;
		Line2D.Double arr[] = new Line2D.Double[3];
		arr[0] = new Line2D.Double(x[0], y[0], x[1], y[1]);
		arr[1] = new Line2D.Double(x[1], y[1], x[2], y[2]);
		arr[2] = new Line2D.Double(x[0], y[0], x[2], y[2]);
		for(Line2D.Double line:arr)
			if(line.ptSegDist(p) == 0.0)
				return false;

		return poly.contains(p);
	}

	private static boolean equal(double d1 , double d2)
	{
		return Math.round(Math.abs(d1 - d2)) == 0.0;
	}

	private static double slopeTo(Point2D.Double p1 , Point2D.Double p2)
	{
		if(equal(p1.getX(),p2.getX()))
			return Double.POSITIVE_INFINITY;
		else if(equal(p1.getY(),p2.getY()))
			return 0.0;
		else {
			Double numer = p2.getY() - p1.getY();
			Double denom = p2.getX() - p1.getX();
			double slope = numer / denom;
			return slope;
		}

	}
	private static Polygon formTriangle(Point2D.Double ... p)
	{
		int x[] = new int[3];
		int y[] = new int[3];
		int i=0;
		for(Point2D.Double point:p)
		{
			x[i] = (int)point.getX();
			y[i] = (int)point.getY();
			i++;
		}
		Polygon poly = new Polygon(x, y, 3);
		return poly;
	}
	private static void solve(FastScanner s1, FastWriter out){

		int n = s1.nextInt();
		Point2D.Double input[] = new Point2D.Double[n];
		HashMap<Point2D.Double,Integer> mp = new HashMap<>();
		for(int i=0;i<n;i++)
		{
			int x = s1.nextInt();
			int y = s1.nextInt();			
			input[i] = new Point2D.Double(x, y);
			mp.put(input[i], i+1);
		}
		Point2D.Double sec = input[1];
		Line2D.Double line = new Line2D.Double(input[0], sec);		
		//System.out.println(line.contains(2, 0));
		for(int i=2;i<n;i++)
		{
			if(line.ptSegDist((input[i])) == 0.0)
			{
				sec = input[i];
				//System.out.println(sec);
				line = new Line2D.Double(input[0], sec);
			}
		}
		//System.out.println(sec);
		double initSlope = slopeTo(input[0],sec);
		int pt = 1;
		Point2D.Double third = input[pt];

		while(equal(initSlope,slopeTo(third, input[0])))
			third = input[pt++];
		//System.out.println(third);
		Polygon poly = formTriangle(input[0],sec,third);

		for(int i=1;i<n;i++)
		{			
			if(contains(poly, input[i]))
			{				
				third = input[i];
				poly = formTriangle(input[0],sec,third);

			}
		}
		//System.out.println(third);		
		out.print("1 "+mp.get(sec)+" "+mp.get(third));

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
