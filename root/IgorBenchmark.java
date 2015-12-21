import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class IgorBenchmark {
    static int  r,c;
    static char[][] chars;
    static boolean marked[];
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int id[];
    static boolean isValid(int i,int j)
    {
	if(i<0 || j<0 || i>=r || j>=c || chars[i][j] == '*')
	    return false;
	else
	    return true;
    }
    static int to1D(int i,int j)
    {
	return (i*c)+j;
    }
    static Iterable<Pair> adj(Pair p)
    {
	int i = p.i;
	int j = p.j;
	ArrayList<Pair> adj  = new ArrayList<>();
	if(isValid(i+1, j))
	    adj.add(new Pair(i+1,j));
	if(isValid(i-1, j))
	    adj.add(new Pair(i-1, j));
	if(isValid(i, j+1))
	    adj.add(new Pair(i, j+1));
	if(isValid(i, j-1))
	    adj.add(new Pair(i, j-1));
	return adj;
    }
    static int numberOfstars(Pair p)
    {
	int i = p.i;
	int j = p.j;
	int ct = 0;
	if(chars[i][j+1]=='*')
	    ct++;
	if(chars[i][j-1]=='*')
	    ct++;
	if(chars[i+1][j]=='*')
	    ct++;
	if(chars[i-1][j]=='*')
	    ct++;
	
	return ct;
	    
    }
    static class Pair 
    {
	int i,j;
	Pair()
	{
	    this(0,0);
	}
	Pair(int i,int j)
	{
	    this.i = i;
	    this.j = j;
	}
	int to1D()
	{
	    return (i*c)+j;
	}
    }
    static int path(Pair p,int uid)
    {
	Queue<Pair> q = new LinkedList<>();
	q.add(p);
	marked[p.to1D()] = true;
	id[p.to1D()] = uid;
	int total = numberOfstars(p);
	while(!q.isEmpty())
	{
	    Pair u = q.remove();
	    for(Pair v:adj(u))
		if(!marked[v.to1D()])
		{
		    marked[v.to1D()] = true;
		    id[v.to1D()] = uid;
		    total += numberOfstars(v);
		    q.add(v);
		}
	}
	return total;
    }
    public static void main(String []args) throws IOException {
	Scanner in = new Scanner(System.in);
	OutputWriter out = new OutputWriter(System.out);  		
	solve(in, out);
	out.close();
	in.close();
    }
    private static void solve(Scanner s1, OutputWriter out){		
        r = s1.nextInt();
        c = s1.nextInt();     
        int query = s1.nextInt();
        chars = new char[r][c];
        for(int i=0;i<r;i++)
        {
        	String line = s1.next();        	
        	chars[i]  = line.toCharArray();
        }        
        //long start = System.nanoTime();
        marked = new boolean [r*c];
        id = new int[r*c];
        Pair p = new Pair();
        int uid = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
        	if(chars[i][j] == '.' && !marked[to1D(i, j)])
        	{
        	    p.i = i;
        	    p.j = j;
        	    map.put(uid, path(p, uid++));
        	}
            }
        }
        while(query-->0)
        {
            out.print(map.get(id[to1D(s1.nextInt()-1, s1.nextInt()-1)]) );
            out.println();
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
 	    try{reader.close();} catch(IOException e){e.printStackTrace();}	
 	}
     }
    static class OutputWriter{
 	BufferedWriter writer;
 	public OutputWriter(OutputStream stream){
 	    writer = new BufferedWriter(new OutputStreamWriter(stream));
 	}
 	public void print(int i) {
 	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
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
}
