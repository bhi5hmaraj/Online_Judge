import java.io.*;
import java.util.*;
 class Main {
	public static void main(String[] args) {
			
    Scanner s1=new Scanner(System.in);    
    //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
     r = s1.nextInt();
     c = s1.nextInt();
    int ct=1;
    //StringBuffer sb = new StringBuffer();
    ArrayList<Pair> arl;
    while(r!=0 && c!=0)
    {
    	System.out.print("Field #"+ct+":\n");
    	char arr[][] = new char[r][c];
    	for(int i=0;i<r;i++)
    	{
    		String line = s1.next();
    		for(int j=0;j<c;j++)
    			arr[i][j] = line.charAt(j);
    	}
    	for(int i=0;i<r;i++)
    	{
    		for(int j=0;j<c;j++)
    		{
    			if(arr[i][j]=='*')
    			{
    				System.out.print('*');
    				continue;
    			}
    			else
    			{
    				arl = validPoints(i, j);
    				int adj = 0;
    				for(Pair p : arl)
    				{
    					if(arr[p.i][p.j] == '*')
    						adj++;
    				}
    				System.out.print(adj);
    			}
    		}
    		System.out.print("\n");
    	}
    	System.out.print("\n");
    	ct++;
    	r = s1.nextInt();
        c = s1.nextInt();
    }
    //System.out.print(sb.toString().trim());        
    //out.close();
    s1.close();
    }
static class Pair
{
	int i,j;
	Pair(int i,int j)
	{
		this.i=i;
		this.j=j;
	}
	public String toString()
	{
		return "("+i+", "+j+")";
	}
}
static int r,c;
static boolean isValid(int i,int j)
{
	if(i>=0 && i<r && j>=0 && j<c)
		return true;
	else
		return false;
}
static ArrayList<Pair> validPoints(int l,int m)
{
	//System.out.println("i="+l+"j="+m);
	ArrayList<Pair> arl = new ArrayList<>();
	for(int i=l-1;i<=l+1;i++)
	{
		for(int j=m-1;j<=m+1;j++)
		{
			if(!(i==l && j==m))
			{
				if(isValid(i, j))
				{
					arl.add(new Pair(i, j));
				}
			}
		}
	}
	//System.out.println(arl);
	return arl;
}

}
 
        