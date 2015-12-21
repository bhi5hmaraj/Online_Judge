import java.util.HashMap;

/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

    static int loPrime[];
    static void loPrimeSieve(int N)
    {
	loPrime= new int[N + 1];		
	int pr[] = new int[N];
	int sz=0;
	for (int i = 2; i <= N; ++i)
	{
	    if (loPrime[i] == 0)
	    {
		loPrime[i] = i;	            
		pr[sz]=i;
		sz++;
	    }
	    for (int j = 0; j < sz && pr[j] <= loPrime[i] && i * pr[j] <= N; ++j)
		loPrime[i * pr[j]] = pr[j];
	}
    }

    static HashMap<Integer,Integer> primeFactorize(int N)   //Dependency : A sieve (loPrime[]) which contains the lowest prime divisor for each number
    {
	HashMap<Integer,Integer> mp = new HashMap<>();
	int ct,prime;
	while(N!=1)
	{
	    prime = loPrime[N];
	    ct = 0;
	    while(N % prime == 0)
	    {
		N /= prime;	
		ct++;
	    }
	    mp.put(prime, ct);
	}
	return mp;
    }


    private static int lower_bound(int arr[] , int key) //if it exists then returns the lower bound or else returns -(pos+1)
    {
	int lo = 0;
	int hi = arr.length-1;
	int mid =0;
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
		pos=arr.length-1;
	    pos = -(pos+1);
	    return pos;
	}
    }
    private static int upper_bound(int arr[] , int key) //if it exists then returns the lower bound or else returns -(pos+1)
    {
	int lo = 0;
	int hi = arr.length-1;
	int mid =0;
	int pos = -1;
	boolean flag = false;
	while(lo <= hi)
	{
	    mid = (lo+hi)/2;
	    if(arr[mid] <= key)
	    {
		if(arr[mid] == key && !flag)
		    flag = true;
		lo = mid+1;
		pos = mid;
	    }
	    else
	    {
		hi = mid-1;
	    }
	}
	if(flag)
	    return pos;
	else
	{
	    if(pos==-1)
		return pos;
	    else
		return lower_bound(arr, key);
	}
    }


    private static String nextBiggestPermutation(String str)   //If it returns null then no permutation exists
    {
	char ch[] = str.toCharArray();
	int i = ch.length -1;
	boolean flag = false;
	while(i>0)
	{
	    if(ch[i] > ch[i-1])
	    {
		flag = true;
		break;
	    }
	    i--;
	}
	if(flag)
	{
	    int start = i-1;
	    char curr = ch[start];	    
	    Arrays.sort(ch, start, ch.length);
	    char temp[] = Arrays.copyOfRange(ch, start, ch.length);
	    int lub = Arrays.binarySearch(ch, start, ch.length, curr);   //element after the curr	    
	    while(ch[lub] == curr)lub++;
	    char lub_ch = ch[lub];
	    ch[start] = ch[lub];
	    int t=0;
	    for(int ptr=start+1;ptr<ch.length;ptr++)
	    {
		if(temp[t] != lub_ch)
		    ch[ptr] = temp[t++];
	    }
	    return new String(ch);
	}
	else
	    return null;
    }
     private static int partition(int[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi + 1;
	        int v = a[lo];
	        while (true) { 

	            // find item on lo to swap
	            while (less(a[++i], v))
	                if (i == hi) break;

	            // find item on hi to swap
	            while (less(v, a[--j]))
	                if (j == lo) break;      // redundant since a[lo] acts as sentinel

	            // check if pointers cross
	            if (i >= j) break;

	            exch(a, i, j);
	        }

	        // put partitioning item v at a[j]
	        exch(a, lo, j);

	        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
	        return j;
	    }
     private static boolean less(int v, int w) {
	        return v-w < 0;
	    }
     private static void exch(int[] a, int i, int j) {
	        int swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

    private static int selection(int arr[] , int k)
        {
        int lo=0,hi = arr.length-1;
        int pos = partition(arr,lo,hi);
        while(lo < hi)
            {
            //System.out.println("pos"+pos);
            if(pos < k)
                lo = pos+1;
            else if(pos > k)
                hi = pos-1;
            else 
        	break;
            pos = partition(arr,lo,hi);
        }
        return arr[pos];
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

    public static <Key> void frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    }
    public static HashMap<Character,Integer> freqOfChar(String str)
    {
	HashMap<Character,Integer> mp = new HashMap<>();
	for(int i=0,len=str.length();i<len;i++)
	{
	    char k = str.charAt(i);
	    	Integer query = mp.get(k);
	    	if(query == null)
	    		mp.put(k, new Integer(1));
	    	else
	    	{
	    		mp.put(k, query + 1);
	    	}
	}
	return mp;
    }
    private static String filter(String str)   //Removes duplicate chars in a string
    {
	HashSet<Character> filter = new HashSet<>();
	StringBuilder sb = new StringBuilder();
	for(char c:str.toCharArray())
	{
	    if(!filter.contains(c))
	    {
		filter.add(c);
		sb.append(c);		
	    }
	}
	return sb.toString();
    }
	public static ArrayList<Integer> sieve(int N)     //Sieve of Erathanoses
	{
		ArrayList<Integer> primes = new ArrayList<>();
		boolean num[] = new boolean[N+1];
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}
		for(int i=2;i<num.length;i++)
			if(!num[i])
				primes.add(i);
		
		return primes;
	}
	
	public static boolean isPalin(String str)
	{
		int len = str.length();
		int end = len/2;
		for(int i=0;i<end;i++)
			if(str.charAt(i) != str.charAt(len-i-1))
				return false;
		
		return true;
	}
	static long gcd(long big,long small)
	{
		 long b = Math.max(big, small);
		 long s = Math.min(big, small);
		 if(s == 0)
			 return b;
		 else
			 return gcd(s,b%s);
	}
	public static ArrayList<Integer> palindromes(int start,int end)
	{
		ArrayList<Integer> palins = new ArrayList<>();
		for(int i=start;i<=end;i++)
		{
			if(isPalin(String.valueOf(i)))
				palins.add(i);
		}
		return palins;
	}
	
	static long nCk(int n,int k)
	{
		if(n==k)
			return 1;
		long ans=1;		
		k=(int)Math.min(k, n-k);
		for(int i=1;i<=k;i++,n--)
		{
			if(n % i == 0)
			{
				ans*=(n/i);
			}
			else if(ans % i ==0)
			{
				ans=(ans/i)*n;
			}
			else
			{
				ans=(ans*n)/i;
			}
		}
		return ans;
	}
	
	public static boolean[] isCompositeArray(int N)     //Sieve of Erathanoses
	{
		boolean num[] = new boolean[N+1];
		num[1]=true;
		int end = (int)Math.sqrt(N);
		for(int i=2;i<=end;i++)
		{
			if(!num[i])			
				for(int j=i*2;j<num.length;j+=i)
					num[j] = true;			
		}
		
		return num;
	}
	
	
class  MyMap <K , V > extends HashMap<K,ArrayList<V>>
{
	private static final long serialVersionUID = 1L;    //don't know what it is but eclipse gives me a warning 
	public MyMap() {
		super();
	}
	
	@Override
	public ArrayList<V> put(K key, ArrayList<V> value) {
		return super.put(key, value);
	}
	
	public void putVal(K key,V value)
	{
		ArrayList<V> arl = get(key);
		if(arl == null)
		{
			arl = new ArrayList<>();
			arl.add(value);
		}
		else
			arl.add(value);
		
		put(key,arl);
	}
}
	
	class FasterScanner {
    private byte[] buf = new byte[1024];
    private int tmp_curChar;
    private int tmp_numChars;

    public int read() {
        if (tmp_numChars == -1)
            throw new InputMismatchException();
        if (tmp_curChar >= tmp_numChars) {
            tmp_curChar = 0;
            try {
                tmp_numChars = System.in.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (tmp_numChars <= 0)
                return -1;
        }
        return buf[tmp_curChar++];
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

     public String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
       
    public int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }
   
    public long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}


class Pair<A, B> {
  public final A first;
  public final B second;

  public Pair(final A first, final B second) {
    this.first = first;
    this.second = second;
  }

   public boolean equals(Pair<A,B> that)
   {
        return this.first.equals(that.first) && this.second.equals(that.second);
   }
}
static int mod = 1000000007;
public static int mul(int a,int b)
	{
		return ((a%mod)*(b%mod))%mod;
	}
	public static int add(int a,int b)
	{
		return ((a%mod)+(b%mod))%mod;
	}
	static class Matrix
	{
		int e00,e01,e10,e11;
		Matrix(int a,int b,int c,int d)
		{
			e00=a;e01=b;e10=c;e11=d;
		}
		Matrix multiply(Matrix that)
		{
			int a=add(mul(this.e00,that.e00),mul(this.e01,that.e10));
			int b=add(mul(this.e00,that.e01),mul(this.e01,that.e11));
			int c=add(mul(this.e10,that.e00),mul(this.e11,that.e10));
			int d=add(mul(this.e10,that.e01),mul(this.e11,that.e11));
			return new Matrix(a,b,c,d);
		}
		public String toString()
		{
			return e00+" "+e01+"\n"+e10+" "+e11+"\n";
		}
	}
	public static Matrix pow(Matrix m,int b)
	{
		if(b==1)
			return m;
		else
		{
			if((b&1) == 0)
			{
				return pow(m.multiply(m),b/2);
			}
			else
			{
				return m.multiply(pow(m.multiply(m),(b-1)/2));
			}
		}
	}
*/
	