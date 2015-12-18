import java.util.*;
import java.io.*;



public class IgorIntheMuseum
{
    static int r,c;
    static char chars[][];
    static HashMap<Integer,Integer> mp;
    static class Graph {

	private final int V;
	private int E;
	private Set<Integer>[] adj;

	/**
	 * Initializes an empty graph with <tt>V</tt> vertices and 0 edges.
	 * param V the number of vertices
	 *
	 * @param  V number of vertices
	 * @throws IllegalArgumentException if <tt>V</tt> < 0
	 */
	public Graph(int V) {
	    if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	    this.V = V;
	    this.E = 0;
	    adj = (HashSet<Integer>[]) new HashSet[V];
	    for (int v = 0; v < V; v++) {
		adj[v] = new HashSet<Integer>();
	    }
	}


	/**
	 * Returns the number of vertices in this graph.
	 *
	 * @return the number of vertices in this graph
	 */
	public int V() {
	    return V;
	}

	/**
	 * Returns the number of edges in this graph.
	 *
	 * @return the number of edges in this graph
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
	 * Adds the undirected edge v-w to this graph.
	 *
	 * @param  v one vertex in the edge
	 * @param  w the other vertex in the edge
	 * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
	 */
	public void addEdge(int v, int w) {
	    //validateVertex(v);
	    //validateVertex(w);
	    E++;
	    if(!adj[v].contains(w))
	    {
		adj[v].add(w);
		adj[w].add(v);
	    }
	}


	/**
	 * Returns the vertices adjacent to vertex <tt>v</tt>.
	 *
	 * @param  v the vertex
	 * @return the vertices adjacent to vertex <tt>v</tt>, as an iterable
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Set<Integer> adj(int v) {
	    validateVertex(v);
	    return adj[v];
	}

	/**
	 * Returns the degree of vertex <tt>v</tt>.
	 *
	 * @param  v the vertex
	 * @return the degree of vertex <tt>v</tt>
	 * @throws IndexOutOfBoundsException unless 0 <= v < V
	 */
	public int degree(int v) {
	    validateVertex(v);
	    return adj[v].size();
	}


	/**
	 * Returns a string representation of this graph.
	 *
	 * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
	 *         followed by the <em>V</em> adjacency lists
	 */
	public String toString() {
	    StringBuilder s = new StringBuilder();
	    s.append(V + " vertices, " + E + " edges " + "\n");
	    for (int v = 0; v < V; v++) {
		s.append(v + ": ");
		for (int w : adj[v]) {
		    s.append(w + " ");
		}
		s.append("\n");
	    }
	    return s.toString();
	}
    }



    static class DFS
    {
	boolean [] marked;
	int [] id;
	int numPics[];
	Graph curr;
	private static int ct =0;
	private static int V = 0,E = 0, sumOfDeg = 0;
	DFS(Graph g)
	{
	    marked  =  new boolean[g.V()];
	    id      =  new int[g.V()];
	    numPics =  new int[((int)1e6)+100];
	    curr = g;

	    int V_MAX = g.V();
	    for(int v =0 ;v< V_MAX;v++)
	    {
		if(!marked[v])
		{
		    paths(v);
		    E = sumOfDeg / 2;
		    numPics[ct] = 2*((2*V) - E) ;
		    ct++;
		    V = 0;
		    E = 0;
		    sumOfDeg = 0;
		}
	    }			
	}
	void paths(int u)
	{
	    Queue<Integer> q = new LinkedList<>();
	    q.add(u);
	    int v;
	    while(!q.isEmpty())
	    {			
		//System.out.println(q);
		v = q.remove();
		if(!marked[v])
		{
		    V++;
		    sumOfDeg += curr.degree(v);
		    marked[v]  = true;
		    id[v]  = ct;
		    for(int w:curr.adj(v))
		    {
			if(!marked[w])
			    q.add(w);
		    }
		}
	    }			
	}
    }
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
    static Graph initGraph(int v)
    {
	Graph g = new Graph(v);
	int u;
	for(int i=0;i<r;i++)
	{
	    for(int j=0;j<c;j++)
	    {
		if(chars[i][j] == '.')
		{
		    u = mp.get(to1D(i, j));
		    //g.add(u, u);
		    if(isValid(i,j-1))
			g.addEdge(u, mp.get(to1D(i,j-1)));
		    if(isValid(i-1,j))
			g.addEdge(u, mp.get(to1D(i-1,j)));
		    if(isValid(i,j+1))
			g.addEdge(u, mp.get(to1D(i,j+1)));
		    if(isValid(i+1, j))
			g.addEdge(u, mp.get(to1D(i+1, j)));
		}
	    }
	}
	return g;
    }

    public static void main(String args[])throws Exception
    {
	//MyScanner2 s1=new MyScanner2();   
	Scanner s1 = new Scanner(new File("C:\\Users\\bhisR\\OneDrive\\OnlineJudge\\Online_Judge\\IgorTest.txt"));
	PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use 
	StringBuffer sb = new StringBuffer();
	r = s1.nextInt();
	c = s1.nextInt();
	//int query = s1.nextInt();
	chars = new char[r][c];
	mp = new HashMap<>();
	int v =0;
	for(int i=0;i<r;i++)
	{
	    String line = s1.next();
	    for(int j=0;j<c;j++)
	    {
		chars[i][j] = line.charAt(j);
		if(chars[i][j] == '.')
		    mp.put(to1D(i, j), mp.size());
	    }
	}
	long start = System.nanoTime();
	Graph g = initGraph(mp.size());
	//out.println(g);
	DFS solver = new DFS(g);
	long end = System.nanoTime() - start;
	out.println("time : "+end/1e6+" ms for "+r+" x "+c);
	/*for(int t = 1; t<=query ;t++)        
	    sb.append(solver.numPics[(solver.id[(mp.get(to1D(s1.nextInt()-1,s1.nextInt()-1)))])] + "\n"); 

	out.println(sb);*/
	for(int a:solver.numPics)
	    if(a!=0)
	    out.println(a+" ");
	s1.close();
	//out.println(Arrays.toString(solver.numPics));
	out.close();
    }
    static class MyScanner2 {
	BufferedReader br;
	StringTokenizer st;

	public MyScanner2() {
	    br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
	    while (st == null || !st.hasMoreElements()) {
		try {
		    st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    return st.nextToken();
	}

	int nextInt() { return Integer.parseInt(next()); }
	long nextLong() { return Long.parseLong(next()); }
	double nextDouble() { return Double.parseDouble(next()); }

	String nextLine(){
	    String str = "";
	    try {
		str = br.readLine();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    return str;
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

    }
}    