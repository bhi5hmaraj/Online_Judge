import java.util.*;
import java.io.*;
class Zeroes
{
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    static int bigPrime[];
    static int N;
    private static void preCalBigPrimeSieve()
    {
	bigPrime[1] = 1;
	for(int i = 2;i<=N;i++)
	{
	    if(bigPrime[i] == 0)
	    {
		bigPrime[i] = i;
		for(int j = 2*i;j<=N;j += i)
		    bigPrime[j] = i;
	    }
	}
    }
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
	N = (int)1e5;
	bigPrime = new int[N+10];
	preCalBigPrimeSieve();
	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	HashMap<Integer,Integer> freq = new HashMap<>();
	for(int i=0;i<len;i++)
	{
	    while(arr[i] != 1)
	    {
		int prime = bigPrime[arr[i]];
		while(arr[i] % prime == 0)
		{
		    arr[i] /= prime;
		    frequency(freq, prime);
		}
	    }	    
	}
	
	int q = s1.nextInt();
	while(q-->0)
	{
	    HashMap<Integer , Integer> mp = new HashMap<>();
	    int num = s1.nextInt();
	    while(num != 1)
	    {
		int prime = bigPrime[num];
		while(num % prime == 0)
		{
		    num /= prime;
		    frequency(mp, prime);
		}
	    }
	    int ct = Integer.MAX_VALUE;
	    for(Map.Entry<Integer, Integer> e : mp.entrySet())
	    {
		if(freq.get(e.getKey()) == null)
		{
		    ct = 0;
		    break;
		}
		else
		{
		    int in_arr = freq.get(e.getKey());
		    int in_num = e.getValue();
		    ct = Math.min(ct, (in_arr/in_num));
		}
	    }
	    out.println(ct);
	}
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
