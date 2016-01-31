import java.util.*;
import java.io.*;


public class TheLabyrinth
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    static class WeightedQuickUnionUF {
	int[] parent;   // parent[i] = parent of i
	int[] size;     // size[i] = number of sites in subtree rooted at i
	int count;      // number of components
	public WeightedQuickUnionUF(int N) {
	    count = N;
	    parent = new int[N];
	    size = new int[N];
	    for (int i = 0; i < N; i++) {
		parent[i] = i;
		size[i] = 1;
	    }
	}
	public int count() {
	    return count;
	}
	public int find(int p) {
	    while (p != parent[p])
	    {
		parent[p] = parent[parent[p]];    // path compression by halving
		p = parent[p];
	    }
	    return p;
	}

	public boolean connected(int p, int q) {
	    return find(p) == find(q);
	}
	public void union(int p, int q) {
	    int rootP = find(p);
	    int rootQ = find(q);
	    if (rootP == rootQ) return;

	    // make smaller root point to larger one
	    if (size[rootP] < size[rootQ]) {
		parent[rootP] = rootQ;
		size[rootQ] += size[rootP];	           
	    }
	    else {
		parent[rootQ] = rootP;
		size[rootP] += size[rootQ];
	    }
	    count--;
	}
    }


    static int r,c;
    static char arr[][];
    static boolean isValid(int i,int j)
    {
	if(i<0 || j<0 || i>=r || j>=c || arr[i][j] == '*')
	    return false;
	else
	    return true;
    }
    static int to1D(int i,int j)
    {
	return (i*c)+j;
    }
    static ArrayList<Integer> adj(int i,int j)
    {		
	ArrayList<Integer> adj  = new ArrayList<>();
	if(isValid(i+1, j))
	    adj.add(to1D(i+1,j));
	if(isValid(i-1, j))
	    adj.add(to1D(i-1, j));
	if(isValid(i, j+1))
	    adj.add(to1D(i, j+1));
	if(isValid(i, j-1))
	    adj.add(to1D(i, j-1));
	return adj;
    }

    private static int size(WeightedQuickUnionUF dsu,int p)
    {
	return dsu.size[dsu.find(p)];
    }
    private static void solve(FastScanner s1, FastWriter out){
	r = s1.nextInt();
	c = s1.nextInt();
	arr = new char[r][c];
	for(int i = 0 ;i<r;i++)
	    arr[i] = s1.next().toCharArray();
	WeightedQuickUnionUF dsu = new WeightedQuickUnionUF(r*c);
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		int u = to1D(i,j);
		//System.out.println("i="+i+"j="+j+" adj "+adj(i,j));
		if(arr[i][j] == '.')
		{
		    for(int v : adj(i, j))
			dsu.union(u, v);
		}
	    }
	}
	
	char output[][] = new char[r][c];
	
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		if(arr[i][j] == '.')
		    output[i][j] = '.';
		else
		{
		    ArrayList<Integer> arl = adj(i,j);
		    int len = arl.size();
		    int total = 1;
		    TreeSet<Integer> set = new TreeSet<>(arl); 
		    while(set.size()>0)
		    {
			int p = set.pollFirst();	
			ArrayList<Integer> TBR = new ArrayList<>();
			for(int q:set)
			    if(dsu.connected(p, q))
				TBR.add(q);

			for(int q:TBR)
			    set.remove(q);

			total += size(dsu,p);
		    }
		    output[i][j] = (char)('0' + (total%10));
		}
	    }	    
	}
	
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		out.print(output[i][j]);
	    }
	    out.println();
	}
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
