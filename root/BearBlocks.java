import java.util.*;
import java.io.*;
public class BearBlocks
{
	public static int ROW,COL;
	public static boolean dp[][];
	public static Stack<Integer> stk;
	public static void printDp(int R,int C)
	{
        for(int i=0;i<R;i++)
        {
        	for(int j=0;j<C;j++)
        	{
        		if(dp[i][j])
        			System.out.print(dp[i][j]+"  ");
        		else
        			System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
	}
	
	public static boolean isValid(int i,int j)
	{
		if(i<0 || i>=ROW || j<0 || j>=COL)
			return false;
		else
			return true;
	}
	
	public static boolean isBound(int i,int j)   //NOT CORRECT I HAVE TO CHECK EDGE CASES
	{
		if(!(isValid(i,j-1) && isValid(i,j+1) && isValid(i-1,j)))   //checking corners and edges
			return true;
		else
		{
			if(!(dp[i][j-1] && dp[i][j+1] && dp[i-1][j]))
				return true;
			else 
				return false;
		}
	}
	public static void fill(int i,int j)
	{
		if(isValid(i,j))
		{
			if(dp[i][j])
			{
			if(isBound(i,j))
			{
				dp[i][j]=false;	
			}
			else
			{
				stk.push((COL*i)+j);
			}
			fill(i,j+1);
			fill(i,j-1);
			fill(i-1,j);
			fill(i+1,j);
			}
		}
	}
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
        int C=s1.nextInt();
        int R=0;
        int arr[]=new int[C];
        for(int i=0;i<C;i++)
        {
        	arr[i]=s1.nextInt();
        	if(arr[i] > R)
        		R=arr[i];
        } 
        dp=new boolean[R][C];
        ROW=R;
        COL=C;
        for(int i=0;i<C;i++)
        {
        	for(int j=R-1;j>=0;j--)
        	{
        		if(j>=(R-arr[i]))
        			dp[j][i]=true;
        		else
        			dp[j][i]=false;
        	}
        }
        stk=new Stack<>();
        stk.push(COL*(ROW-arr[0]));
        int ct=0;
        while(!stk.isEmpty())
        {
        	int val=stk.pop();
        	int i=val/COL;
        	int j=val%COL;
        	System.out.println("inside while i= "+i" j= "+j);
        	if(dp[i][j])
        	{
        		fill(i,j);
        		ct++;
        	}
        		
        }
        out.println(ct);
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
        