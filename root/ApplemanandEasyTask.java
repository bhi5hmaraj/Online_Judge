import java.util.*;
import java.io.*;
public class ApplemanandEasyTask
{
	static int n;
	static boolean isValid(int i,int j)
	{
		return i>=0 && j>=0 && i<n && j<n;
	}
	static ArrayList<Pair<Integer,Integer>> validPairs(Pair<Integer,Integer> p)
	{
		ArrayList<Pair<Integer,Integer>> arl = new ArrayList<>();
		if(isValid(p.first-1, p.second))
			arl.add(new Pair<>(p.first-1, p.second));
		if(isValid(p.first+1, p.second))
			arl.add(new Pair<>(p.first+1,p.second));
		if(isValid(p.first, p.second+1))
			arl.add(new Pair<>(p.first,p.second+1));
		if(isValid(p.first, p.second-1))
			arl.add(new Pair<>(p.first, p.second-1));
		
		return arl;
	}
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
         n = s1.nextInt();
        char arr[][] = new char[n][n];
        for(int i=0;i<n;i++)
        {
        	String line = s1.next();
        	for(int j=0;j<n;j++)
        		arr[i][j] = line.charAt(j);
        }
        Pair<Integer,Integer> curr = new Pair<>(0, 0);
        ArrayList<Pair<Integer,Integer>> arl ;
        boolean flag = true;
        outer:
        for(int i=0;i<n;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		curr.first = i;
        		curr.second = j;
        		arl = validPairs(curr);
        		int ct = 0;
        		for(Pair<Integer,Integer> p : arl)
        			if(arr[p.first][p.second] == 'o')
        				ct++;
        		
        		if((ct&1) == 1)
        		{
        			flag = false;
        			break outer;
        		}
        	}
        }
        if(flag)
        	out.println("YES");
        else
        	out.print("NO");
        out.close();
    }
}
class MyScanner2 {
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
   
class Pair<A, B> {
	  public  A first;
	  public  B second;

	  public Pair( A first,  B second) {
	    this.first = first;
	    this.second = second;
	  }

	   public boolean equals(Pair<A,B> that)
	   {
	        return this.first.equals(that.first) && this.second.equals(that.second);
	   }
	}