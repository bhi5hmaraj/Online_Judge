import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class doubleCola
{
	public static void main(String[] args) {
		
		MyScanner s1=new MyScanner();
		int num=s1.nextInt();
		int x,base,pos;
		int test=(int)(Math.ceil((Math.log(((double)(num+4)/(double)5))/Math.log(2))));
		int flag=0;
		if(((int)Math.pow(2, test)) == ((int)((num+4)/5)))
		{
			x=test+1;
			base=num;
		}
		else
		{
			x=test;
			base=(5*((int)((Math.pow(2,x-1))-1)))+1;
		}
		int div=(int)(Math.pow(2, x-1));
		pos=(num-base)/div;
		String op="";
		switch(pos)
		{
			case 0:
			op="Sheldon";
			break;
			case 1:
			op="Leonard";
			break;
			case 2:
			op="Penny";
			break;
			case 3:
			op="Rajesh";
			break;
			case 4:
			op="Howard";
			break;
		}
			System.out.print(op);
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