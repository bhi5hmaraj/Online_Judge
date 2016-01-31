import java.util.*;
import java.io.*;
public class Colliders
{
    
    /************************ SOLUTION STARTS HERE ************************/
    
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    static int bigPrime[];
    static int N;
    private static void preCalBigPrimeSieve()
    {
	bigPrime[1] = 1;
	for(int i = 2;i<=N;i++)
	{
	    if(bigPrime[i] == 0)
	    {
		bigPrime[i] = i;
		for(int j = 2*i;j<=N;j += i)
		    bigPrime[j] = i;
	    }
	}
    }
    static HashSet<Integer> primeFactorize(int num)   //Dependency : A sieve (bigPrime[]) which contains the lowest prime divisor for each number
    {
	HashSet<Integer> pFactors = new HashSet<>();
	int prime;
	while(num!=1)
	{
	    prime = bigPrime[num];
	    while(num % prime == 0)
	    {
		num /= prime;	
	    }
	    pFactors.add(prime);
	}
	return pFactors;
    }
    private static void solve(FastScanner s1, FastWriter out){	
	char a = '5';
	System.out.println(Character.getNumericValue(a));
	N = s1.nextInt();
	int M = s1.nextInt();
	bigPrime = new int[N+1];
	boolean isOn[] = new boolean[N+1];
	HashMap<Integer,Integer> primePool = new HashMap<>();
	preCalBigPrimeSieve();	
	while(M-->0)
	{
	    char request = s1.nextChar();
	    int num = s1.nextInt();
	    if(request == '+')
	    {
		if(isOn[num])
		    out.println("Already on");
		else
		{
		    boolean flag = true;
		    int conflict = -1;
		    HashSet<Integer> primeFactorize = primeFactorize(num);
		    for(int pFact : primeFactorize)
			if(primePool.containsKey(pFact))
			{
			    conflict = primePool.get(pFact);
			    flag = false;
			    break;
			}
		    
		    if(flag)
		    {
			for(int pFact : primeFactorize)
			    primePool.put(pFact, num);
			isOn[num] = true;
			out.println("Success");
		    }
		    else
		    {
			out.print("Conflict with ");out.println(conflict);
		    }
		}
	    }
	    else
	    {
		if(!isOn[num])
		    out.println("Already off");
		else
		{
		    isOn[num] = false;
		    for(int pFact:primeFactorize(num))
			primePool.remove(pFact);
		    out.println("Success");
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
	public char nextChar(){
	    return next().charAt(0);
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
