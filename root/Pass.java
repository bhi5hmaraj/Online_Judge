
import java.util.*;
import java.io.*;
public class Pass
{
    public static void main(String args[])throws IOException
    {
	MyScanner2 s1=new MyScanner2();    
	//PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
	OutputWriter out = new OutputWriter(System.out);
	int t;
	t = s1.nextInt();
	long n,m;
	int count = 0;

	Stack<String> stk;            
	while(t-->0)
	{
	    stk = new Stack<>();
	    n = s1.nextLong();
	    count = 0;
	    m = s1.nextLong();
	    while(m>0)
	    {
		if((m&1) != 0){
		    stk.push("("+n+"<<"+count+")"); 
		}
		count++;
		m = m>>1;
	    }
	    int ct=1;
	    int size = stk.size();
	    while(stk.size()!=0)
	    {
		if(ct<size)
		    out.print(stk.pop()+" + ");
		else
		    out.print(stk.pop());
		ct++;
	    }
	    out.print("\n");
	}
	out.close();
    }

    static class MyScanner2 {
	BufferedReader br;
	StringTokenizer st;

	public MyScanner2() {
	    br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
	    while (st == null || !st.hasMoreElements()) {
		try {
		    st = new StringTokenizer(br.readLine());
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    return st.nextToken();
	}

	int nextInt() { return Integer.parseInt(next()); }
	long nextLong() { return Long.parseLong(next()); }
	double nextDouble() { return Double.parseDouble(next()); }

	String nextLine(){
	    String str = "";
	    try {
		str = br.readLine();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    return str;
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

    }
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) throws IOException {
	    writer.write(i);
	}
	public void print(Object o)throws IOException {
	    writer.write(o.toString());
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
}







