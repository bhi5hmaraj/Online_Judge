import java.util.*;
import java.io.*;
class LandingPlatform
{
	static int strengthSum(int arr[][],int x,int y,int side)
	{
		int sum=0;
		int p=x; //left most point(p,q)
		int q=y;
		int r=x; // right point(r,s)
		int s=y+(side-1);
		for(int i=1;i<=side;i++)
		{
			sum+=arr[p][q]+arr[r][s];
			p++;
			q++;
			r++;
			s--;
		}
		if(side%2==1) //if side is odd then we would have added the center twice
			{
				sum-=arr[x+(side/2)][y+(side/2)];
			}
	
		return sum;
		
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        StringBuffer sb = new StringBuffer();
        int t=s1.nextInt();
        int arr[][];
        for(int z=1;z<=t;z++)
        {
        	int m=s1.nextInt();
        	int n=s1.nextInt();
        	arr=new int[m][n];
        	int side=Math.min(m, n);
        	for(int i=0;i<m;i++)
        	{
        		for(int j=0;j<n;j++)
        		{
        			arr[i][j]=s1.nextInt();
        		}
        	}
        	int big=0;
        	int first=0;
        	int temp=0;
        	for(int i=0;i<m-1;i++)
        	{
        		for(int j=0;j<n-1;j++)
        		{
        			int p=i;
        			int q=j;
        			int k=2;
        			while(!(p>=(m-1) || q>=(n-1)))
        			{
        				
        				temp=strengthSum(arr, i, j, k);
        				if(first==0)
        				{
        					first=1;
        					big=temp;
        				}
        				if(temp > big)
        					big=temp;
        				
        				k++;
        				p++;
        				q++;
        			}
        		}
        	}
        	sb.append(big+"\n");
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
        //-1000000