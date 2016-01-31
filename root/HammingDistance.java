import java.util.*;
import java.io.*;
public class HammingDistance
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }
    
    static class Pair
    {
	int freq_0,freq_1;
	Pair(int f0,int f1)
	{
	    freq_0 = f0;
	    freq_1 = f1;
	}
    }
    private static void solve(FastScanner s1, FastWriter out)/*This is the actual solution */{
	String pat = s1.next();
	String str = s1.next();	
	int N = pat.length();
	int M = str.length();
	int f0 = 0;
	int f1 = 0;
	for(int i=0;i<=M-N;i++)
	    if(str.charAt(i) == '0')
		f0++;
	    else
		f1++;
	Pair preCal [] = new Pair[N];
	preCal[0] = new Pair(f0, f1);
	for(int i=1;i<N;i++)
	{
	    char first = str.charAt(i-1);
	    char last  = str.charAt(M-N+i);
	    if(first == '0')	    
		f0--;
	    else
		f1--;
	    
	    if(last == '0')
		f0++;
	    else
		f1++;
	    preCal[i] = new Pair(f0, f1);
	}
	long hamDist = 0;
	for(int i=0;i<N;i++)
	    if(pat.charAt(i) == '0')
		hamDist += preCal[i].freq_1;
	    else
		hamDist += preCal[i].freq_0;
	
	out.print(hamDist);
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
