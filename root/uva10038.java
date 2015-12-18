/*
public class uva10038 {

}

*/
import java.util.*;
import java.io.*;
public class uva10038
{
	private static String isJolly(int[] numbers) {
		List<Integer> results = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			int result = Math.abs(numbers[i] - numbers[i + 1]);
			if (result == 0) {
				return "Not jolly";
			}
			if (result >= numbers.length) {
				return "Not jolly";
			}
			if (results.contains(result)) {
				return "Not jolly";
			}
			results.add(result);
		}
		return "Jolly";
	}
    public static void main(String args[])throws IOException
    {
        //MyScanner2 s1=new MyScanner2();  
        //PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner s1 = new Scanner(System.in);
	String line;
	while(s1.hasNext())
	{
	    line = s1.nextLine();
	    StringTokenizer st = new StringTokenizer(line);
	    int len = Integer.parseInt(st.nextToken());
	    HashSet<Integer> set = new HashSet<>();
	    int arr[] = new int[len];
	    for(int i=0;i<len;i++)
	    {
		arr[i] = Integer.parseInt(st.nextToken());
	    }
	    /*
	    if(len == 1)
	    {
		System.out.println("Jolly");
		continue;
	    }
	    else
	    {
		boolean flag = true;
		for(int i=1;i<len;i++)
		{
		   int diff = Math.abs(arr[i]-arr[i-1]);
		   if(diff == 0 || diff >= len || set.contains(diff))
		   {
		       System.out.println("Not Jolly");
		       flag = false;
		       break;
		   }
		   else 
		   {
		       set.add(diff);
		   }
		}
		if(flag)
		    System.out.println("Jolly");
	    }
	    */
	    
	    System.out.println(isJolly(arr));
	    
	}
	s1.close();
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
        