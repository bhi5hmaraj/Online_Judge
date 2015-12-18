import java.util.*;
import java.io.*;
class ORACLCS
{
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
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        HashMap<Character,Integer> freq = null;       
        for(int z=1;z<=t;z++)
        {
            int small = Integer.MAX_VALUE;
            int n = s1.nextInt();
            while(n-->0)
            {
        	freq = freqOfChar(s1.next());
        	int freq_a = (freq.get('a')==null?0:freq.get('a'));
        	int freq_b = (freq.get('b')==null?0:freq.get('b'));
        	int min = Math.min(freq_a, freq_b);
        	if(min < small)
        	    small = min;
            }
            sb.append(small+"\n");
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
        