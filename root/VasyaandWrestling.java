import java.util.*;
import java.io.*;
public class VasyaandWrestling
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB

    private static void solve(FastScanner s1, FastWriter out){

	int n = s1.nextInt();
	ArrayList<Integer> first = new ArrayList<>();
	ArrayList<Integer> sec = new ArrayList<>();
	int last = Integer.MAX_VALUE;
	long sum_f=0,sum_s=0;
	while(n-->0)
	{
	    int num = s1.nextInt();
	    if(n==0)
		last = num;

	    if(num > 0)
	    {
		first.add(num);
		sum_f += (long)num;
	    }
	    else
	    {
		sec.add(-num);
		sum_s += (long)(-num);
	    }
	}

	if(sum_f > sum_s)
	{
	    out.print("first");
	    return;
	}
	else if(sum_f<sum_s)
	{
	    out.print("second");
	    return;
	}
	else
	{
	    for(int i=0,len=Math.min(first.size(),sec.size());i<len;i++)
	    {
		if(first.get(i) > sec.get(i))
		{
		    out.print("first");
		    return;
		}
		if(sec.get(i) > first.get(i))
		{
		    out.print("second");
		    return;
		}
	    }
	}
	/*
	if(first.size() > sec.size())
	{
	    out.print("first");
	    return;
	}
	 if(first.size() < sec.size())
	 {
	    out.print("second");
	    return;
	 }
	 */

	if(last > 0)
	    out.print("first");
	else
	    out.print("second");
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