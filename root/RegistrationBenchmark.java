import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class RegistrationBenchmark {
    static class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
	    this.stream = stream;
	}

	public int read() {
	    if(numChars == -1)
		throw new InputMismatchException();
	    if(curChar >= numChars) {
		curChar = 0;
		try {
		    numChars = stream.read(buf);
		} catch(IOException e) {
		    throw new InputMismatchException();
		}
		if(numChars <= 0)
		    return -1;
	    }
	    return buf[curChar++];
	}

	public int readInt() {
	    int c = read();
	    while(isSpaceChar(c))
		c = read();
	    int sgn = 1;
	    if(c == '-') {
		sgn = -1;
		c = read();
	    }
	    int res = 0;
	    do {
		if(c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = read();
	    } while(!isSpaceChar(c));
	    return res * sgn;
	}

	public String readString() {
	    int c = read();
	    while(isSpaceChar(c))
		c = read();
	    StringBuilder res = new StringBuilder();
	    do {
		if(Character.isValidCodePoint(c))
		    res.appendCodePoint(c);
		c = read();
	    } while(!isSpaceChar(c));
	    return res.toString();
	}

	public boolean isSpaceChar(int c) {
	    if(filter != null)
		return filter.isSpaceChar(c);
	    return isWhitespace(c);
	}

	public static boolean isWhitespace(int c) {
	    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
	    return readString();
	}

	public interface SpaceCharFilter {
	    public boolean isSpaceChar(int ch);

	}

    }

    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) throws IOException {
	    writer.write(String.valueOf(i));
	}
	public void println() throws IOException {
	    writer.write('\n');
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
	InputReader in = new InputReader(System.in);
	//OutputWriter out = new OutputWriter(System.out);
	PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	Task solver = new Task();
	solver.solve(in, out);
	out.close();
    }
    static class Task{
	public void solve(InputReader s1, PrintWriter out)throws IOException{
	    int n=s1.readInt();
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
		    out.println("OK");
		}
		else
		{
		    out.print(str);
		    out.println((temp+1));		    
		    map.put(str, temp+1);
		}
	    }
	}
    }
}

