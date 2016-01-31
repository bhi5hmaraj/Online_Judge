import java.util.*;
import java.io.*;
public class  BinarySearchDirectBenchmark{
	public static void main(String []args) throws IOException {
		Scanner      in  = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		//InputReader    in  = new InputReader(System.in);
		//OutputWriter out = new OutputWriter(System.out);
		//solve1(in, out);
		solve2(in,out);
		out.close();
		//in.close();
	}
	static int arr1[];
	static  void shuffleArray(int[] array) {
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	static int upperBound(int key)    //Number of elements LESS THAN OR EQUAL TO key 
	{
		int first=0,last=arr1.length-1,middle=-1;
		int less_and_equal=0;
		while(first <= last)
		{
			middle = (first+last)/2;
			if(key>=arr1[middle])
			{
				less_and_equal+=((middle-first)+1);
				first=middle+1;
			}
			else
				last=middle-1;
		}
		return less_and_equal;
	}
	private static void solve1(Scanner s1, OutputWriter out){

		int m = s1.nextInt();
		int n = s1.nextInt();
		arr1 = new int[m];
		for(int i=0;i<m;i++)
			arr1[i] = s1.nextInt();
		int arr2[] = s1.nextIntArray(n);
		shuffleArray(arr1);
		//arr1 = Arrays.stream(arr1).parallel().sorted().toArray();
		Arrays.sort(arr1);
		for(int i=0;i<n;i++)
		{
			out.print(upperBound(arr2[i]));
			out.print(' ');
		}

	}
	private static void solve2(Scanner in, PrintWriter out){

		int m = in.nextInt();
		int n = in.nextInt();
		arr1 = new int[m];
		for(int i=0;i<m;i++)
			arr1[i] = in.nextInt();
		int arr2[] = in.nextIntArray(n);
		shuffleArray(arr1);
		//arr1 = Arrays.stream(arr1).parallel().sorted().toArray();
		Arrays.sort(arr1);
		for(int i=0;i<n;i++)
		{
			out.print(upperBound(arr2[i]));
			out.print(' ');
		}

	}
	static class Scanner{
		public BufferedReader reader;
		public StringTokenizer st;
		public Scanner(InputStream stream){
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
	static class OutputWriter{
		BufferedWriter writer;
		public OutputWriter(OutputStream stream){
			writer = new BufferedWriter(new OutputStreamWriter(stream));
		}
		public void print(int i) {
			try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
		}
		public void print(long i) {
			try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
		}
		public void print(double i) {
			try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
		}
		public void print(boolean i) {
			try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
		}
		public void print(char i) {
			try{writer.write(i);} catch(IOException e){e.printStackTrace();}
		}
		public void print(Object o){
			try{writer.write(o.toString());} catch(IOException e){e.printStackTrace();}
		}
		public void print(Object o[]){
			try{writer.write(Arrays.deepToString(o));} catch(IOException e){e.printStackTrace();}
		}
		public void print(String s){
			try{writer.write(s);} catch(IOException e){e.printStackTrace();}
		}
		public void println(){
			try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
		}
		public void print(char []c){
			try{writer.write(c);} catch(IOException e){e.printStackTrace();}
		}
		public void close(){
			try{writer.close();} catch(IOException e){e.printStackTrace();}
		}
	}
	static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if(numChars == -1)
				throw new InputMismatchException();
			if(curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch(IOException e) {
					throw new InputMismatchException();
				}
				if(numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while(isSpaceChar(c))
				c = read();
			int sgn = 1;
			if(c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if(c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while(!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if(filter != null)
				return filter.isSpaceChar(c);
			return isWhitespace(c);
		}

		public static boolean isWhitespace(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);

		}

	}

	static class IOUtils {
		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for(int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}

	}
}