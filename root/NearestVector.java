/*
public class NearestVector {

}

*/
import java.util.*;
import java.io.*;
import static java.lang.Math.*;  //IMORTANT ****DONT FORGET THE STATIC IMPORT****
public class NearestVector
{
    static double tanInv(int x,int y)
    {
	if(x == 0)
	{
	    if(y > 0)
		return PI/2;
	    else
		return (3*PI)/2;
	}	    
	else if(y == 0)
	{
	    if(x > 0)
		return 0.0;
	    else 
		return PI;
	}
	else
	{
	    if((x*y) > 0)
	    {
		double temp = atan((double)y/(double)x);
		if(x > 0)
		    return temp;
		else 
		    return PI + temp;
	    }
	    else
	    {
		double temp = abs(atan((double)y/(double)x));
		if(x > 0)
		    return (2*PI) - temp;
		else
		    return (PI) - temp;
	    }
	}
    }
    static class Pair implements Comparable<Pair>
    {
	Double key;
	int value;
	Pair()
	{
	    key = 0.0;
	    value = 0;
	}
	Pair(double k,int v)
	{
	    key = k;
	    value = v;
	}
	public int compareTo(Pair that)
	{
	    return this.key.compareTo(that.key);
	}
	public String toString()
	{
	    return "["+key+", "+value+"]";
	}
    }
    static double toDegree(double rad)
    {
	return (double)(180*rad)/PI;
    }
    public static void main(String args[])
    {
        MyScanner2 s1=new MyScanner2();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	int len = s1.nextInt();
	Pair arr[] = new Pair[len];
        for(int i=0;i<len;i++)
            arr[i] = new Pair( ( tanInv( s1.nextInt(), s1.nextInt() ) ),i+1);
        Arrays.sort(arr);
        out.println(Arrays.deepToString(arr));
        Double small = Double.MAX_VALUE;
        long smallL = Long.MAX_VALUE;
        int p1=-1,p2=-1;
        int f_i=-1,f_j=-1;
        for(int i=1;i<len;i++)
        {
            Double diff = arr[i].key-arr[i-1].key;
            //smallL = Double.doubleToLongBits(arr[i].key)-Double.doubleToLongBits(arr[i-1].key);
            out.println("diff"+diff+"small"+small+"i"+i+"d-s"+abs(small-diff));
            if(abs(small-diff) <= (1e-14))
            {
              	out.println("in");
              	smallL = Double.doubleToLongBits(arr[f_i].key)-Double.doubleToLongBits(arr[f_j].key);
        	long diffL = Double.doubleToLongBits(arr[i].key)-Double.doubleToLongBits(arr[i-1].key);
                if(diffL < smallL)
                {
            	smallL = diffL;
            	out.println("smallL"+smallL);
            	p1 = arr[i].value;
            	p2 = arr[i-1].value;
                }
                continue;
            }
            if(small>diff)
            {
        	small = diff;
        	f_i=i;
        	f_j=i-1;
        	p1 = arr[i].value;
        	p2 = arr[i-1].value;
        	//out.println("after");
            }            
        }
        Double diff = arr[len-1].key-arr[0].key;
        if(Double.doubleToLongBits((2*PI)-diff) < Double.doubleToLongBits(small))
        {
    	small = (2*PI)-diff;
    	p1 = arr[0].value;
    	p2 = arr[len-1].value;
        }
        //out.println(small);
        out.println(p1+" "+p2);
	out.close();
    }
    static class MyScanner2 {
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
}
/*
 *   
               
 */