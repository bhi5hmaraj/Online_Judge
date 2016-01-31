import java.util.*;
import java.io.*;
class MonkintheGrassFields
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
    }

    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int N = s1.nextInt();
	    int k = s1.nextInt();
	    int arr[][] = new int[N][N];
	    for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
		    arr[i][j] = s1.nextInt();
	    
	    long rSum[] = new long[N];
	    long cSum[] = new long[N];
	    for(int i=0;i<N;i++)   //Add sum of rows and columns in a PQ
	    {
		int sumR = 0;
		int sumC = 0;
		for(int j=0;j<N;j++)
		{
		    sumR+=arr[i][j];
		    sumC+=arr[j][i];
		}
		rSum[i] = (long)sumR;
		cSum[i] = (long)sumC;
	    }
	    Arrays.sort(rSum);
	    Arrays.sort(cSum);
	    long discomfort = 0;
	    while(k-->0)
	    {
		if(rSum[0] <= cSum[0])
		{
		    discomfort += rSum[0];
		    rSum[0]+=N;
		    Arrays.sort(rSum);
		    for(int i=0;i<N;i++)
			cSum[i]++;
		}
		else
		{
		    discomfort += cSum[0];
		    cSum[0]+=N;
		    Arrays.sort(cSum);
		    for(int i=0;i<N;i++)
			rSum[i]++;
		}
	    }
	    
	    out.println(discomfort);
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
