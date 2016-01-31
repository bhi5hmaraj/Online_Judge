import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.StringTokenizer;

public class RegistrationBenchmark {
    static class FastScanner{
   	public BufferedReader reader;
   	public StringTokenizer st;
   	public FastScanner(InputStream stream){
   	    reader = new BufferedReader(new InputStreamReader(stream),1024);
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
   	    writer = new BufferedWriter(new OutputStreamWriter(stream),1024);
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
    
    public static void main(String []args) throws IOException {
	FastScanner s1 = new FastScanner(System.in);
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	Task solver = new Task();
	solver.solve(s1, out);
	out.close();
    }
    static class Task{
	public void solve(FastScanner s1, PrintWriter out)throws IOException{
	    int n=s1.nextInt();
	    String str;
	    Integer temp;
	    Map<String,Integer> map=new HashMap<String,Integer>();		
	    for(int i=1;i<=n;i++)
	    {
		str=s1.next();
		temp=map.get(str);
		if(temp == null)
		{
		    map.put(str,0);
		    out.print("OK\n");
		}
		else
		{
		    out.print(str);
		    out.print((temp+1));
		    out.println();
		    map.put(str, temp+1);
		}
	    }
	}
    }
}

