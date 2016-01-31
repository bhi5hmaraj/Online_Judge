import java.util.*;
import java.io.*;
class ToTakeOrNotToTake
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	//solve1(in, out);
	solve2(in , out);
	in.close();
	out.close();
    }
    private static void solve2(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int n = s1.nextInt();
	    long pos[] = new long[n+1];
	    long neg[] = new long[n+1];
	    pos[0] = 1;
	    neg[0] = 1;
	    for(int i=1;i<=n;i++)
	    {
		String input[] = s1.nextLine().split(" ");
		if(input[0].equals("+"))  //We didn't calculate 
		{
		    long num = Long.parseLong(input[1]);
		    pos[i] = Math.max(pos[i-1], pos[i-1]+num);
		    neg[i] = neg[i-1];
		}
		else if(input[0].equals("-"))
		{
		    long num = Long.parseLong(input[1]);
		    neg[i] = Math.min(neg[i-1], neg[i-1]-num);
		    pos[i] = pos[i-1];
		}
		else if(input[0].equals("*"))
		{
		    long num = Long.parseLong(input[1]);
		    pos[i] = pos[i-1] * num;
		    neg[i] = neg[i-1] * num;
		}    
		else if(input[0].equals("/"))
		{
		    long num = Long.parseLong(input[1]);
		    //pos[i] = Math.max(pos[i-1], pos[i-1]/num);
		    //neg[i] = Math.min(neg[i-1], neg[i-1]/num);
		    pos[i] = pos[i-1];
		    neg[i] = neg[i-1];
		}
		else
		{
		    pos[i] = Math.max(pos[i-1], -neg[i-1]);
		    neg[i] = Math.min(neg[i-1], -pos[i-1]);
		}
	    }
	    out.println(Long.toString(pos[n]));
	}
    }
    private static void solve1(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int n = s1.nextInt();
	    String line[] = new String[n];
	    for(int i=0;i<n;i++)
		line[i] = s1.nextLine();
	    long arr[] = new long[(1<<(n+1))];
	    arr[1] = 1;
	    for(int i=1;i<(arr.length/2);i++)
	    {
		int index = (int)(Math.log(i)/Math.log(2));
		String input[] = line[index].split(" ");
		if(input[0].equals("+"))
		{
		    long num = Long.parseLong(input[1]);
		    arr[2*i] = arr[i] + num;
		    arr[(2*i)+1] = arr[i];
		}
		else if(input[0].equals("-"))
		{
		    long num = Long.parseLong(input[1]);
		    arr[2*i] = arr[i] - num;
		    arr[(2*i)+1] = arr[i];
		}
		else if(input[0].equals("*"))
		{
		    long num = Long.parseLong(input[1]);
		    arr[2*i] = arr[i] * num;
		    arr[(2*i)+1] = arr[i];
		}    
		else if(input[0].equals("/"))
		{
		    long num = Long.parseLong(input[1]);
		    arr[2*i] = arr[i] / num;
		    arr[(2*i)+1] = arr[i];
		}
		else
		{
		    arr[2*i] = -arr[i];
		    arr[(2*i)+1] = arr[i];
		}
	    }
	    long ans = Long.MIN_VALUE;
	    for(int i=arr.length/2;i<arr.length;i++)
		ans = Math.max(ans, arr[i]);
	    
	    out.println(Long.toString(ans));
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
