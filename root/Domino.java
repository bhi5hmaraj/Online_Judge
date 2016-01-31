import java.util.*;
import java.io.*;
public class Domino
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{

	int len = s1.nextInt();
	int a[] = new int[len];
	int b[] = new int[len];
	int sumA = 0,sumB =0;
	for(int i=0;i<len;i++)
	{
	    a[i] = s1.nextInt();
	    sumA+=a[i];
	    b[i] = s1.nextInt();
	    sumB+=b[i];
	}
	if(sumA%2==0 && sumB%2==0)
	    out.print("0");
	else if((sumA%2==0 && sumB%2==1)||(sumA%2==1 && sumB%2==0))
	    out.print("-1");
	else if((sumA%2==1 && sumB%2==1))
	{
	    boolean flag = false;
	    for(int i=0;i<len;i++)
	    {
		if((a[i]%2==0&&b[i]%2==1) || (a[i]%2==1&&b[i]%2==0))
		{
		    flag = true;
		    break;
		}
	    }
	    if(flag)
		out.print("1");
	    else
		out.print("-1");
	}
	else
	{
	    boolean flag1 = true;
	    for(int i=0;i<len;i++)
	    {
		int modA = a[i]%2;
		int modB = b[i]%2;
		if(!(modA==0&&modB==0) || (modA==1&&modB==1))
		{
		    flag1 = false;
		    break;
		}
	    }
	    if(flag1)
	    {
		out.print("-1");
		return;
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
