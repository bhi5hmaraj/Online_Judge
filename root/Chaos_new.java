import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Chaos_new
{
public static int calsum(int[] arr, int index){
    int temp = arr[index];
    int count = 0 ;
    for(int j=index+1 ; j<arr.length ; j++){
        if(arr[j]<temp){
            count++;
        }
        if(count>2){
            count=-1;
            return -1;
        }
    }
    return count;
}
public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);
    FastWriter out = new FastWriter(System.out);
    int T = in.nextInt();
    for(int a0 = 0; a0 < T; a0++){
        int n = in.nextInt();
        int q[] = new int[n];
        for(int q_i=0; q_i < n; q_i++){
            q[q_i] = in.nextInt();
        }
        int sum = 0;
        int tsum = 0;
        for(int i =0; i<q.length; i++){
            tsum = calsum(q,i);
            if(tsum==-1){
                break;
            }
            else{
                sum+=tsum;
            }
        }
        if(tsum==-1){
            out.println("Too chaotic");
        }
        else{
            out.println(sum);
        }
        // your code goes here
    }
}
/************************ TEMPLATE STARTS HERE ************************/

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

/************************ TEMPLATE ENDS HERE ************************/
}