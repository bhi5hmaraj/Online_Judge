import java.util.*;
import java.io.*;
public class DZYLovesChessboard
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve2(in, out);
	in.close();
	out.close();
    }
    
    static class Pair
    {
	int i,j;
	Pair(int i,int j)
	{
	    this.i = i;
	    this.j = j;
	}
	Pair()
	{
	    this.i=-1;
	    this.j=-1;
	}
    }
    
    static int r , c;
    static char arr[][];
    private static boolean isValid(int i,int j)
    {
	if(i>=0 && i<r && j>=0 && j<c && arr[i][j] != '-')
	    return true;
	else
	    return false;
    }
    
    private static ArrayList<Pair> validCords(Pair p)
    {
	ArrayList<Pair> arl = new ArrayList<>();
	if(isValid(p.i, p.j+1))
	    arl.add(new Pair(p.i, p.j+1));
	if(isValid(p.i+1, p.j))
	    arl.add(new Pair(p.i+1, p.j));
	if(isValid(p.i, p.j-1))
	    arl.add(new Pair(p.i, p.j-1));
	if(isValid(p.i-1, p.j))
	    arl.add(new Pair(p.i-1, p.j));
	
	return arl;
    }
    
    private static void solve2(FastScanner s1 , FastWriter out)
    {
	r = s1.nextInt();
	c = s1.nextInt();
	arr = new char[r][c];
	for(int i=0;i<r;i++)
	    arr[i] = s1.next().toCharArray();
	
	boolean flag1 = true,flag2 = true;;
	for(int i=0;i<r;i++)
	{	  
	    flag2 = true;
	    for(int j =0;j<c;j++)
	    {		
		if(arr[i][j] != '-')
		{
		    if(flag1)
		    {
			if(flag2)
			    arr[i][j] = 'B';
			else
			    arr[i][j] = 'W';			
		    }
		    else
		    {
			if(flag2)
			    arr[i][j] = 'W';
			else
			    arr[i][j] = 'B';			
		    }
		}
		flag2 = !flag2;
	    }
	    flag1 = !flag1;
	}
	
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
		out.print(arr[i][j]);
	    
	    out.println();
	}
    }
    
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	r = s1.nextInt();
	c = s1.nextInt();
	arr = new char[r][c];
	for(int i=0;i<r;i++)
	    arr[i] = s1.next().toCharArray();
	
	Pair curr = new Pair();
	for(int i =0;i<r;i++)
	{
	    for(int j = 0;j<c;j++)
	    {
		curr.i = i;
		curr.j = j;
		char desired ;
		if(arr[i][j] != '-')
		{
		if(arr[i][j] == '.')
		{
		    arr[i][j] = 'W';
		    desired = 'B';
		}
		else if(arr[i][j] == 'B')
		    desired = 'W';
		else
		    desired = 'B';
		for(Pair p:validCords(curr))
		{
		    arr[p.i][p.j] = desired;
		}
		}
	    }
	}
		
	
	for(int i=0;i<r;i++)
	{
	    for(int j = 0;j<c;j++)
	    {
		char ch = arr[i][j];
		curr.i = i;
		curr.j = j;
		if(ch == 'B')
		{
		    for(Pair p:validCords(curr))
			arr[p.i][p.j] = 'W';
		}
		if(ch == 'W')
		{
		    for(Pair p:validCords(curr))
			arr[p.i][p.j] = 'B';
		}
	    }
	}
	
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
		out.print(arr[i][j]);
	    
	    out.println();
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
