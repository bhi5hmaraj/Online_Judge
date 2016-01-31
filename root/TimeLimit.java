import java.util.*;
import java.io.*;
public class TimeLimit
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	//InputReader in  = new InputReader();
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	//in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out){

	int n = s1.nextInt();
	int m = s1.nextInt();
	int narr[] = s1.nextIntArray(n);
	int marr[] = s1.nextIntArray(m);
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	for(int a:narr)
	    max = Math.max(max, a);
	for(int a:marr)
	    min = Math.min(min, a);
	if(min<=max)
	{
	    out.print("-1");
	    return;
	}
	else
	{
	    for(int i=max ;i<min;i++)
	    {
		for(int j=0;j<n;j++)
		{
		    if((2*narr[j])<=i)
		    {
			out.print(i);
			return;
		    }
		}
	    }
	    out.print("-1");
	    return;
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
	public void print(Object o){
	    print(o.toString());
	}
	public void print(Object o[]){
	    print(Arrays.deepToString(o));
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
