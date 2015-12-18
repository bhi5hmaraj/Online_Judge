import java.util.*;
import java.io.*;
public class CleanerRobot
{
	static int w,h;
	static char chars[][];
	static class State extends Object
	{
		char dir;
		int r,c;
		State()
		{
		}
		State(char dir,int r,int c)
		{
			this.c=c;
			this.r=r;
			this.dir=dir;
		}
		public boolean equals(State that)
		{
			return this.r==that.r && this.c==that.c && this.dir==that.dir;
		}
		
		public String toString()
		{
			return "Direction= "+dir+" Row= "+r+" Col= "+c;
		}
	}
	
	static boolean isValid(State s)
	{
		if(s.r<0 || s.c<0 || s.r>=w || s.c>=h || chars[s.r][s.c] == '*')
			return false;
		else
			return true;
	}
	static char rotate(char ch)
	{
		switch(ch)
		{
		case 'U':
			return 'R';
		case 'R':
			return 'D';
		case 'D':
			return 'L';
		case 'L':
			return 'U';
		default:
			return '\0';		
		}
	}
	static State move(State s)
	{
		int r,c;
		char ch;
		State mv    =  new State(s.dir,s.r,s.c);
		State up    =  new State(s.dir,s.r-1,s.c);
		State down  =  new State(s.dir,s.r+1,s.c);
		State left  =  new State(s.dir,s.r,s.c-1);
		State right =  new State(s.dir,s.r,s.c+1);
		if(!(isValid(up) || isValid(down) || isValid(left) || isValid(right)))
			return mv;
		while(true)
		{
		ch=mv.dir;
		if(ch == 'U')
		{
			mv.r=s.r-1;
			mv.c=s.c;
		}
		else if(ch == 'R')
		{
			mv.r=s.r;
			mv.c=s.c+1;
		}
		else if(ch == 'D')
		{
			mv.r=s.r+1;
			mv.c=s.c;
		}
		else
		{
			mv.r=s.r;
			mv.c=s.c-1;
		}		
		if(isValid(mv))
			return mv;
		else
			mv.dir = rotate(mv.dir);
		}
	}
	
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();    
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);        
        w = s1.nextInt();
        h = s1.nextInt();
        chars = new char[w][h];
        State start=null;
        State curr=null;
        State mv=null;
        State parent[][] = new State[w][h];
        for(int i=0;i<w;i++)
        {
        	String line = s1.next();        	
        	for(int j=0;j<h;j++)
        	{
        		char c = line.charAt(j);
        		chars[i][j] = c;
        		if(Character.isLetter(c))
        			start = new State(c,i,j);        		
        	}
        }
        curr=start;
        //out.println(move(curr));
        int area=0;
        while(true)
        {
        	//out.print("curr="+curr);        	
        	mv=move(curr);
        	//out.println("mv="+mv);
        	curr.dir=mv.dir;
        	if(parent[mv.r][mv.c]!=null && parent[mv.r][mv.c].equals(curr))
        		break;
        	if(parent[mv.r][mv.c] == null)        	        	
        		area++;
        	parent[mv.r][mv.c] = curr;
        	curr=mv;        	
        }
        if(parent[start.r][start.c] == null)
        	area++;
        /*for(State row[] : parent)
        	out.println(Arrays.deepToString(row));*/
        
        out.println(area);
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
        