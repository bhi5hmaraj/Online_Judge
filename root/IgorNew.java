/*
public class IgorNew {

}

*/
import java.util.*;
import java.io.*;
public class IgorNew
{
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
    public static void main(String args[]) throws FileNotFoundException
    {
        MyScanner2 s1=new MyScanner2();  
	//Scanner s1 = new Scanner(new File("C:\\Users\\bhisR\\OneDrive\\OnlineJudge\\Online_Judge\\IgorTest.txt"));
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
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
        StringBuilder sb = new StringBuilder();
        while(query-->0)
        {
            sb.append(map.get(id[to1D(s1.nextInt()-1, s1.nextInt()-1)]) + "\n");
        }
        //long end = System.nanoTime() - start;
        //out.println("time : "+end/1e6+"ms for "+r+" x "+c);
        //out.println(map);
        out.println(sb);
        //s1.close();
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
        