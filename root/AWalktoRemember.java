import java.util.*;
import java.io.*;
class AWalkToRemember
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    public static <Key> void frequency(Map<Key , java.lang.Integer> mp , Key k)
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
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int V = s1.nextInt();
	int E = s1.nextInt();
	Digraph g = new Digraph(V+1);
	for(int i=1;i<=E;i++)
	    g.addEdge(s1.nextInt(), s1.nextInt());
	KosarajuSharirSCC KSscc = new KosarajuSharirSCC(g);
	HashMap<Integer,Integer> freq = new HashMap<>();
	int id[] = KSscc.id;
	for(int a:id)
	    frequency(freq, a);
	for(int i=1;i<=V;i++)
	{
	    if(freq.get(id[i]) >= 2)
		out.print("1 ");
	    else
		out.print("0 ");
	}
    }

    static class KosarajuSharirSCC {
	boolean[] marked;     // marked[v] = has vertex v been visited?
	int[] id;             // id[v] = id of strong component containing v
	int count;            // number of strongly-connected components

	/**
	 * Computes the strong components of the digraph <tt>G</tt>.
	 * @param G the digraph
	 */
	public KosarajuSharirSCC(Digraph G) {

	    // compute reverse postorder of reverse graph
	    DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

	    // run DFS on G, using reverse postorder to guide calculation
	    marked = new boolean[G.V()];
	    id = new int[G.V()];
	    ArrayList<Integer> revPost = dfs.post();
	    count = 1;
	    for(int i=revPost.size()-1,v=revPost.get(i);i>=0;i++,v=revPost.get(i))
	    {
		if (!marked[v]) {
		    dfs(G, v);
		    count++;
		}
	    }

	    // check that id[] gives strong components
	    // assert check(G);
	}

	// DFS on graph G
	private void dfs(Digraph G, int v) { 
	    marked[v] = true;
	    id[v] = count;
	    for (int w : G.adj(v)) {
		if (!marked[w]) dfs(G, w);
	    }
	}

	/**
	 * Returns the number of strong components.
	 * @return the number of strong components
	 */
	public int count() {
	    return count;
	}

	/**
	 * Are vertices <tt>v</tt> and <tt>w</tt> in the same strong component?
	 * @param v one vertex
	 * @param w the other vertex
	 * @return <tt>true</tt> if vertices <tt>v</tt> and <tt>w</tt> are in the same
	 *     strong component, and <tt>false</tt> otherwise
	 */
	public boolean stronglyConnected(int v, int w) {
	    return id[v] == id[w];
	}

	/**
	 * Returns the component id of the strong component containing vertex <tt>v</tt>.
	 * @param v the vertex
	 * @return the component id of the strong component containing vertex <tt>v</tt>
	 */
	public int id(int v) {
	    return id[v];
	}

	// does the id[] array contain the strongly connected components?
	/*
	private boolean check(Digraph G) {
	    TransitiveClosure tc = new TransitiveClosure(G);
	    for (int v = 0; v < G.V(); v++) {
		for (int w = 0; w < G.V(); w++) {
		    if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc.reachable(w, v)))
			return false;
		}
	    }
	    return true;
	}
	 */


    }
    static class DepthFirstOrder {
	private boolean[] marked;          // marked[v] = has v been marked in dfs?
	//private int[] pre;                 // pre[v]    = preorder  number of v
	//private int[] post;                // post[v]   = postorder number of v
	//private Queue<Integer> preorder;   // vertices in preorder
	private ArrayList<Integer> postorder;  // vertices in postorder
	//private int preCounter;            // counter or preorder numbering
	//private int postCounter;           // counter for postorder numbering

	/**
	 * Determines a depth-first order for the digraph <tt>G</tt>.
	 * @param G the digraph
	 */
	public DepthFirstOrder(Digraph G) {
	    postorder = new ArrayList<Integer>();
	    marked    = new boolean[G.V()];
	    for (int v = 1; v < G.V(); v++)
		if (!marked[v]) dfs(G, v);
	}

	// run DFS in digraph G from vertex v and compute preorder/postorder
	private void dfs(Digraph G, int v) {
	    marked[v] = true;
	    for (int w : G.adj(v)) {
		if (!marked[w]) {
		    dfs(G, w);
		}
	    }
	    postorder.add(v);
	}


	/**
	 * Returns the vertices in postorder.
	 * @return the vertices in postorder, as an iterable of vertices
	 */
	public ArrayList<Integer> post() {
	    return postorder;
	}

	/**
	 * Returns the vertices in reverse postorder.
	 * @return the vertices in reverse postorder, as an iterable of vertices
	 */
	public Stack<Integer> reversePost() {
	    Stack<Integer> reverse = new Stack<Integer>();
	    //System.out.println("Post order : "+postorder	);
	    //System.out.println("Pre  "+preorder);
	    for (int v : postorder)
		reverse.push(v);
	    //System.out.println("Reverse post : "+reverse);
	    return reverse;
	}



    }
    static class Digraph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;           // number of vertices in this digraph
	private int E;                 // number of edges in this digraph
	private ArrayList<Integer>[] adj;    // adj[v] = adjacency list for vertex v
	private int[] indegree;        // indegree[v] = indegree of vertex v

	/**
	 * Initializes an empty digraph with <em>V</em> vertices.
	 *
	 * @param  V the number of vertices
	 * @throws IllegalArgumentException if V < 0
	 */
	public Digraph(int V) {
	    if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
	    this.V = V;
	    this.E = 0;
	    indegree = new int[V];
	    adj = (ArrayList<Integer>[]) new ArrayList[V];
	    for (int v = 0; v < V; v++) {
		adj[v] = new ArrayList<Integer>();
	    }
	}

	/**  
	 * Initializes a digraph from the specified input stream.
	 * The format is the number of vertices <em>V</em>,
	 * followed by the number of edges <em>E</em>,
	 * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
	 *
	 * @param  in the input stream
	 * @throws IndexOutOfBoundsException if the endpoints of any edge are not in prescribed range
	 * @throws IllegalArgumentException if the number of vertices or edges is negative
	 */

	/**
	 * Initializes a new digraph that is a deep copy of the specified digraph.
	 *
	 * @param  G the digraph to copy
	 */
	public Digraph(Digraph G) {
	    this(G.V());
	    this.E = G.E();
	    for (int v = 0; v < V; v++)
		this.indegree[v] = G.indegree(v);
	    for (int v = 0; v < G.V(); v++) {
		// reverse so that adjacency list is in same order as original
		Stack<Integer> reverse = new Stack<Integer>();
		for (int w : G.adj[v]) {
		    reverse.push(w);
		}
		for (int w : reverse) {
		    adj[v].add(w);
		}
	    }
	}

	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int V() {
	    return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int E() {
	    return E;
	}


	// throw an IndexOutOfBoundsException unless 0 <= v < V
	private void validateVertex(int v) {
	    if (v < 0 || v >= V)
		throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	}

	/**
	 * Adds the directed edge v->w to this digraph.
	 *
	 * @param  v the tail vertex
	 * @param  w the head vertex
	 * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
	 */
	public void addEdge(int v, int w) {
	    //validateVertex(v);
	    //validateVertex(w);
	    adj[v].add(w);
	    indegree[w]++;
	    E++;
	}

	/**
	 * Returns the vertices adjacent from vertex <tt>v</tt> in this digraph.
	 *
	 * @param  v the vertex
	 * @return the vertices adjacent from vertex <tt>v</tt> in this digraph, as an iterable
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Iterable<Integer> adj(int v) {
	    //validateVertex(v);
	    return adj[v];
	}

	/**
	 * Returns the number of directed edges incident from vertex <tt>v</tt>.
	 * This is known as the <em>outdegree</em> of vertex <tt>v</tt>.
	 *
	 * @param  v the vertex
	 * @return the outdegree of vertex <tt>v</tt>               
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public int outdegree(int v) {
	    validateVertex(v);
	    return adj[v].size();
	}

	/**
	 * Returns the number of directed edges incident to vertex <tt>v</tt>.
	 * This is known as the <em>indegree</em> of vertex <tt>v</tt>.
	 *
	 * @param  v the vertex
	 * @return the indegree of vertex <tt>v</tt>               
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public int indegree(int v) {
	    validateVertex(v);
	    return indegree[v];
	}

	/**
	 * Returns the reverse of the digraph.
	 *
	 * @return the reverse of the digraph
	 */
	public Digraph reverse() {
	    Digraph R = new Digraph(V);
	    for (int v = 0; v < V; v++) {
		for (int w : adj(v)) {
		    R.addEdge(w, v);
		}
	    }
	    //System.out.println("reverse\n"+R);
	    return R;
	}

	/**
	 * Returns a string representation of the graph.
	 *
	 * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,  
	 *         followed by the <em>V</em> adjacency lists
	 */
	public String toString() {
	    StringBuilder s = new StringBuilder();
	    s.append(V + " vertices, " + E + " edges " + NEWLINE);
	    for (int v = 0; v < V; v++) {
		s.append(String.format("%d: ", v));
		for (int w : adj[v]) {
		    s.append(String.format("%d ", w));
		}
		s.append(NEWLINE);
	    }
	    return s.toString();
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
