/*
public class binarySearch {

}

*/
import java.util.*;
import java.io.*;
public class binarySearch
{
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
    static class Pair implements Comparable<Pair>
    {
	int key,value;
	Pair()
	{
	    key=-1;
	    value=-1;
	}
	Pair( int a, int b)
	{
	    this.key = a;
	    this.value = b;
	}
	public int compareTo(Pair that)
	{
	    return this.key-that.key;
	}
	public String toString()
	{
	    return "["+key+", "+value+"]";
	}
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	StringBuffer sb = new StringBuffer();
        HashMap<Integer,Integer> freq =new HashMap<>();
	int m = s1.nextInt();
	int n = s1.nextInt();
	int arr1[] = new int[m];
	for(int i=0;i<m;i++)
	{
	    arr1[i] = s1.nextInt();
	    frequency(freq, arr1[i]);
	}
	//out.println(freq);
	int arr2[] = s1.nextIntArray(n);
	int unique = freq.size();
	Pair arr[] = new Pair[unique];
	int ptr = 0;
	for(Map.Entry<Integer,Integer> e:freq.entrySet())
	{
	    arr[ptr] = new Pair(e.getKey(),e.getValue());
	    ptr++;
	}	    
	Arrays.sort(arr);	
	int cache[] = new int[unique];
	cache[0] = arr[0].value;
	for(int i=1;i<unique;i++)
	{
	    cache[i] = cache[i-1]+arr[i].value;
	}
	Pair temp = new Pair();
	//out.println(Arrays.deepToString(arr));
	//out.println("cache"+Arrays.toString(cache));
	for(int i=0;i<n;i++)
	{
	    temp.key=arr2[i];
	    int index = Arrays.binarySearch(arr, temp);
	    int num_less=0;
	    if(index<0)
		index=(-(index+1))-1;
	    
	    //out.println("index"+index);
	    
	    if(index<0)
		num_less=0;
	    else
		num_less=cache[index];
	    sb.append(num_less+" ");
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
        