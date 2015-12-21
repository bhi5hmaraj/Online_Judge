import java.util.*;
import java.io.*;
public class LoadBalancing
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	int len = s1.nextInt();
	int arr[] = s1.nextIntArray(len);
	double avg = Arrays.stream(arr).average().getAsDouble();
	//out.println(avg);
	int f = (int)Math.floor(avg);
	int c = (int)Math.ceil(avg);
	int total =0 , ct =0;
	for(int i=0;i<len;i++)
	{
	    //out.println(arr[i]+" diff "+Math.min(Math.abs(f-arr[i]), Math.abs(c-arr[i])));
	    int diff =Math.min(Math.abs(f-arr[i]), Math.abs(c-arr[i]));
	    total += diff;
	    if(diff != 0)
		ct++;
	}
	if(ct == 1)
	    out.println(total);
	else
	    out.println((int)Math.ceil((double)total/(double)2));
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