import java.util.*;
import java.io.*;
class CHEFKLCS
{

    static int arr[][];
    static void lcs(String s1, String s2) {
	for (int i = 1; i <= s1.length(); i++) {
	    for (int j = 1; j <= s2.length(); j++) {
		if (s1.charAt(i - 1) == s2.charAt(j - 1))
		    arr[i][j] = arr[i - 1][j - 1] + 1;
		else
		    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
	    }
	}
    }

    static Set<String> lcs(String s1, String s2, int len1, int len2) {
	if (len1 == 0 || len2 == 0) {
	    Set<String> set = new TreeSet<String>();
	    set.add("");
	    return set;
	}
	if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
	    Set<String> set = lcs(s1, s2, len1 - 1, len2 - 1);
	    Set<String> set1 = new TreeSet<>();
	    for (String temp : set) {
		temp = temp + s1.charAt(len1 - 1);
		set1.add(temp);
	    }
	    return set1;
	} else {
	    Set<String> set = new TreeSet<>();
	    Set<String> set1 = new TreeSet<>();
	    if (arr[len1 - 1][len2] >= arr[len1][len2 - 1]) {
		set = lcs(s1, s2, len1 - 1, len2);
	    }
	    if (arr[len1][len2 - 1] >= arr[len1 - 1][len2]) {
		set1 = lcs(s1, s2, len1, len2 - 1);
	    }
	    for (String temp : set) {
		set1.add(temp);
	    }
	    //System.out.println("In lcs" + set1);
	    return set1;

	}
    }



    public static void main(String args[])
    {
	MyScanner2 s1=new MyScanner2();  
	PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);  //Close the output stream after use
	StringBuilder sb=new StringBuilder();
	int len = s1.nextInt();
	int k = s1.nextInt();
	String str1 = s1.next();
	String str2 = s1.next();

	arr = new int[len + 1][len + 1];
	lcs(str1, str2);
	Set<String> st = lcs(str1, str2, len, len);
	if(st.size() < k)
	    sb.append("-1\n");
	else
	{
	    String arr[] = new String[st.size()];
	    int i=0;
	    for(String s:st)
		arr[i++] = s;
	    sb.append(arr[k-1]+"\n");
	}        
	out.println(sb);
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
