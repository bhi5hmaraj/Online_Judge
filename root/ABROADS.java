import java.util.*;
import java.io.*;
class ABROADS
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    static class WeightedCustomQuickUnionUF {
	    private int[] parent;   // parent[i] = parent of i
	    private int[] size;     // size[i] = number of sites in subtree rooted at i
	    private int count;      // number of components
	    long[] parentPop;
	    public WeightedCustomQuickUnionUF(int N,int[] pop) {
	        count = N;
	        parent = new int[N];
	        size = new int[N];
	        parentPop = new long[N];
	        for(int i=1;i<pop.length;i++)
	            parentPop[i] = pop[i];
	        for (int i = 0; i < N; i++) {
	            parent[i] = i;
	            size[i] = 1;
	        }
	    }
	    public int count() {
	        return count;
	    }
	    public int find(int p) {
	        //validate(p);
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
	            parentPop[rootQ] += parentPop[rootP];
	            
	        }
	        else {
	            parent[rootQ] = rootP;
	            size[rootP] += size[rootQ];
	            parentPop[rootP] += parentPop[rootQ];
	        }
	        count--;
	    }
    }

    
    
    static class Graph {
	private final int V;
	private int E;
	private Set<Integer>[] adj;
	public Graph(int V) {
	    if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	    this.V = V;
	    this.E = 0;
	    adj = (HashSet<Integer>[]) new HashSet[V];
	    for (int v = 0; v < V; v++) {
		adj[v] = new HashSet<Integer>();
	    }	    
	}
	
	public int V() {
	    return V;
	}
	public int E() {
	    return E;
	}
	public void addEdge(int v, int w) {
	    //validateVertex(v);
	    //validateVertex(w);
	    E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	public void removeEdge(int v,int w)
	{
	    E--;
	    adj[v].remove(w);
	    adj[w].remove(v);
	}
	
	public Set<Integer> adj(int v) {
	    //validateVertex(v);
	    return adj[v];
	}


	public int degree(int v) {
	    //validateVertex(v);
	    return adj[v].size();
	}


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
    
    static class BFS
    {
	boolean [] marked;
	int [] id;
	Graph curr;
	void init(Graph g)
	{
	    marked  =  new boolean[g.V()];
	    id      =  new int[g.V()];
	    curr = g;
	    //System.out.println("Graph inside bfs"+curr);
	    int V_MAX = g.V();
	    int uid= 1;
	    for(int v =1 ;v< V_MAX;v++)
	    {
		if(!marked[v])
		{
		    paths(v,uid++);
		}
	    }	
	}
	void paths(int u,int uid)
	{
	    Queue<Integer> q = new LinkedList<Integer>();
	    q.add(u);
	    int v;
	    marked[u] = true;
	    id[u] = uid;
	    while(!q.isEmpty())
	    {
		v = q.remove();
		for(int w:curr.adj(v))
		{
		    if(!marked[w])
		    {
			marked[w] = true;
			id[w] = uid;
			q.add(w);
		    }
		}
	    }
	}
	public String toString()
	{
	    return "ID array: "+Arrays.toString(id);
	}
    }
    private static int findMaxPop(BFS bfs,int[] pop)
    {
	HashMap<Integer,Integer> regionPop = new HashMap<>();
	int V = pop.length;
	for(int i=1;i<V;i++)
	{
	    Integer q = regionPop.get(bfs.id[i]);
	    if(q == null)
		regionPop.put(bfs.id[i], pop[i]);
	    else
		regionPop.put(bfs.id[i], q+pop[i]);
	}
	int max_pop = Integer.MIN_VALUE;
	for(Map.Entry<Integer, Integer> e:regionPop.entrySet())
	    if(e.getValue() > max_pop)
		max_pop = e.getValue();
	
	return max_pop;
    }    
    private static void add(TreeMap<Long ,Integer> mp, long key)
    {
	Integer q = mp.get(key);
	//System.out.println("incomming key"+key);
	if(q  == null)
	    mp.put(key, 1);
	else
	    mp.put(key, q+1);
    }
    private static void remove(TreeMap<Long,Integer> mp,long key)
    {
	Integer q = mp.get(key);
	if(q != null)
	{
	if(q == 1)
	    mp.remove(key);
	else
	    mp.put(key, q-1);
	}
    }
    private static void solve(FastScanner s1, FastWriter out){
	int V = s1.nextInt();
	int E = s1.nextInt();
	int Q = s1.nextInt();
	final int task1 = (int)1e0;
	int population[] = new int[V+1];
	int e1[] = new int[E+1];
	int e2[] = new int[E+1];
	Stack<Integer>[] popStack = (Stack<Integer>[])new Stack[V+1];
	for(int i=1;i<=V;i++)
	{
	    int item = s1.nextInt();
	    population[i] = item;
	    popStack[i] = new Stack<>();
	    popStack[i].push(item);
	}
	for(int i=1;i<=E;i++)
	{
	    e1[i] = s1.nextInt();
	    e2[i] = s1.nextInt();
	    
	}
	if(V<=task1 && E<=task1 && Q<=task1) //BFS soln works for only small number of inputs
	{
	Graph g = new Graph(V+1);
	//out.println(g.toString());
	for(int i=1;i<=E;i++)
	    g.addEdge(e1[i],e2[i]);
	BFS bfs = new BFS();
	bfs.init(g);
	int max_pop = findMaxPop(bfs, population);
	while(Q-->0)
	{	    
	    String str = s1.next();
	    if(str.charAt(0) == 'P')
	    {
		int index = s1.nextInt();
		int pop = s1.nextInt();
		population[index] = pop;
		max_pop = findMaxPop(bfs, population);
		out.println(max_pop);
	    }
	    else
	    {
		int edge = s1.nextInt();
		g.removeEdge(e1[edge], e2[edge]);
		//out.println(g.toString());
		bfs.init(g);
		if(bfs.id[e1[edge]] == bfs.id[e2[edge]])
		    out.println(max_pop);
		else
		{
		    max_pop = findMaxPop(bfs, population);
		    out.println(max_pop);
		}
	    }
	    //out.println(bfs.toString());
	}
	}
	else
	{
	    WeightedCustomQuickUnionUF dsu = new WeightedCustomQuickUnionUF(V+1, population);
	    TreeMap<Long,Integer> populations = new TreeMap<>();
	    String query[] = new String[Q];
	    boolean deleted[] = new boolean[E+1];
	    long output[] = new long[Q];
	    for(int i=Q-1;i>=0;i--)
	    {
		query[i] = s1.nextLine();
		String line[] = query[i].split(" ");
		//System.out.println(Arrays.deepToString(line));
		if(query[i].charAt(0) == 'D')
		{
		    deleted[Integer.parseInt(line[1])] = true;
		}
		else
		{
		    int city = Integer.parseInt(line[1]);
		    int pop =  Integer.parseInt(line[2]);
		    dsu.parentPop[city] = pop;
		    popStack[city].push(pop);
		    population[city] = pop;
		}
	    }
	    for(Stack<Integer> stk:popStack)
		if(stk != null)
		    stk.pop();
	    //System.out.println(Arrays.deepToString(popStack));
	    for(int i=1;i<=E;i++)
	    {
		if(!deleted[i])
		    dsu.union(e1[i], e2[i]);
	    }
	    HashSet<Integer> fucker = new HashSet<>();
	    for(int i =1;i<=V;i++)
	    {
		int parent = dsu.find(i);
		if(!fucker.contains(parent))
		{
		    add(populations,dsu.parentPop[parent]);
		    fucker.add(parent);
		}
	    }
	    //System.out.println("tree"+populations);
	    long max_pop = -1;
	    int t = Q;
	    for(String q:query)
	    {		
		//System.out.println(q);
		//System.out.println(populations);
		if(q.charAt(0) == 'D')
		{
		    max_pop = populations.lastKey();
		    output[--t] = max_pop;
		    //out.println(max_pop);
		    int e = Integer.parseInt((q.split(" "))[1]);
		    int root1 = dsu.find(e1[e]);
		    int root2 = dsu.find(e2[e]);
		    //System.out.println("parent pop inside del"+Arrays.toString(dsu.parentPop));
		    remove(populations,dsu.parentPop[root1]);
		    remove(populations,dsu.parentPop[root2]);
		    dsu.union(e1[e], e2[e]);
		    int root3 = dsu.find(e1[e]);
		    add(populations,dsu.parentPop[root3]);
		}
		else
		{
		    max_pop = populations.lastKey();
		    output[--t] = max_pop;
		    //out.println(max_pop);
		    String line[] = q.split(" ");
		    int city = Integer.parseInt(line[1]);
		    int pop =  popStack[city].pop();
		    int root = dsu.find(city);
		    //System.out.println("parent pop"+Arrays.toString(dsu.parentPop));
		    populations.remove(dsu.parentPop[root]);
		    //System.out.println("population"+Arrays.toString(population));
		    dsu.parentPop[root] -=(population[city]); 
		    population[city] = pop;
		    dsu.parentPop[root] += pop;
		    add(populations,dsu.parentPop[root]);
		    //System.out.println("After pop change"+populations);
		    //System.out.println(Arrays.deepToString(popStack));
		}
	    }
	    for(long a:output)
		out.println(a);
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
