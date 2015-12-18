import java.util.*;
import java.io.*;
class Merge
{
	public static int[] merge(int arr1[],int arr2[])
	{
		int arr[] = new int [arr1.length+arr2.length];
		int ptr1=0,ptr2=0;
		for(int i=0;i<arr.length;i++)
		{
			if(ptr1>=arr1.length)
			{
				arr[i] = arr2[ptr2];
				ptr2++;
				continue;
			}
			if(ptr2>=arr2.length)
			{
				arr[i] = arr1[ptr1];
				ptr1++;
				continue;
			}
			if(arr1[ptr1] > arr2[ptr2])
			{
				arr[i] = arr1[ptr1];
				ptr1++;
			}
			else
			{
				arr[i] = arr2[ptr2];
				ptr2++;
			}
		}
		return arr;
	}
	    static  void shuffleArray(int[] array) {
	        Random random = new Random();
	        for (int i = array.length - 1; i > 0; i--) {
	            int index = random.nextInt(i + 1);
	            int temp = array[index];
	            array[index] = array[i];
	            array[i] = temp;
	        }
	    }
    public static void main(String args[])
    {
        MyScanner s1=new MyScanner();  
        PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
        StringBuffer sb=new StringBuffer();
        int t=s1.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int N = s1.nextInt();
        	int M = s1.nextInt();
        	int arr1[] = new int[N];
        	int arr2[] = new int[M];
        	for(int i=0;i<N;i++)
        		arr1[i] = s1.nextInt();
        	for(int i=0;i<M;i++)
        		arr2[i] = s1.nextInt();
        	int arr[] = merge(arr1, arr2);
        	/*
        	int arr[] = new int [N+M];
        	for(int i=0;i<(N+M);i++)
        	{
        		if(i<N)
        			arr[i] = arr1[i];
        		else
        			arr[i] = arr2[i-N];
        	}
        	shuffleArray(arr);
        	Arrays.sort(arr);
        	for(int i=arr.length-1;i>=0;i--)
        		sb.append(arr[i]+" ");
        		*/
        	for(int a :arr)
        	    sb.append(a+" ");
        	sb.append("\n");
        }
        out.println(sb);
        out.close();
    }
    static class MyScanner {
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
}

        