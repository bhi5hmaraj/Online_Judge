import java.util.*;
import java.io.*;
public class GenaCode
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB

    private static int isBeautiful(String str)
    {
	int ct=0;
	if(str.equals("1"))
	    return 0;
	else
	{
	    if(str.charAt(0) != '1')
		return -1;
	    for(int i=1,len=str.length();i<len;i++)
	    {
		if(str.charAt(i) != '0')
		    return -1;
		else
		    ct++;
	    }

	}
	return ct;
    }

    private static void solve(FastScanner s1, FastWriter out){

	int len = s1.nextInt();
	String arr[] = new String[len];
	boolean flag = false;
	for(int i=0;i<len;i++)
	{
	    arr[i] = s1.next();
	    if(arr[i].equals("0"))
		flag = true;
	}
	if(flag)
	    out.print("0");
	else
	{
	    int pow = 0;
	    StringBuffer sb = null;
	    for(int i=0;i<len;i++)
	    {
		int beautiful = isBeautiful(arr[i]);

		if(beautiful >= 0)
		    pow += beautiful;
		else
		{
		    sb = new StringBuffer(arr[i]);
		    int sLen = arr[i].length(),j = sLen-1;
		    int ct = 0;
		    while(j>=0 && arr[i].charAt(j) == '0')
		    {
			sb.deleteCharAt(j);
			j--;
			ct++;
		    }
		    //System.out.println(sb);
		    pow += ct;
		}
	    }
	    if(sb == null)
	    {
		out.print("1");
		for(int i=1;i<=pow;i++)
		    out.print("0");
	    }
	    else
	    {
		out.print(sb.toString());
		for(int i=1;i<=pow;i++)
		    out.print("0");
	    }
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
