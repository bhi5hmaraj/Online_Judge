import java.util.*;
import java.io.*;
public class FlippingGameBrute
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }
    private static int[] prefix_0,prefix_1;
    private static int numOfOne(int i,int j)
    {
	return prefix_1[j+1] - prefix_1[i];
    }
    private static int numOfZero(int i,int j)
    {
	return prefix_0[j+1] - prefix_0[i];
    }
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	prefix_0 = new int[len+1];
	prefix_1 = new int[len+1];
	prefix_0[0] = prefix_1[0] = 0;
	for(int i=1;i<=len;i++)         //Calculating prefix array
	{
	    if(arr[i-1] == 0)
	    {
		prefix_0[i] = 1 + prefix_0[i-1];
		prefix_1[i] = prefix_1[i-1];
	    }
	    else
	    {
		prefix_1[i] = 1 + prefix_1[i-1];
		prefix_0[i] = prefix_0[i-1];
	    }
	}
	//System.err.println("0 prefix"+Arrays.toString(prefix_0));
	//System.err.println("1 prefix"+Arrays.toString(prefix_1));
	int big = Integer.MIN_VALUE;
	int countLeft =  0 , countRight = 0;
	for(int i=0;i<len;i++)
	{
	    if(i == 0)
	    {
		for(int j = i;j<len-1;j++)
		{
		    countRight = numOfOne(j+1, len-1);
		    big = Math.max(big, numOfZero(i, j) + countRight);
		}
		big = Math.max(big, numOfZero(0, len-1));
	    }
	    else
	    {
		for(int j = i;j<len;j++)
		{
		    countLeft = numOfOne(0, i-1);
		    if(j != len-1)
			countRight = numOfOne(j+1, len-1);
		    else
			countRight = 0;

		    big = Math.max(big, countLeft + numOfZero(i, j) + countRight);
		}
	    }
	}
	
	out.print(big);
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
