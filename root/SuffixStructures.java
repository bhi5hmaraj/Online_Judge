import java.util.*;
import java.io.*;
public class SuffixStructures
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }
    
    public static HashMap<Character,Integer> freqOfChar(String str)
    {
	HashMap<Character,Integer> mp = new HashMap<>();
	for(int i=0,len=str.length();i<len;i++)
	{
	    char k = str.charAt(i);
	    	Integer query = mp.get(k);
	    	if(query == null)
	    		mp.put(k, new Integer(1));
	    	else
	    	{
	    		mp.put(k, query + 1);
	    	}
	}
	return mp;
    }
    private static boolean checkAutomaton(String s,String t)
    {
	int prev = s.indexOf(t.charAt(0));
	int len = t.length();
	for(int i=1;i<len;i++)
	{
	    int curr = s.indexOf(t.charAt(i), prev+1);
	    if(curr<0)
		return false;
	    else
		prev = curr;
	}
	return true;
    }
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	String s = s1.next();
	String t = s1.next();
	HashMap<Character,Integer> mpS = freqOfChar(s);
	HashMap<Character,Integer> mpT = freqOfChar(t);
	//out.println(mpS.toString());
	//out.println(mpT.toString());
	if(mpS.size() == mpT.size())
	{
	    boolean flag = true;
	    for(Map.Entry<Character, Integer> e : mpS.entrySet())
	    {
		if(!e.getValue().equals(mpT.get(e.getKey())) )
		{
		    flag = false;
		    break;
		}
	    }
	    if(flag)
	    {
		out.println("array");
		return;
	    }
	}
	
	boolean flag = true;
	for(Map.Entry<Character, Integer> e: mpT.entrySet())
	{
	    if(mpS.get(e.getKey())== null || e.getValue()>mpS.get(e.getKey()))
	    {
		flag = false;
		break;
	    }
	}
	if(flag)
	{
	    if(checkAutomaton(s,t))
		out.print("automaton");
	    else
		out.print("both");
	    return;
	}
	
	out.print("need tree");
	
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
