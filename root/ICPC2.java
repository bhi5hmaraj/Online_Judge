//Problem Avantika
import java.util.*;
import java.io.*;
class ICPC2
{
	public static long paint(Integer arr[])
	{
		Arrays.sort(arr);
		long ptr=1;
		long sum=0;
		int temp=0;
		//boolean flag=false;
		for(int i=0;i<arr.length;i++)
		{
			if(temp != arr[i])
			{
				sum+=(long)((long)ptr*arr[i]);
				ptr++;
				temp=arr[i];		
			}
		}
		return sum;
	}
	//1000000000
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        Integer arr[];
        
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	arr = new Integer[len+1];
        	for(int i=1;i<=len;i++)
        	{
        		arr[i]=s1.nextInt();
        	}
        	int n_query=s1.nextInt();
        	for(int i=1;i<=n_query;i++)
        	{
        		int L =s1.nextInt();
        		int R =s1.nextInt();
        		Integer temp[] =new Integer[(R-L)+1];
        		for(int j=0;j<temp.length;j++)
        			temp[j]=arr[L+j];
        		sb.append(paint(temp)+"\n");
        	}
        	
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
        