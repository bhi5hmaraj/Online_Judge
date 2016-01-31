import java.util.*;
import java.io.*;
public class Multipliers
{
    
    /************************ SOLUTION STARTS HERE ************************/
    
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    
    public static <Key> void frequency(Map<Key , java.lang.Long> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Long query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Long(1));
    	else
    	{
    		mp.put(k, query + 1L);
    	}
    }
    static long exponentiation( long a,  long b,  long c) {
         long ans = 1;
        for(int i = 1;i <= b;i++) {
            ans *= a;                             //multiplying a, b times.
            ans %= c;
        }
    return ans;
 }
     
    private static boolean isPerfect(HashMap<Integer,Long> p)
    {
	
	for(Map.Entry<Integer, Integer> e : p.entrySet())
	    if(e.getValue() % 2 != 0)
		return false;
	
	return true;
    }
    
    static long MOD = (long)1e9 + (long)7;
        
    private static void solve(FastScanner s1, FastWriter out){

	int len = s1.nextInt();

	HashMap<Integer , Long> p = new HashMap<>();
	for(int i=1;i<=len;i++)
	    frequency(p, s1.nextInt());
	
	long numOfDiv = 1;
	for(Map.Entry<Integer, Long> e:p.entrySet())
	{	   
	    numOfDiv *= ((e.getValue()+1));
	    numOfDiv %= (MOD - 1);
	}
	if(!isPerfect(p))
	{
	    long k = numOfDiv / 2;
	    
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
