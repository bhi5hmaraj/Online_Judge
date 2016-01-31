import java.util.*;
import java.io.*;
public class LongtailHedgehog
{
    
    /************************ SOLUTION STARTS HERE ************************/
    
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    
    private static boolean marked[];
    private static long MAX;
    private static ArrayList<Integer>[] adj;
    private static void dfs(int u, int length)
    {
	marked[u] = true;
	long beauty = (long)adj[u].size() * (long)length;
	MAX = Math.max(MAX, beauty);
	//System.out.println("beauty "+beauty+" length "+ length);
	for(int v:adj[u])
	{
	    if(!marked[v] && v > u)
	    {
		//System.out.println("u = "+u+" v = "+v);
		dfs(v , length + 1);
		marked[v] = false;
	    }
	}
	beauty = (long)adj[u].size() * (long)length;
	MAX = Math.max(MAX, beauty);
	marked[u] = false;
    }
    
    private static void solve(FastScanner s1, FastWriter out){

	int V = s1.nextInt();
	int E = s1.nextInt();
	marked = new boolean[V+1];
	MAX = Long.MIN_VALUE;
	adj = (ArrayList<Integer>[]) new ArrayList[V+1];
	for(int i =1;i<=E;i++)
	{
	    int u = s1.nextInt();
	    int v = s1.nextInt();
	    if(adj[u] == null)
		adj[u] = new ArrayList<>();
	    if(adj[v] == null)
		adj[v] = new ArrayList<>();
	    adj[u].add(v);
	    adj[v].add(u);	    
	}
	
	for(int i = 1;i<=V;i++)
	    if(!marked[i] && adj[i]!=null)
		dfs(i , 1);
	
	out.print(MAX);
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