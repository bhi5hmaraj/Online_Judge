import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class Char
{
    public static <Key> HashMap<Key , java.lang.Integer> frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    	return mp;
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        HashMap<Character,Integer> temp;
        int n = s1.nextInt();
        int arr[][] =new int[26][26];
        int n_diff=0;
        for(int i=1;i<=n;i++)
        {
        	String str = s1.next();
        	int len = str.length();
        	temp = new HashMap<>();
        	for(int j=0;j<len;j++)
        		frequency(temp, str.charAt(j));
        	if(temp.size() == 1)
        	{
        		for(Map.Entry<Character, Integer> e : temp.entrySet())
        		{
        			int index = e.getKey() - 'a';
        			arr[index][index] += e.getValue();
        		}
        		n_diff++;
        		continue;        		
        	}
        	if(temp.size() == 2)
        	{
        		int ct=1;
        		int index1=0,index2=0;
        		int l=0;
        		for(Map.Entry<Character, Integer> e : temp.entrySet())
        		{
        			if(ct==1)
        			{
        				index1 = e.getKey() - 'a';
        				l+=e.getValue();
        				ct++;
        			}
        			else
        			{
        				index2 = e.getKey() - 'a';
        				l+=e.getValue();
        			}
        		}
        		arr[index1][index2] += l;
        		arr[index2][index1] += l;
        		n_diff++;
        	}        	
        }
        int pos_diff1 = -1,bigdiff=0,bigsame=0,pos_same=-1,big=0,pos_diff2=-1,bigsame2=0;
        for(int i=0;i<26;i++)
        {
        	for(int j=0;j<26;j++)
        	{
        		if(arr[i][j] != 0)
        		{
        		if(i!=j)
        		{
        			if((arr[i][j]+arr[i][i]+arr[j][j]) > bigdiff)
        			{
        				bigdiff = arr[i][j]+arr[i][i]+arr[j][j];
        				pos_diff1 = i;
        				pos_diff2 = j;
        			}
        		}
        		else
        		{
        			if(arr[i][j] > bigsame)
        			{
        				bigsame = arr[i][j];        				
        				pos_same = i;
        			}
        		}
        		}
        	}
        }
        for(int i=0;i<26;i++)
        {
        	if(arr[i][i] >bigsame2 && i!=pos_same)
        		bigsame2 =arr[i][i];
        }
        /*
        for(int a[] : arr)
        {
        	out.println(Arrays.toString(a));
        }
        */   
        bigsame+=bigsame2;
        if(bigsame > bigdiff)
        	big = bigsame;
        else
        	big = bigdiff;
        /*
        if(bigdiff == 0 && n_diff>=2)
        	big =2;
        	*/
        out.println(big);
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

        