import java.io.*;
import java.util.*;
class Minesweeper {
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
    public static void main(String[] args)throws Exception {

	FastScanner s1=new FastScanner(System.in);    
	FastWriter out=new FastWriter(System.out);      //Close the output stream after use  
	r = s1.nextInt();
	c = s1.nextInt();
	int ct=1;
	//StringBuffer sb = new StringBuffer();
	ArrayList<Pair> arl;
	boolean fuck_you_uva = true;
	while(r!=0 && c!=0)
	{
	    //System.out.print("Field #"+ct+":\n");
	    if(fuck_you_uva)
	    {
	    out.print("Field #"+ct+":\n");
	    fuck_you_uva = false;
	    }
	    else
		out.print("\nField #"+ct+":\n");
	    char arr[][] = new char[r][c];
	    for(int i=0;i<r;i++)
	    {
		String line = s1.next();
		for(int j=0;j<c;j++)
		    arr[i][j] = line.charAt(j);
	    }
	    for(int i=0;i<r;i++)
	    {
		for(int j=0;j<c;j++)
		{
		    if(arr[i][j]=='*')
		    {
			//System.out.print('*');
			out.print('*');
			continue;
		    }
		    else
		    {
			arl = validPoints(i, j);
			int adj = 0;
			for(Pair p : arl)
			{
			    if(arr[p.i][p.j] == '*')
				adj++;
			}
			//System.out.print(adj);
			out.print(adj);
		    }
		}
		//System.out.print("\n");
		out.print("\n");
	    }
	    ct++;
	    r = s1.nextInt();
	    c = s1.nextInt();
	}
	//System.out.print(sb.toString().trim());    
	out.close();
	s1.close();
    }
    static class Pair
    {
	int i,j;
	Pair(int i,int j)
	{
	    this.i=i;
	    this.j=j;
	}
	public String toString()
	{
	    return "("+i+", "+j+")";
	}
    }
    static int r,c;
    static boolean isValid(int i,int j)
    {
	if(i>=0 && i<r && j>=0 && j<c)
	    return true;
	else
	    return false;
    }
    static ArrayList<Pair> validPoints(int l,int m)
    {
	//System.out.println("i="+l+"j="+m);
	ArrayList<Pair> arl = new ArrayList<>();
	for(int i=l-1;i<=l+1;i++)
	{
	    for(int j=m-1;j<=m+1;j++)
	    {
		if(!(i==l && j==m))
		{
		    if(isValid(i, j))
		    {
			arl.add(new Pair(i, j));
		    }
		}
	    }
	}
	//System.out.println(arl);
	return arl;
    }

}

