import java.util.*;
import java.io.*;
class HECodeGJ
{
    public static void main(String []args) throws IOException {
	FastScanner in  = new FastScanner(System.in);
	FastWriter  out = new FastWriter(System.out);
	//solve1(in, out);  // 4.66s   RB tree (multiset approach)
	solve2(in,out);     // 3.60s   Priority queue with comparator approach
	in.close();
	out.close();
    }
    
    static class MultiMap extends TreeMap<Long,Integer>
    {
	public Integer add(Long key) {
	    Integer q = this.get(key);
	    if(q == null)
		return super.put(key, 1);
	    else
		return super.put(key, q+1);
	}
	@Override
	public Integer remove(Object key) {
	    Integer q = this.get(key);
	    if(q != 1)
		return super.put((Long)key, q-1);
	    else
		return super.remove(key);
	}
    }
    
    private static void solve1(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	MultiMap multi = null;
	while(t-->0)
	{
	    multi = new MultiMap();
	    int len = s1.nextInt();
	    for(int i=1;i<=len;i++)
		multi.add(s1.nextLong());
	    
	    long sum = 0;
	    while(len > 1)
	    {
		long first = multi.lastKey();
		multi.remove(first);
		len--;
		long second = multi.lastKey();
		multi.remove(second);
		len--;
		sum += (first+second);
		multi.add(first+second);
		len++;
		//System.out.println(multi);
	    }
	    out.println(Long.toString(sum));
	}
    }
    private static void solve2(FastScanner s1, FastWriter out)/* This is the actual solution */{
	int t = s1.nextInt();
	PriorityQueue<Long> pq = null;
	while(t-->0)
	{
	    int len = s1.nextInt();
	    pq = new PriorityQueue<>(len, new Comparator<Long>() {
		@Override
		public int compare(Long o1, Long o2) {
		    if(o1<o2)
			return 1;
		    else if(o1>o2)
			return -1;
		    else
			return 0;
		}
	    });
	    for(int i=1;i<=len;i++)
		pq.add(s1.nextLong());
	    
	    long sum = 0;
	    while(pq.size() > 1)
	    {
		long f = pq.remove();
		long s = pq.remove();
		long temp = f+s;
		sum += (temp);
		pq.add(temp);
	    }
	    out.println(Long.toString(sum));
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
