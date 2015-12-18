import java.util.*;
import java.io.*;
class LIGHTHSE
{
	static class Point  implements Comparable<Point>
	{
		int x,y;
		Point(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		public int compareTo(Point that)
		{
			return this.x-that.x;
		}
	}
	
	static class YCompare implements Comparator<Point>
	{		
		public int compare(Point p1,Point p2)
		{
			return p1.y-p2.y;
		}
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int len=s1.nextInt();
        	Point arr[]=new Point[len];
        	for(int i=0;i<len;i++)
        	{
        		arr[i]=new Point(s1.nextInt(),s1.nextInt());
        	}
        	Arrays.sort(arr);
        	int ptr=1;
        	int low_ct=1,high_ct=1;
        	while(arr[ptr].x == arr[0].x)
        	{
        		low_ct++;
        		ptr++;
        	}
        	ptr=len-2;
        	while(arr[ptr].x == arr[len-1].x)
        	{
        		high_ct++;
        		ptr--;
        	}
        	
        }

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
        