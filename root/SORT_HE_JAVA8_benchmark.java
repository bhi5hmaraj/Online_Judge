import java.util.*;
import java.io.*;

class SORT_HE_JAVA8_benchmark {
	public static void main(String args[]) {
		MyScanner s1 = new MyScanner();
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out),
				true); // Close the output stream after use
		StringBuffer sb = new StringBuffer();
		int t = s1.nextInt();
		for (int z = 1; z <= t; z++) {
			int len = s1.nextInt();
			int arr[] = new int[len];
			for (int i = 0; i < len; i++)
				arr[i] = s1.nextInt();
			arr = Arrays.stream(arr).parallel().sorted().toArray();
			for (int i = len - 1; i >= 0; i--)
				sb.append(arr[i] + " ");
			sb.append("\n");
		}
		out.println(sb);
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

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
