import java.util.*;
import java.io.*;
class Memories
{
    //DONT FORGET TO COMMIT AND PUSH TO GITHUB
    private static HashSet<Integer>[] blacklist;
    private static ArrayList<Set<Integer>> findPowerSet(ArrayList<Integer> originalSet) {
	ArrayList<Set<Integer>> powerSet = new ArrayList<Set<Integer>>();
	if (originalSet.isEmpty()) {
	    powerSet.add(new HashSet<Integer>());
	    return powerSet;
	}
	List<Integer> list = new ArrayList<Integer>(originalSet);
	Integer head = list.get(0);
	ArrayList<Integer> rest = new ArrayList<Integer>(list.subList(1, list.size())); 
	for (Set<Integer> set : findPowerSet(rest)) {
	    Set<Integer> newSet = new HashSet<Integer>();
	    newSet.add(head);	    	
	    newSet.addAll(set);
	    powerSet.add(newSet);
	    powerSet.add(set);
	}		
	return powerSet;
    }
    private static void solve(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	while(t-->0)
	{
	    int N = s1.nextInt();
	    int pairs = s1.nextInt();
	    blacklist = (HashSet<Integer>[])new HashSet[N+1];
	    for(int i=1;i<=N;i++)
		blacklist[i] = new HashSet<>();
	    while(pairs-->0)
		blacklist[s1.nextInt()].add(s1.nextInt());

	    ArrayList<Integer> nums = new ArrayList<>();
	    for(int i=1;i<=N;i++)
		nums.add(i);

	    ArrayList<Set<Integer>> powerSet = findPowerSet(nums);

	    int ct = 0;
	    for(Set<Integer> set : powerSet)
	    {
		if(set.size() > 0)
		{
		    boolean flag = true;
		    outer:
			for(int i : set)
			{
			    for(int j:blacklist[i])
			    {
				if(set.contains(j))
				{
				    flag = false;
				    break outer;
				}
			    }
			}
		    if(flag)
			ct++;
		}
	    }
	    out.println(ct);
	}
    }

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
