import java.util.*;
import java.io.*;
public class LongestkGoodSegment  /***After all this is the infamous method of two pointers ***/
{
    
    /************************ SOLUTION STARTS HERE ************************/
    
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    
    private static void add(HashMap<Integer,Integer> mp , int key)
    {
	Integer q = mp.get(key);
	if(q == null)
	    mp.put(key, 1);
	else
	    mp.put(key, q+1);
    }
    private static void remove(HashMap<Integer,Integer> mp , int key)
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

	int n = s1.nextInt();
	int k = s1.nextInt();
	int arr[] = s1.nextIntArray(n);
	HashMap<Integer,Integer> freq = new HashMap<>(); 
	int start=0,end=0;
	int big = 0;
	int MAX = 0;
	int s=-1,e=-1;
	while(end < n && freq.size() <= k)
	{
	    add(freq,arr[end]);
	    if(freq.size() > k)
	    {
		remove(freq,arr[end]);
		break;
	    }
	    else
		end++;
	    
	    big++;
	}
	if(end == n)
	    out.print("1 "+n);	
	else
	{
	    for(int i=end;i<n;i++)
	    {
		
		if(freq.containsKey(arr[i]))
		{
		    add(freq,arr[i]);
		    big++;
		    end++;
		    if(big > MAX)
		    {
			e = end;
			s = start + 1;
			MAX = big;
		    }
		}
		else
		{
		    //System.out.println("start = "+start+"end = "+end+" big ="+big);
		    if(big > MAX)
		    {
			e = end;
			s = start + 1;
			MAX = big;
		    }
		    //System.out.println(freq);
		    add(freq,arr[i]);
		    end++;
		    big++;
		    while(freq.size() != k)
		    {
		    remove(freq,arr[start]);
		    big--;
		    start++;
		    }
		}		
	    }
	    out.print(s+" "+e);
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
