import java.util.*;
import java.io.*;
public class GigaTower
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	//solve1(in, out);
	solve2(in,out);
	in.close();
	out.close();
    }
    private static boolean isLucky(long n)
    {
	n = Math.abs(n);
	while(n>0)
	{
	    if(n%10 == 8)
		return true;
	    
	    n /= 10;
	}
	return false;
    }
    private static void solve2(FastScanner s1, FastWriter out)
    {
	long start = s1.nextLong();
	int ct = 1;
	start++;
	while(!isLucky(start++))
	    ct++;
	
	out.print(ct);
    }
    private static void solve1(FastScanner s1, FastWriter out)/* This is the actual solution */{
	
	long n = s1.nextLong();
	if(n>=0)
	{
	    
	if(n%10 == 8)
	{
	    long rest = n/10;
	    if(isLucky(rest))
	    {
		out.print("1");
		return;
	    }
	}
	    
	if((n%10) < 8)
	{
	    long rest = n/10;
	    if(isLucky(rest))
		out.print("1");
	    else
		out.print(8-(n%10));
	}
	else
	{
	    long rest = (n/10) + 1;
	    long new_n;
	    if(isLucky(rest))
		new_n = (rest*10);
	    else
		new_n = (rest*10)+8;
	    
	    out.print((new_n-n));
	}
	}
	else
	{
	    n = -n;
	    if(n<=8)
	    {
		out.print(n+8);
	    }
	    else if(n%10 == 9)
		out.print("1");
	    else
	    {
		long rest = n/10;
		if(isLucky(rest) && (n%10 != 0))
		    out.print("1");
		else
		{
		    rest = (n/10) - 1;
		    if(isLucky(rest))
			out.print((n%10)+1);
		    else
		    {
			out.print((n%10)+2);  //(10+MOD)-8
 		    }
		}
	    }
	}
	
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
