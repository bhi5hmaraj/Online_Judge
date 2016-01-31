import java.util.*;
import java.io.*;
public class SwapSortSlow
{
    public static void main(String []args){
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void swap(int arr[],int i,int j)
    {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
    }
    private static void solve(FastScanner s1, FastWriter out){

	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	ArrayList<Integer> i_arl = new ArrayList<>();
	ArrayList<Integer> j_arl = new ArrayList<>();
	for(int i=0;i<len-1;i++)
	{
	    int small = Integer.MAX_VALUE;
	    int p_i=-1,p_j=-1;
	    for(int j=i+1;j<len;j++)
	    {
		if(arr[j] < arr[i] && arr[j] < small)
		{
		    small = arr[j];
		    p_i = i;
		    p_j = j;
		}
	    }
	    if(p_i!=-1 && p_j!=-1)
	    {
		swap(arr,p_i,p_j);
		i_arl.add(p_i);
		j_arl.add(p_j);
	    }
	}
	int size = i_arl.size();
	out.print(size);
	out.println();
	for(int i=0;i<size;i++)
	{	      
	    out.print(i_arl.get(i)+" "+j_arl.get(i)+"\n");
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
