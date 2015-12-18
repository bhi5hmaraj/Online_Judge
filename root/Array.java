import java.util.*;
import java.io.*;
public class Array
{
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        int len = s1.nextInt();
        int arr[] = s1.nextIntArray(len);
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> zero =new ArrayList<>();
        for(int i=0;i<len;i++)
        {
        	if(arr[i] > 0)
        		pos.add(arr[i]);
        	else if(arr[i] < 0)
        		neg.add(arr[i]);
        	else
        		zero.add(arr[i]);
        }
        StringBuffer sb = new StringBuffer();

        if(pos.size()!=0)
        {
        	sb.append("1 "+neg.remove(0)+"\n"); 
        	sb.append(pos.size()+" ");
        	for(int INT:pos)
        		sb.append(INT+" ");
        	sb.append("\n");                
        	sb.append(zero.size()+neg.size()+" ");
        	for(int INT:zero)
        		sb.append(INT+" ");
        	for(int INT:neg)
        		sb.append(INT+" ");
        }
        else
        {
        	int one = neg.remove(0);
        	int two = neg.remove(0);
        	int three=0;
        	if(neg.size() % 2 ==0)
        		three = neg.remove(0);
        	sb.append(neg.size()+" ");
        	for(int INT:neg)
        		sb.append(INT+" ");
        	sb.append("\n");
        	sb.append("2 "+one+" "+two+"\n");
        	if(three ==0)
        	{
        	sb.append(zero.size()+" ");
        	for(int INT : zero)
        		sb.append(INT+" ");
        	}
        	else
        	{
        		sb.append(zero.size()+1+" "+three+" ");
            	for(int INT : zero)
            		sb.append(INT+" ");
        	}
        }
        out.println(sb);
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
        