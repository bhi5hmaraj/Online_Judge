import java.util.*;
import java.io.*;
public class uva11221
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    private static String cleanStr(String str)
    {
	int len = str.length();
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<len;i++)
	{
	    if(Character.isAlphabetic(str.charAt(i)))
		sb.append(str.charAt(i));
	}
	return sb.toString();
    }
    private static boolean isSquarePalin(char arr[][],int K)
    {
	for(int i=0;i<K;i++)
	{
	    for(int j=0;j<K;j++)
	    {
		char c1 = arr[i][j];
		char c2 = arr[j][i];
		char c3 = arr[K-i-1][K-j-1];
		char c4 = arr[K-j-1][K-i-1];
		//System.out.println("c1="+c1+" c2="+c2+" c3="+c3+" c4="+c4);
		if(!(c1==c2&&c1==c3&&c1==c4))
		    return false;
	    }
	}
	return true;
    }
    private static void solve(FastScanner s1, FastWriter out){

	int c = 0;
	int t = s1.nextInt();
	while(c++<t)
	{
	    String in = cleanStr(s1.nextLine());
	    //System.out.println(in.length());
	    int len = in.length();
	    double root = Math.sqrt((double)len);
	    if(root == Math.floor(root))
	    {
		int K = (int)root;
		char arr[][] = new char[K][K];
		int itr = 0;
		for(int i=0;i<K;i++)
		{
		    for(int j=0;j<K;j++)
		    {
			arr[i][j] = in.charAt(itr++);
			//System.out.print(arr[i][j]+" ");
		    }
		    //System.out.println();
		}
			
		if(isSquarePalin(arr, K))
		{
		    out.println("Case #"+c+":");
		    out.println(K);
		}
		else
		{
		    out.println("Case #"+c+":");
		    out.println("No magic :(");
		}
	    }
	    else
	    {
		out.println("Case #"+c+":");
		out.println("No magic :(");
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
