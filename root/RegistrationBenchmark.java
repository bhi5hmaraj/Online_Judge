import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class RegistrationBenchmark {
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
	}
	static class OutputWriter{
	    BufferedWriter writer;
	    public OutputWriter(OutputStream stream){
		writer = new BufferedWriter(new OutputStreamWriter(stream));
	    }
	    public void print(int i) throws IOException {
		writer.write(i);
	    }
	    public void print(String s) throws IOException {
		writer.write(s);
	    }
	    public void print(char []c) throws IOException {
		writer.write(c);
	    }
	    public void close() throws IOException {
		writer.close();
	    }
	}
    public static void main(String []args) throws IOException {
	Scanner in = new Scanner(System.in);
	OutputWriter out = new OutputWriter(System.out);
	Task solver = new Task();
	solver.solve(in, out);
	out.close();
    }
    static class Task{
	    public void solve(Scanner s1, OutputWriter out)throws IOException{
		int n=s1.nextInt();
		String str="";
		Integer temp;
		Map<String,Integer> map=new HashMap<String,Integer>();
		//StringBuffer sb=new StringBuffer();
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
			out.print(str+""+(temp+1)+"\n");
			map.put(str, temp+1);
		    }
		}
		//out.print(sb.toString());
		out.close();
	    }
	}
}

