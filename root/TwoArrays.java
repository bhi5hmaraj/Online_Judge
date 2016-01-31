import java.util.*;
import java.io.*;
public class TwoArrays
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    static class payload implements Comparable<payload>
    {
	long key;
	int i,j;
	public payload(long key,int i,int j) {
	    this.key = key;
	    this.i = i;
	    this.j = j;
	}
	@Override
	public int compareTo(payload o) {
	    return (this.key==o.key)?0:(this.key>o.key)?1:-1;
	}
    }

    private static long[] oneSwap(long a[],long b[])
    {
	long sumA = 0;
	long sumB = 0;
	for(long i:a)
	    sumA+=i;
	for(long i:b)
	    sumB+=i;

	if(sumA-sumB==0)
	    return null;
	else
	{
	    long min = Math.abs(sumA - sumB);	    
	    long ans[] = new long[3];
	    ans[0] = min;
	    ans[1] = 0;
	    ans[2] = 0;
	    for(int i=1,n=a.length;i<n;i++)
	    {
		for(int j=1,m=b.length;j<m;j++)
		{
		    long newSumA = sumA - a[i] + b[j];
		    long newSumB = sumB - b[j] + a[i];
		    long diff = Math.abs(newSumA - newSumB);
		    if(diff < min)
		    {
			min = diff;
			ans[0] = diff;
			ans[1] = i;
			ans[2] = j;
		    }
		}
	    }
	    return ans;
	}
    }

    private static void solve(FastScanner s1, FastWriter out){

	int n = s1.nextInt();
	long a[] = s1.nextLongArray(n, 1);	
	int m = s1.nextInt();
	long b[] = s1.nextLongArray(m, 1);
	long oneSwapAns [] = oneSwap(a, b);
	if(oneSwapAns == null)
	{
	    out.print("0\n0");
	}
	else
	{
	    if(n==1 || m==1)
	    {
		out.println(oneSwapAns[0]);
		if(oneSwapAns[1] == 0)
		    out.print("0");
		else
		{
		    out.println("1");
		    out.print(oneSwapAns[1]+" "+oneSwapAns[2]);
		}
	    }
	    else
	    {
		long sumA = 0L;
		long sumB = 0L;
		for(long i:a)
		    sumA+=i;
		for(long i:b)
		    sumB+=i;
		long min = oneSwapAns[0];
		boolean change = false;
		long ans[] = new long[4];
		int len_a1 = ((n* (n-1) / 2));
		int len_a2 = ((m* (m-1) / 2));
		ArrayList<payload> a1 = new ArrayList<>(len_a1);
		ArrayList<payload> a2 = new ArrayList<>(len_a2);
		long diff = -1;
		int ctA=0,ctB=0;
		for(int i=1;i<n;i++)
		{
		    for(int j=i+1;j<=n;j++)
		    {
			long k = sumA - (2L*(a[i] + a[j]));
			a1.add(new payload(k, i, j));
		    }
		}
		for(int i=1;i<m;i++)
		{
		    for(int j=i+1;j<=m;j++)
		    {
			long k = sumB - (2L * (b[i] + b[j]));
			a2.add(new payload(k, i, j));
		    }
		}
		boolean swap = false;
		if(a1.size() < a2.size())
		{
		    ArrayList<payload> temp = a1;
		    a1 = a2;
		    a2 = temp;	
		    swap = true;
		}
		Collections.sort(a2);
		ctB = a2.size();
		for(payload p:a1)
		{
		    long kA = p.key;
		    //payload ceil = setB.ceiling(p);
		    //payload floor =setB.floor(p);
		    int index = Collections.binarySearch(a2, p);
		    index = index<0?-index - 1:index;
		    if(index != ctB)
		    {
			long kB = a2.get(index).key;
			diff = Math.abs(kA - kB);
			//out.println("kA "+kA+" kB "+kB);
			if(diff < min)
			{
			    min = diff;
			    ans[0] = p.i;ans[1] = a2.get(index).i;
			    ans[2] = p.j;ans[3] = a2.get(index).j;
			    if(swap)
			    {
				ans[0] = a2.get(index).i;ans[1] = p.i;
				ans[2] = a2.get(index).j;ans[3] = p.j;
			    }
			    change = true;
			}
		    }
		    if(index != 0)
		    {
			long kB = a2.get(index-1).key;
			diff = Math.abs(kA - kB);
			//out.println("kA "+kA+" kB "+kB);
			if(diff < min)
			{
			    min = diff;
			    ans[0] = p.i;ans[1] = a2.get(index-1).i;
			    ans[2] = p.j;ans[3] = a2.get(index-1).j;
			    if(swap)
			    {
				    ans[0] = a2.get(index-1).i;ans[1] = p.i;
				    ans[2] = a2.get(index-1).j;ans[3] = p.j;
			    }
			    change = true;
			}
		    }
		}
		if(change)
		{
		    out.println(min);
		    out.println("2");
		    out.println(ans[0]+" "+ans[1]);
		    out.println(ans[2]+" "+ans[3]);
		}
		else
		{
		    out.println(oneSwapAns[0]);
		    out.println("1");
		    out.print(oneSwapAns[1]+" "+oneSwapAns[2]);
		}
	    }
	}
    }

    /************************ SOLUTION ENDS HERE ************************/



    /************************ TEMPLATE STARTS HERE ************************/

    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	solve(in, out);
	in.close();
	out.close();
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

	long[] nextLongArray(int len,int start) {
	    long[] arr = new long[len+start];
	    for (int i = start; i < len+start; i++) {
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

    /************************ TEMPLATE ENDS HERE ************************/
}
