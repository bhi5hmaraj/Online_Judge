import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class NextRound
{
    public static void main(String args[])
    {
        MyScanner2 stdin=new MyScanner2();
        int len=stdin.nextInt();
        int k=stdin.nextInt();
        int arr[]=new int[len];
        int qualify=k;
        int index=k-1;
        for(int i=0;i<len;i++)
        {
            arr[i]=stdin.nextInt();
        }
            if((index < len-1) && (arr[index] > 0))
            {
            if(  (arr[index+1] == arr[index]) ) 
            {
                    for(int i=index+1;i<len;i++)
                    {
                        if(arr[i] == arr[index])
                        qualify++;
                        else
                        break;
                    }
            }                
            }
        else
        {
            if(arr[index] == 0)
            {
            for(int i=index;i>=0;i--)
            {
                if(arr[i] == 0)
                qualify--;
                else
                break;
            }
            }
        }
        
        System.out.println(qualify);
        
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