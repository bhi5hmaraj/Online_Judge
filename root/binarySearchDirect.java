/*
Java sorting benchmark  N ~ 2*10^5
Arrays.sort  				---- TLE
Arrays.parallelSort 			---- TLE
Arrays.sort(shuffled) 			---- 311 ms
Arrays.parallelSort(shuffled)   	---- 311 ms (but more memory than normal sort)
Arrays.sort (Integer)			---- 436 ms 
Arrays.parallelSort(Integer)		---- 498 ms 
Arrays.stream.sorted			---- TLE
Arrays.stream.sorted(shuffled)		---- 358 ms
Arrays.stream.parallel.sorted		---- 389 ms
Arrays.stream.sorted(Integer)		---- 498 ms
Arrays.stream.parallel.sorted(Integer)	---- 483 ms

*/
import java.util.*;
import java.io.*;
public class binarySearchDirect
{
    static int arr1[];
    static  void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    static int upperBound(int key)    //Number of elements LESS THAN OR EQUAL TO key 
    {
	int first=0,last=arr1.length-1,middle=-1;
	int less_and_equal=0;
	while(first <= last)
	{
	    middle = (first+last)/2;
	    if(key>=arr1[middle])
	    {
		less_and_equal+=((middle-first)+1);
		first=middle+1;
	    }
	    else
		last=middle-1;
	}
	    return less_and_equal;
    }
    public static void main(String args[]) 
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb = new StringBuffer();
        int m = s1.nextInt();
	int n = s1.nextInt();
	arr1 = new int[m];
	for(int i=0;i<m;i++)
	    arr1[i] = s1.nextInt();
	int arr2[] = s1.nextIntArray(n);
	shuffleArray(arr1);
	//arr1 = Arrays.stream(arr1).parallel().sorted().toArray();
	Arrays.sort(arr1);
	for(int i=0;i<n;i++)
	    sb.append(upperBound(arr2[i])+" ");
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
        