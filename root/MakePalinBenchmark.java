import java.io.*;
import java.util.*;
public class MakePalinBenchmark {
    public static void main(String []args) throws IOException {
	Scanner      in  = new Scanner(System.in);
	OutputWriter out = new OutputWriter(System.out);
	solve(in, out);
	out.close();
	in.close();
    }
    public static <Key> TreeMap<Key , java.lang.Integer> frequency(TreeMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    	return mp;
    }
    static TreeMap<Character,Integer> freq;
    static boolean canPalin(String str)
    {
	freq = new TreeMap<>();
	int len = str.length();
	for(int i=0;i<len;i++)
	    frequency(freq, str.charAt(i));
	if(len % 2 ==0)
	{
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
		if(e.getValue()%2 == 1)
		    return false;
	    
	    return true;
	}
	else
	{
	    int ct = 0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		if(e.getValue()%2==1)
		    ct++;
		if(ct>1)
		    return false;
	    }
	    return true;
	}
    }

    private static void solve(Scanner s1, OutputWriter out){
	
	String str = s1.next();
	if(!canPalin(str))
	{
	    ArrayList<Character> arl = new ArrayList<>();
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
		if(e.getValue()%2==1)
		    arl.add(e.getKey());
	    int len = arl.size();
	    for(int i=0;i<(len/2);i++)
	    {
		int first = freq.get(arl.get(i));
		int sec = freq.get(arl.get(len-i-1));
		first++;
		sec--;
		freq.put(arl.get(i), first);
		freq.put(arl.get(len-i-1), sec);
	    }		
	}
	int length =str.length();
	StringBuffer palin = new StringBuffer();
	palin.setLength(length);
	//out.println(palin.length());
	if(str.length()%2==0)
	{
	    int  curr =0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		int f = e.getValue();
		if(f!=0)
		{
		    for(int i=1;i<=(f/2);i++)
		    {
			palin.setCharAt(curr+i-1, e.getKey());
			palin.setCharAt(length-curr-i, e.getKey());			
		    }
		    curr += (f/2);
		}
	    }
	}
	else
	{
	    int  curr =0;
	    for(Map.Entry<Character,Integer> e:freq.entrySet())
	    {
		int f = e.getValue();
		if(f!=0)
		{
		    if(f%2==0)
		    {
		    for(int i=1;i<=(f/2);i++)
		    {
			palin.setCharAt(curr+i-1, e.getKey());
			palin.setCharAt(length-curr-i, e.getKey());			
		    }
		    curr += (f/2);
		    }
		    else
		    {
			palin.setCharAt(length/2, e.getKey());
			f = f-1;
			if(f>0)
			{
			    for(int i=1;i<=(f/2);i++)
			    {
				palin.setCharAt(curr+i-1, e.getKey());
				palin.setCharAt(length-curr-i, e.getKey());			
			    }
			    curr += (f/2);
			}
		    }
		}
	    }
	}
	//out.println(freq);
	out.print(palin);
	
    }

    static class Scanner{
	public BufferedReader reader;
	public StringTokenizer st;
	public Scanner(InputStream stream){
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
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(long i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(double i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(boolean i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(char i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o){
	    try{writer.write(o.toString());} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o[]){
	    try{writer.write(Arrays.deepToString(o));} catch(IOException e){e.printStackTrace();}
	}
	public void print(String s){
	    try{writer.write(s);} catch(IOException e){e.printStackTrace();}
	}
	public void println(){
	    try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
	}
	public void print(char []c){
	    try{writer.write(c);} catch(IOException e){e.printStackTrace();}
	}
	public void close(){
	    try{writer.close();} catch(IOException e){e.printStackTrace();}
	}
    }
}