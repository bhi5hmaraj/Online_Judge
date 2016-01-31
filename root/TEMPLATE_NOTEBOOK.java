import java.io.*;
import java.util.*;
class  TEMPLATE_NOTEBOOK{
    public static void main(String []args) throws IOException {
<<<<<<< HEAD
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
=======
	FastScanner      in  = new FastScanner(System.in);
	OutputWriter     out = new OutputWriter(System.out);   //try to enclose Bufferedwriter inside printwriter and benchmark its performance
>>>>>>> ff407d7a2c63c6e6d9b771bc442ddf5368c19301
	solve(in, out);
	in.close();
	out.close();
    }

<<<<<<< HEAD
    private static void solve(FasScanner s1, FastWriter out){
=======
    private static void solve(FastScanner s1, OutputWriter out){
>>>>>>> ff407d7a2c63c6e6d9b771bc442ddf5368c19301
	
	
	
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
<<<<<<< HEAD
    static class FastWriter{
=======
    /*
    static class OutputWriter{
>>>>>>> ff407d7a2c63c6e6d9b771bc442ddf5368c19301
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
	    try{writer.newLine();} catch(IOException e){e.printStackTrace();}
	}
	public void print(char []c){
	    try{writer.write(c);} catch(IOException e){e.printStackTrace();}
	}
	public void close(){
	    try{writer.close();} catch(IOException e){e.printStackTrace();}
	}
    }
    
    dbskvbkdsjbv dsjkvbkjv
    */
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
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
	public void print(Object o){
	    print(o.toString());
	}
	public void print(Object o[]){
	    print(Arrays.deepToString(o));
	}
	public void print(char i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(String s){
	    try{writer.write(s);} catch(IOException e){e.printStackTrace();}
	}
	public void println(){
	    try{writer.newLine();} catch(IOException e){e.printStackTrace();}
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