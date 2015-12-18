/*
public class ClosestNumbers {

}

*/
import java.util.*;
import java.io.*;
public class ClosestNumbers
{
    static  void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	int arr[] = s1.nextIntArray(s1.nextInt());
	shuffleArray(arr);
	Arrays.sort(arr);
	StringBuilder sb = new StringBuilder();
	int small = Integer.MAX_VALUE;
	for(int i=1;i<arr.length;i++)
	{
	    int diff = arr[i] - arr[i-1];
	    if(diff<=small)
	    {
		if(diff < small)
		{
		    sb = new StringBuilder();
		}
		sb.append(arr[i-1]+" ");
		sb.append(arr[i]+" ");
		small = diff;
	    }
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
        