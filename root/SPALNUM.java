import java.util.*;
import java.io.*;
class SPALNUM
{
	public static boolean isPalin(String str)
	{
		int len = str.length();
		int end = len/2;
		for(int i=0;i<end;i++)
			if(str.charAt(i) != str.charAt(len-i-1))
				return false;
		
		return true;
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
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        final int MAX = (int)1e5;
        ArrayList<Integer> palins = palindromes(1, MAX);
        long sum_arr[] = new long [MAX+1];
        int ptr =0;
        long sum =0;
        int palin_len =palins.size();
        for(int i=1;i<=MAX;i++)
        {
        	if(ptr<palin_len && i == palins.get(ptr))
        	{
        		ptr++;
        		sum+=i;        		
        	}
        	sum_arr[i] = sum;
        }
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int start = s1.nextInt();
        	int end   = s1.nextInt();
        	sb.append(sum_arr[end] - sum_arr[start-1] + "\n");
        }
        out.println(sb);
        out.close();
    }
}
class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
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
}
        