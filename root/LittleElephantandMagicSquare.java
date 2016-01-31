import java.util.*;
import java.io.*;
public class LittleElephantandMagicSquare  /* This is a direct brute force approach */
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	
	int mat[][] = new int[3][3];
	for(int i=0;i<3;i++)
	    for(int j=0;j<3;j++)
		mat[i][j] = s1.nextInt();
	
	int r1=0,x1=0,x2=0;
	int c1=0,c2=0,c3=0;
	int d1=0,d2=0;
	int i = 0;
	for( i=1;i<=(int)1e5;i++)
	{
	    r1 = i + mat[0][1] + mat[0][2];
	    c1 = i + mat[1][0] + mat[2][0];
	    if(r1 == c1)
	    {

		x1 = r1 -(mat[1][0]+mat[1][2]);
		c2 = x1 + mat[0][1] + mat[2][1];
		if(c2 == c1)
		{
		    x2 = r1 - (mat[2][0]+mat[2][1]);
		    c3 = x2 + mat[0][2] + mat[1][2];	

		    if(c3 == c1)
		    {
			d1 = i + x1 + x2;
			d2 = mat[0][2] + x1 + mat[2][0];
			if(d1 == d2)
			    break;
		    }
		}
	    }
	}
	mat[0][0] = i;
	mat[1][1] = x1;
	mat[2][2] = x2;
	for(int p=0;p<3;p++)
	{
	    for(int q = 0;q<3;q++)
	    {
		out.print(mat[p][q]);
		out.print(' ');
	    }
	    out.println();
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
	public void println(int i) {
	    print(Integer.toString(i));
	    print('\n');
	}
	public void print(long i) {
	    print(Long.toString(i));
	}
	public void println(long i) {
	    print(Long.toString(i));
	    print('\n');
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
}
