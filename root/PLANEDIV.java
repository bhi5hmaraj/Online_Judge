animport java.util.*;
import java.io.*;
class PLANEDIV
{

    static class Line
    {
	final long A,B,C;
	private Double m;
	public Line(long A,long B,long C)
	{
	    //int gcd = (int)gcd(A,gcd(B,C));             /*****IMPORTANT*******/
	    this.A = A;
	    this.B = B;
	    this.C = C;
	    if(A == 0)
		m = 0.0;
	    else if(B == 0)
		m = Double.POSITIVE_INFINITY;
	    else		
		m = ((double)-A)/B;
	}
	public int hashCode()
	{	    
	    return m.hashCode();
	}
	public String toString()
	{
	    return "A= "+A+" B= "+B+" C= "+C+" m= "+m;
	}
    }
    
    
    private static int biggestPerfectSubset(Line arr[])
    {
        HashMap<Integer,HashSet<Integer>> mp = new HashMap<>();
        int len = arr.length;
        for(int i=0;i<len;i++)
        {
            int hash1 = arr[i].hashCode();
            if(arr[i].A != 0 && arr[i].B != 0)
            {        	
        	HashSet<Integer> curr = mp.get(hash1);
        	if(curr == null)        	
        	    curr = new HashSet<>();     
        	if(arr[i].C == 0)
        	    curr.add(new Double(Double.POSITIVE_INFINITY).hashCode());
        	else
        	{
        	    Double hash = ((double)arr[i].A)/arr[i].C;
        	    curr.add(hash.hashCode());
        	}
        	mp.put(hash1, curr);
            }
            else if(arr[i].A == 0 && arr[i].B != 0)
            {
        	Double y = ((double)-arr[i].C)/arr[i].B;
        	if(y.compareTo(-0.0)==0)
        	    y = 0.0;
        	//System.out.println("line"+arr[i]+"hash"+y);
        	int hash2 = y.hashCode();
        	HashSet<Integer> parallelX = mp.get(hash1);
        	if(parallelX == null)        	
        	    parallelX = new HashSet<>();  
        	parallelX.add(hash2);
        	mp.put(hash1, parallelX);
            }
            else if(arr[i].A != 0 && arr[i].B == 0)
            {
        	Double x = ((double)-arr[i].C)/arr[i].A;
        	if(x.compareTo(-0.0) == 0)
        	    x = 0.0;
        	//System.out.println("line"+arr[i]+"hash"+x);
        	int hash2 = x.hashCode();
        	HashSet<Integer> parallelY = mp.get(hash1);
        	if(parallelY == null)        	
        	    parallelY = new HashSet<>();  
        	parallelY.add(hash2);
        	mp.put(hash1, parallelY);
            }
            else
        	return -1; //This case won't happen
        }
        int big = 0;
        for(Map.Entry<Integer,HashSet<Integer>> e:mp.entrySet())
        {
            if(e.getValue().size() > big)
        	big = e.getValue().size();
        }
        //System.out.println(mp);
        return big;
    }
    
    public static void main(String args[])
    {
	MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();    
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
            int nLines = s1.nextInt();
            Line arr[] =new Line[nLines];
            for(int i=0;i<nLines;i++)
            {
        	arr[i] = new Line(s1.nextLong(), s1.nextLong(), s1.nextLong());
        	//out.println(arr[i]);
            }
            sb.append(biggestPerfectSubset(arr)+"\n");            
        }
        out.println(sb);
        out.close();
    }
    static class MyScanner2 {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner2() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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

}

}
        