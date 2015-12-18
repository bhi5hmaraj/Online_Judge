import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

 class Graph
{
	HashMap<Integer,HashSet<Integer>> adj;
	private int V,E;
	private boolean directed;
	private HashSet<Integer> vList;
	public Graph()
	{
		this.adj = new HashMap<>();
		this.V = 0;
		this.E = 0;
		this.directed = false;
		this.vList = new HashSet<>();
	}
	public Graph(boolean directed)
	{
		this();
		this.directed = directed;
	}
	public Iterable<Integer> vertices()
	{
		return vList;
	}
	public Iterable<Integer> adjacent(int v)
	{
		return adj.get(v);
	}
	public void add(int u,int v)
	{
		add(u,v,directed);
	}
	public void add(int u,int v,boolean dir)
	{
		if(u == v)
		{
			adj.put(u, new HashSet<>());
			vList.add(u);
			V++;
			//System.out.println("fuck");
			return;
		}
		if(adj.get(u) == null)
		{
			V++;
			adj.put(u, new HashSet<>()); 
			vList.add(u);
		}
		if(!dir)
		{
			if(adj.get(v) == null)
			{
				adj.put(v, new HashSet<>());  
				vList.add(v);
				V++;
			}					
		}
		if(!(adj.get(u).contains(v) || adj.get(v).contains(u)))
		E++;
		
		adj.get(u).add(v);	
		if(!dir)
			adj.get(v).add(u);	
		System.out.println(this);
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("E = "+E()+"\n");
		sb.append("V = "+V()+"\n");
		for(Integer v:vertices())
		{				
				sb.append(v+"-->"+adjacent(v)+"\n");				
		}
		return sb.toString();
	}

			

	public static void main(String[] args) {		
	Graph g = new Graph();
	g.add(1,2);
	g.add(2,1);
}
}

 /*
	public static void main(String[] args) {		
	Graph g = new Graph(true);
	g.add(0, 1);
	g.add(1, 2);
	g.add(2, 0);
	g.add(4, 4);		
	g.add(5, 4);
	g.add(4, 0);
	System.out.println(g);
}
 */