import java.util.*;
import java.io.*;
public class LuckySubstring
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	
	private static boolean isLucky(String n)
	{
		int len = n.length();
		for(int i=0;i<len;i++)
		{
			if(!(n.charAt(i)=='4' || n.charAt(i) == '7'))
				return false;
		}
		return true;
	}	
    private static <Key> void frequency(Map<Key , java.lang.Integer> mp , Key k)
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
    
    private static String[] substrings(String in)
    {
    	int len = in.length();
    	String sub[] = new String[((len) * (len + 1)) / 2];
    	int ptr = 0;
    	for(int i=0;i<len;i++)		
			for(int j=i;j<len;j++)			
				sub[ptr++] = in.substring(j - i, j+1);
    	
    	return sub;
    }
	private static void solve(FastScanner s1, FastWriter out){

		String in = s1.next();
		int len = in.length();
		TreeMap<String ,Integer> freq = new TreeMap<>();
		for(int i=0;i<len;i++)
		{
			for(int j=i;j<len;j++)
			{
				String sub = in.substring(j - i, j+1);
				//System.out.println(sub);
				if(sub.charAt(0) != '0')
				{
					if(isLucky(sub))
						frequency(freq, sub);
				}

			}
		}
		int max = Integer.MIN_VALUE;
		for(Map.Entry<String , Integer> e : freq.entrySet())
			max = Math.max(max, e.getValue());
		for(Map.Entry<String , Integer> e: freq.entrySet())
			if(e.getValue() == max)
			{
				out.print(e.getKey());
				return;
			}
		
		out.print("-1");
	}

	private static void solve2(FastScanner s1 , FastWriter out)
	{
		String in = s1.next();
		int len = in.length();
		int four = 0, seven = 0;
		for(int i=0;i<len;i++)
		{
			if(in.charAt(i) == '4')
				four++;
			if(in.charAt(i) == '7')
				seven++;
		}
		if(four == 0 && seven == 0)
			out.print("-1");
		else
			out.print((four>=seven)?"4":"7");
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
