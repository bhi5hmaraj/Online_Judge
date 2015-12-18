import java.util.*;
import java.io.*;
class MSTEP
{
	public static ArrayList<Integer> adj[];
	public static int arr[][];
	public static int V;	
	
	public static void insert_edge(int u,int v)
	{
		try
		{
		adj[u].add(v);
		adj[v].add(u);
		}
		catch(Exception e)
		{
			System.out.println("u="+u+" v= "+v);
			System.exit(1);
		}
	}
	
	public static int bfs(int start,int end)
	{
		int ct=0;
		Queue<Integer> q=new LinkedList<Integer>();
		boolean marked[]=new boolean[V+1];
		int parent[]=new int[V+1];
		boolean flag=true;
		int e=end;
		q.add(start);
		while(flag)
		{
			int u=q.remove();
			marked[u]=true;
			for(int v:adj[u])
			{				
				if(!marked[v])
				{
					parent[v]=u;
					if(v==end)
					{
						flag=false;
						break;
					}
					q.add(v);
				}
			}
		}
		while(e!=start)
		{
			ct++;
			e=parent[e];
		}
		return ct;
				
	}
	
	public static void printGraph()
	{
		for(int i=1;i<=V;i++)
		{
			System.out.print(i+"--> ");
			for(int edge:adj[i])
				System.out.print(edge+" ");
			System.out.println();
		}
	}
	
	public static void main(String args[])
    {
        MyScanner s1=new MyScanner();        
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	V=len*len;
        	adj=new ArrayList[V+1];
        	arr=new int[len][len];
        	int ct=1;
        	for(int i=0;i<len;i++)
        		for(int j=0;j<len;j++)
        		{
        			arr[i][j]=s1.nextInt();
        			adj[ct]=new ArrayList<Integer>();
        			ct++;
        		}
        	
        	for(int i=0;i<len;i++)
        	{
        		for(int j=0;j<len;j++)
        		{
        			if((i+1)<len && (j+1)<len)
        			{
        				insert_edge(arr[i][j], arr[i][j+1]);
        				insert_edge(arr[i][j], arr[i+1][j]);
        			}
        			else if((i+1)>=len && (j+1)>=len)
        			{
        				continue;
        			}
        			else if(i+1>=len)
        			{
        				insert_edge(arr[i][j], arr[i][j+1]);
        			}
        			else
        			{
        				insert_edge(arr[i][j], arr[i+1][j]);
        			}
        		}
        	}
        	//printGraph();
        	int steps=0;
        	for(int start=1;start<V;start++)
        	{
        		steps+=bfs(start,start+1);
        	}
        	System.out.println(steps);
        	adj=null;
        	arr=null;
        	//printGraph();       				
        }
    }
}
        
        
        
        
       
class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
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
}
        