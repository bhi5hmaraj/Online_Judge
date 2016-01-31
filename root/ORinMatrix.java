import java.util.*;
import java.io.*;
public class ORinMatrix
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	int r = s1.nextInt();
	int c = s1.nextInt();
	byte arr[][] = new byte[r][c];
	HashSet<Integer> rows = new HashSet<>();
	HashSet<Integer> cols = new HashSet<>();
	for(int i=0;i<r;i++)
	    for(int j=0;j<c;j++)
	    {
		byte b = Byte.parseByte(s1.next());
		if(b == 0)
		{
		    rows.add(i);
		    cols.add(j);		    
		}
		arr[i][j] = b;
	    }

	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		boolean f1=true,f2 = true;
		if(arr[i][j] == 1)
		{
		    for(int row = 0;row<r;row++)
		    {
			if(row != i)
			{
			    if(arr[row][j] != 1)
			    {
				f1 = false;
				break;
			    }
			}
		    }
		    for(int col = 0;col < c;col++)
		    {
			if(col != j)
			{
			    if(arr[i][col] != 1)
			    {
				f2 = false;
				break;
			    }
			}
		    }

		    if(!(f1|f2))
		    {
			out.print("NO");
			return;
		    }
		}
	    }
	}


	byte output[][] = new byte[r][c];
	for(int i = 0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		if(rows.contains(i) || cols.contains(j))
		{
		    output[i][j] = 0;
		}
		else
		{
		    output[i][j] = 1;
		}
	    }
	    //out.println();
	}
	byte B[][] = new byte[r][c];
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		boolean bool = false;
		for(int row = 0;row<r;row++)
		{ bool |= toBoolean(output[row][j]); }

		for(int col = 0;col < c;col++)
		{ bool |= toBoolean(output[i][col]); }

		B[i][j] = (bool) ? (byte)1 : (byte)0;
	    }

	}
	
	boolean result = true;
	outer:
	for(int i=0;i<r;i++)
	    for(int j=0;j<c;j++)
		if(B[i][j] != arr[i][j])
		{
		    result = false;
		    break outer;
		}
	
	if(result)
	{
	    out.println("YES");
	    for(int i=0;i<r;i++)
	    {
		for(int j=0;j<c;j++)
		{
		    out.print(output[i][j]);
		    out.print(" ");
		}
		out.println();
	    }
	}
	else
	    out.print("NO");
    }    
    private static boolean toBoolean(byte b)
    { return b == 1 ;}

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
