import java.util.*;
import java.io.*;
public class PawnChess
{
	
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);      //Close the output stream after use  
        ArrayList<Integer> black_row = new ArrayList<>();
        ArrayList<Integer> black_col = new ArrayList<>();
        ArrayList<Integer> white_row = new ArrayList<>();
        ArrayList<Integer> white_col = new ArrayList<>();
        for(int i=1;i<=8;i++)
        {
        	String line = s1.next();
        	for(int j=1;j<=8;j++)
        	{
        		if(line.charAt(j-1) == 'B')
        		{
        			black_row.add(i);
        			black_col.add(j);
        		}
        		if(line.charAt(j-1) == 'W')
        		{
        			white_row.add(i);
        			white_col.add(j);
        		}
        	}
        }
        int high_black=0;
        for(int i=0;i<black_row.size();i++)
        {
        	if(black_row.get(i) > high_black)
        	{
        		boolean flag = true;
        		int col = black_col.get(i);
        		for(int j=0;j<white_col.size();j++)
        		{
        			if(white_col.get(j) == col && white_row.get(j)>black_row.get(i))
        			{
        				flag=false;
        				break;
        			}
        		}
        		if(flag)
        		{
            		high_black = black_row.get(i);
            		//out.println("high b"+high_black);
        		}
    		}
        }
        int low_white=Integer.MAX_VALUE;
        for(int i=0;i<white_row.size();i++)
        {
        	if(white_row.get(i) < low_white )
        	{
        		int col = white_col.get(i);
        		boolean flag = true;
        			for(int j=0;j<black_col.size();j++)
        			{
        				if(black_col.get(j)==col && black_row.get(j)<white_row.get(i))
        				{
        					flag = false;
        					break;
        				}
        			}
        		if(flag)
        		{
        		low_white = white_row.get(i);
        		//out.println("low white"+low_white);
        		}
        	}
        }
        int w_moves = low_white - 1;
        int b_moves = 8 - high_black;
        //out.println("w moves "+w_moves);
        //out.println("b_moves "+b_moves);
        if(b_moves < w_moves)
        	out.println("B");
        else
        	out.println("A");
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