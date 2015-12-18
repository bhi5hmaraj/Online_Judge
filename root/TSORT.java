import java.util.*;
import java.io.*;
class TSORT
{
	public static void shuffle(int arr[])
	{
		Random rand=new Random();
		int temp=0;
		int len=arr.length;
		int index=0;
		for(int i=0;i<len-1;i++)
		{
			index=i+rand.nextInt(len-i-1)+1;
			temp=arr[index];
			arr[index]=arr[i];
			arr[i]=temp;
		}
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int len=s1.nextInt();
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        	arr[i]=s1.nextInt();
        //shuffle(arr);
        Arrays.sort(arr);
        StringBuffer sb=new StringBuffer();
        for(int op:arr)
        	sb.append(op+"\n");
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
        