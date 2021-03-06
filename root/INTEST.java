import java.util.*;
import java.io.*;
class INTEST
{
    public static void main(String args[])throws IOException
    {
        //MyScanner s1=new MyScanner();  //Time 0.62s
    	//FasterScanner s1 = new FasterScanner();   //Time 0.2s
        //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
	Scanner s1= new Scanner(System.in);    //0.62s
	OutputWriter out = new OutputWriter(System.out);
        int n=s1.nextInt();
        int ct=0;
        int k=s1.nextInt();
        for(int i=1;i<=n;i++)
        {
        	if(s1.nextInt()%k == 0)
        		ct++;
        }
        out.println(String.valueOf(ct));
        out.close();
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
	    public void println(String s) throws IOException {
		writer.write(s+"\n");
	    }
	    public void print(char []c) throws IOException {
		writer.write(c);
	    }
	    public void close() throws IOException {
		writer.close();
	    }
	}
}

class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
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
}
      
class FasterScanner {
    private byte[] buf = new byte[1024];
    private int tmp_curChar;
    private int tmp_numChars;

    public int read() {
        if (tmp_numChars == -1)
            throw new InputMismatchException();
        if (tmp_curChar >= tmp_numChars) {
            tmp_curChar = 0;
            try {
                tmp_numChars = System.in.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (tmp_numChars <= 0)
                return -1;
        }
        return buf[tmp_curChar++];
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

     public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
       
    public int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }
   
    public long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
