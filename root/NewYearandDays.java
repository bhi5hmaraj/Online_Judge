import java.util.*;
import java.io.*;
public class NewYearandDays
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	String str = s1.nextLine();
	//System.out.println(str);
	if(str.indexOf("week") >= 0 )
	{
	    	int n = Integer.parseInt(str.split(" ")[0]);
	 	Calendar start = Calendar.getInstance();
	        start.set(2016, 0, 1);
	        Calendar end = Calendar.getInstance();
	        end.set(2016, 11, 31);
	        int day = (n==7)?1:n+1;
	        int week =0 ;
	        while(start.before(end))
	        {
	            if(start.get(Calendar.DAY_OF_WEEK) == day)
	            {
	        	week++;
	        	start.add(Calendar.DATE, 7);
	            }
	            else
	            {
	        	start.add(Calendar.DATE, 1);
	            }
	        }
	        out.print(week);
	}
	else
	{
	    	int n = Integer.parseInt(str.split(" ")[0]);
	    	//System.out.println(n);
	    	Calendar start = Calendar.getInstance();
	        start.set(2016, 0, 1);
	        Calendar end = Calendar.getInstance();
	        end.set(2016, 11, 31);
	        int day = 0;
	        while(start.before(end))
	        {
	            //System.out.println(start.get(Calendar.DAY_OF_MONTH));
	            if(start.get(Calendar.DAY_OF_MONTH) == n)
	            {
	        	day++;
	            }
	            start.add(Calendar.DATE, 1);
	        }
	        out.print(day);
	}
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
}
