import java.io.*;
import java.util.*;
class  AMLPALIN{
    public static void main(String []args) throws IOException {
	Scanner      in  = new Scanner(System.in);
	OutputWriter out = new OutputWriter(System.out);
	solve(in, out);
	out.close();
	in.close();
    }

    private static void solve(Scanner s1, OutputWriter out){
	int t = s1.nextInt();
	while(t-->0)
	{
	    int n = s1.nextInt();
	    int freq[] = new int[4];
	    for(int i=1;i<=n;i++)
	    {
		String str = s1.next();
		if(str.equals("aa"))
		    freq[0]++;
		else if(str.equals("ab"))
		    freq[1]++;
		else if(str.equals("ba"))
		    freq[2]++;
		else
		    freq[3]++;
	    }
	    int m = Math.min(freq[1], freq[2]);
	    if(m!=0)
	    {
	    for(int i=1;i<=freq[0]/2;i++)
		out.print("aa");	    
	    for(int i=1;i<=m;i++)
		out.print("ab");
	    for(int i=1;i<=freq[3];i++)
		out.print("bb");
	    for(int i=1;i<=m;i++)
		out.print("ba");
	    for(int i=1;i<=freq[0]/2;i++)
		out.print("aa");
	    }
	    else
	    {
		if(freq[0] == 1 && freq[3]==0)
		    out.print("aa");
		else if(freq[0]*2 >= ( ((freq[0]/2)) * 4 + freq[3]*2))
		{
		    for(int i=1;i<=freq[0];i++)
			out.print("aa");
		}
		else
		{
		    for(int i=1;i<=freq[0]/2;i++)
			out.print("aa");
		    for(int i=1;i<=freq[3];i++)
			out.print("bb");
		    for(int i=1;i<=freq[0]/2;i++)
			out.print("aa");
		}
	    }
	    out.println();
	}
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
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(long i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(double i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(boolean i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(char i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o){
	    try{writer.write(o.toString());} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o[]){
	    try{writer.write(Arrays.deepToString(o));} catch(IOException e){e.printStackTrace();}
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
	public void close(){
	    try{writer.close();} catch(IOException e){e.printStackTrace();}
	}
    }
}