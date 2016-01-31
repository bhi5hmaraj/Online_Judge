import java.util.*;
import java.io.*;
public class YaroslavandPermutations
{
    private static void add(Map<Integer,Integer> mp , int key)
    {
	Integer q = mp.get(key);
	if(q == null)
	{
	    mp.put(key, 1);
	}
	else
	{
	    mp.put(key, q+1);
	}
    }
    
    private static void solve(FastScanner s1 , FastWriter out)
    {
	int len = s1.nextInt();
	HashMap<Integer,Integer> freq = new HashMap<>();
	for(int i=1;i<=len;i++)
	    add(freq,s1.nextInt());
	
	PriorityQueue<Integer> pq = new PriorityQueue<>(freq.size() , new Comparator<Integer>(){
	    @Override
	    public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	    }
	});
	for(Map.Entry<Integer, Integer> e : freq.entrySet())
	    pq.add(e.getValue());
	
	while(pq.size() > 0)
	{
	    int e1 = pq.poll();
	    if(e1 == 1)
	    {
		out.print("YES");
		return;
	    }
	    if(pq.size() != 0 )
	    {
		int e2 = pq.poll();
		if(e1 > 1)
		    pq.add(e1-1);
		if(e2 > 1)
		    pq.add(e2-1);
	    }
	    else
	    {
		out.print("NO");
		return;
	    }
	}
	out.print("YES");
    }

    
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
