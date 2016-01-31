import java.util.*;
import java.io.*;
class OldMonk
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static int customCeil(long arr[] , long key) //if it exists then returns the lower bound or else returns -(pos+1)
    {
	int lo = 0;
	int hi = arr.length-1;
	int mid =0;
	int pos = -1;
	boolean flag = false;
	while(lo <= hi)
	{
	    mid = (lo+hi)/2;
	    if(arr[mid] >= key)
	    {
		if(arr[mid] == key && !flag)
		    flag = true;
		lo = mid+1;
		pos = mid;
	    }
	    else
	    {
		hi = mid-1;
	    }
	}
	return pos;
    }
    
    
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int len = s1.nextInt();
	    long a[] = s1.nextLongArray(len);
	    long b[] = s1.nextLongArray(len);
	    int max = 0;
	    for(int i = 0;i<len;i++)
	    {
		if(b[i] < a[i])
		    continue;
		else
		{
		    int j = customCeil(b, a[i]);
		    max = Math.max(max, j-i);
		}
	    }
	    out.println(max);
	}
    }
    
    /************************ TEMPLATE STARTS HERE ************************/
    
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
