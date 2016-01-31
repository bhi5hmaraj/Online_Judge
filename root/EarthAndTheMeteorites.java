import java.util.*;
import java.io.*;
class EarthAndTheMeteorites
{
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int N = s1.nextInt();
	    int M = s1.nextInt();
	    int Q = s1.nextInt();
	    TreeSet<Integer> X = new TreeSet<>();
	    TreeSet<Integer> Y = new TreeSet<>();
	    X.add(1); X.add(N);
	    Y.add(1); Y.add(M);
	    while(Q-->0)
	    {
		X.add(s1.nextInt());
		Y.add(s1.nextInt());
	    }
	    int xArr[] = new int[X.size()];
	    int yArr[] = new int[Y.size()];
	    
	    int ct = 0;
	    for(int x:X)
		xArr[ct++] = x;
	    
	    ct = 0;
	    for(int y:Y)
		yArr[ct++] = y;

	    long smallArea = Long.MAX_VALUE;
	    long bigArea   = Long.MIN_VALUE;

	    int smallX     = Integer.MAX_VALUE;
	    int bigX       = Integer.MIN_VALUE;

	    int smallY     = Integer.MAX_VALUE;
	    int bigY       = Integer.MIN_VALUE;
	    
	    for(int i=1;i<xArr.length;i++)
	    {
		int diff = xArr[i] - xArr[i-1];
		if(diff < smallX)
		    smallX = diff;
		if(diff > bigX)
		    bigX = diff;
	    }

	    for(int i=1;i<yArr.length;i++)
	    {
		int diff = yArr[i] - yArr[i-1];
		if(diff < smallY)
		    smallY = diff;
		if(diff > bigY)
		    bigY = diff;
	    }

	    smallArea =  (long)smallX * (long)smallY;
	    bigArea = 	 (long)bigX * (long)bigY;
	    long total = (long)(xArr.length-1) * (long)(yArr.length-1);
	    out.println(total+" "+smallArea+" "+bigArea);
	}
    }

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
