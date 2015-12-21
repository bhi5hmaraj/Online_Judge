import java.io.*;
import java.util.StringTokenizer;
public class template {
    public static void main(String []args) throws IOException {
	Scanner      in  = new Scanner(System.in);
	OutputWriter out = new OutputWriter(System.out);
	solve(in, out);
	out.close();
	in.close();
    }

    public static void solve(Scanner s1, OutputWriter out){
	
	
	
    }

    static class Scanner{
	public BufferedReader reader;
	public StringTokenizer st;
	public Scanner(InputStream stream){
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
	public void close(){	
	    reader.close();
	}
    }
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o){

	    try{writer.write(o.toString());} catch(IOException e){e.printStackTrace();}
	}
	public void print(String s){

	    try{writer.write(s);} catch(IOException e){e.printStackTrace();}
	}
	public void print(char []c){

	    try{writer.write(c);} catch(IOException e){e.printStackTrace();}
	}
	public void close(){

	    try{writer.close();} catch(IOException e){e.printStackTrace();}
	}
    }
}