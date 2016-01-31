import java.util.*;
import java.io.*;
public class Basketball
{

    /************************ SOLUTION STARTS HERE ************************/

    //DONT FORGET TO COMMIT AND PUSH TO GITHUB

    private static int lower_bound(int arr[] , int key) //if it exists then returns the lower bound or else returns -(pos+1)
    {
	int lo = 0;
	int hi = arr.length-1;
	int mid =  0;
	int pos = -1;
	boolean flag = false;
	while(lo <= hi)
	{
	    mid = (lo+hi)/2;
	    if(arr[mid] >= key)
	    {
		if(arr[mid] == key && !flag)
		    flag = true;
		hi = mid-1;
		pos = mid;
	    }
	    else
		lo = mid+1;
	}
	if(flag)
	    return pos;
	else
	{
	    if(pos==-1)
		pos=arr.length;
	    pos = -(pos+1);
	    return pos;
	}
    }

    static  void shuffleArray(int[] array) {
	Random random = new Random();
	for (int i = array.length - 1; i > 0; i--) {
	    int index = random.nextInt(i + 1);
	    int temp = array[index];
	    array[index] = array[i];
	    array[i] = temp;
	}
    }
    private static void solve(FastScanner s1, FastWriter out){

	int n = s1.nextInt();
	int a[] = s1.nextIntArray(n);
	int m = s1.nextInt();
	int b[] = s1.nextIntArray(m);	
	//shuffleArray(a);
	//shuffleArray(b);
	//Arrays.sort(a);
	//Arrays.sort(b);
	Arrays.parallelSort(a);
	Arrays.parallelSort(b);
	//a = Arrays.stream(a).sorted().toArray();
	//b = Arrays.stream(b).sorted().toArray();
	//a = Arrays.stream(a).parallel().sorted().toArray();
	//b = Arrays.stream(b).parallel().sorted().toArray();
	int maximize = Integer.MIN_VALUE;
	int ans_A = -1,ans_B=-1;
	for(int i=0;i<n;i++)
	{
	    int index = lower_bound(b, a[i]);
	    int pt_A = ((n - i )*3) + (i * 2);
	    //System.out.println("above d = "+ (m - index ) + "index = "+index);
	    int pt_B=Integer.MIN_VALUE;
	    if(index < 0)
	    {
		index = (-index)-1;
		//System.out.println("inside"+index);
		if(index == 0)
		    pt_B = m * 3;
		else if(index == m)
		    pt_B = m * 2;
		else
		{
		     pt_B = ((m - index)*3) + (index * 2);
		}
	    }
	    else
	    {
		pt_B = ((m - index)*3) + (index * 2);
	    }
	    int diff = pt_A - pt_B;
	    if(diff > maximize)
	    {
		maximize = diff;
		ans_A = pt_A;
		ans_B = pt_B;
	    }
	    
	    while(i<n-1 && a[i]==a[i+1])i++;
	}
	if((n*3) - (m*3) > maximize)
	    out.print((n*3) + ":" + (m*3));
	else if((n*2) - (m*2) > maximize)
	    out.print((n*2) + ":" + (m*2));
	else
	    out.print(ans_A+":"+ans_B);
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

    /************************ TEMPLATE ENDS HERE ************************/
}
