import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
class bfs
{
	 static class Graph {
	     
	     private final int V;
	     private int E;
	     private ArrayList<Integer>[] adj;

	     public Graph(int V) {
	         if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	         this.V = V;
	         this.E = 0;
	         adj = (ArrayList<Integer>[]) new ArrayList[V];
	         for (int v = 0; v < V; v++) {
	             adj[v] = new ArrayList<Integer>();
	         }
	     }


	     public int V() {
	         return V;
	     }

	     public int E() {
	         return E;
	     }

	     // throw an IndexOutOfBoundsException unless 0 <= v < V
	     private void validateVertex(int v) {
	         if (v < 0 || v >= V)
	             throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
	     }

	     public void addEdge(int v, int w) {
	         E++;
	         adj[v].add(w);
	         adj[w].add(v);
	     }

	     public ArrayList<Integer> adj(int v) {
	         return adj[v];
	     }

	     public int degree(int v) {
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
	 
	 private static int[] distToOther(Graph g,int source)
	 {
	     int dist[] = new int[g.V()];
	     Arrays.fill(dist, -1);
	     dist[source] = 0;
	     Queue<Integer> q = new LinkedList<>();
	     boolean marked[] =new boolean[g.V()];
	     q.add(source);
	     marked[source] = true;
	     while(!q.isEmpty())
	     {
		     int v = q.remove();
		     for(int w:g.adj(v))
		     {
			 if(!marked[w])
			 {
			     q.add(w);
			     marked[w] = true;
			     dist[w] = dist[v]+6;
			 }
		     }		 
	     }
	     return dist;
	 }
	 
	 private static Graph initGraph(int V,int E,MyScanner2 s1)
	 {
	     Graph g = new Graph(V+1);
	     for(int i=1;i<=E;i++)
	     {
		 g.addEdge(s1.nextInt(), s1.nextInt());
	     }
	     return g;
	 }
	  public static void main(String args[])
	    {
	        MyScanner2 s1=new MyScanner2();  
	        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	        StringBuffer sb=new StringBuffer();
	        int t=s1.nextInt();
	        for(int z=1;z<=t;z++)
	        {
	            Graph g = initGraph(s1.nextInt(), s1.nextInt(), s1);
	            int source = s1.nextInt();
	            int dist[] = distToOther(g, source);
	            for(int i=1;i<g.V();i++)
	        	if(i!=source)
	        	    sb.append(dist[i]+" ");
	            sb.append("\n");
	        }
	        out.println(sb);
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
	 
	 