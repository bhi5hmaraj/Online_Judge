import java.util.*;
import java.io.*;
public class GraphandString
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB

	private static void solve(FastScanner s1, FastWriter out){

		int V = s1.nextInt();
		int E = s1.nextInt();
		if(E == 0)
		{
			if(V == 1 || V == 2)
			{
				out.println("Yes");
				out.print((V==1)?"a":"ac");
			}
			else
				out.print("No");
			return;

		}
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[V+1];	
		for(int i=1;i<=V;i++)
			adj[i] = new ArrayList<>();
		for(int i=1;i<=E;i++)
		{
			int u = s1.nextInt();
			int v = s1.nextInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		HashSet<Integer> A = new HashSet<>();
		HashSet<Integer> B = new HashSet<>();
		HashSet<Integer> C = new HashSet<>();
		for(int i=1;i<=V;i++)       //Adding B
		{
			if(adj[i].size() == V-1)
				B.add(i);
		}
		for(int i=1;i<=V;i++)		//Adding A
		{
			if(!B.contains(i))			
			{
				A.add(i);
				for(int v:adj[i])
					if(!B.contains(v))
						A.add(v);

				break;
			}
		}
		for(int i=1;i<=V;i++)      //Adding C
		{
			if(!A.contains(i) && !B.contains(i))
				C.add(i);
		}
		/*
		out.println("A "+A);
		out.println("B "+B);
		out.println("C "+C);
		System.out.println(Arrays.toString(adj));
		*/
		int sA = A.size();
		int sB = B.size();
		int sC = C.size();
		for(int a:A)
		{
			int needed = sA + sB - 1;
			for(int v:adj[a])
			{
				if(A.contains(v) || B.contains(v))
					needed--;
				if(C.contains(v))
				{
					out.print("No");
					return;
				}
			}
			if(needed != 0)
			{
				out.print("No");
				return;
			}
		}
		for(int b:B)
		{
			int needed = sA + sB + sC - 1;
			for(int v:adj[b])
			{
				if(A.contains(v) || B.contains(v) || C.contains(v))
					needed--;					
			}
			if(needed != 0)
			{
				out.print("No");
				return;
			}
		}
		for(int c:C)
		{
			int needed = sC + sB - 1;
			for(int v:adj[c])
			{
				if(C.contains(v) || B.contains(v))
					needed--;
				if(A.contains(v))
				{						
					out.print("No");
					return;						
				}
			}
			if(needed != 0)
			{
				out.print("No");
				return;
			}
		}

		out.println("Yes");
		StringBuilder sb = new StringBuilder();
		sb.setLength(V);
		for(int i:A)
			sb.setCharAt(i-1, 'a');
		for(int i:B)
			sb.setCharAt(i-1, 'b');
		for(int i:C)
			sb.setCharAt(i-1, 'c');
		out.print(sb);
	}

	/************************ SOLUTION ENDS HERE ************************/



	/************************ TEMPLATE STARTS HERE ************************/

	public static void main(String []args) throws IOException {
		FastScanner in  = new FastScanner(System.in);
		FastWriter  out = new FastWriter(System.out);
		solve(in, out);
		in.close();
		out.close();
	}    

	static class FastScanner{
		public BufferedReader reader;
		public StringTokenizer st;
		public FastScanner(InputStream stream){
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}
		public String next(){
			while(st == null || !st.hasMoreTokens()){
				try{
					String line = reader.readLine();
					if(line == null) return null;
					st = new StringTokenizer(line);
				}catch (Exception e){
					throw (new RuntimeException());
				}
			}
			return st.nextToken();
		}
		public String nextLine(){
			String str = null;
			try {
				str = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		public int nextInt(){
			return Integer.parseInt(next());
		}
		public long nextLong(){
			return Long.parseLong(next());
		}
		public double nextDouble(){
			return Double.parseDouble(next());
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
		public void close(){	
			try{ reader.close(); } catch(IOException e){e.printStackTrace();}
		}
	}
	static class FastWriter{
		BufferedWriter writer;
		public FastWriter(OutputStream stream){
			writer = new BufferedWriter(new OutputStreamWriter(stream));
		}
		public void print(int i) {
			print(Integer.toString(i));
		}
		public void println(int i) {
			print(Integer.toString(i));
			print('\n');
		}
		public void print(long i) {
			print(Long.toString(i));
		}
		public void println(long i) {
			print(Long.toString(i));
			print('\n');
		}
		public void print(double i) {
			print(Double.toString(i));
		}
		public void print(boolean i) {
			print(Boolean.toString(i));
		}
		public void print(Object o){
			print(o.toString());
		}
		public void println(Object o){
			print(o.toString());
			print('\n');
		}
		public void print(char i) {
			try{writer.write(i);} catch(IOException e){e.printStackTrace();}
		}
		public void print(String s){
			try{writer.write(s);} catch(IOException e){e.printStackTrace();}
		}
		public void println(String s){
			try{writer.write(s);writer.write('\n');} catch(IOException e){e.printStackTrace();}
		}
		public void println(){
			try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
		}
		public void print(int arr[])
		{
			for (int i = 0; i < arr.length; i++) {
				print(arr[i]);
				print(' ');
			}
		}
		public void close(){
			try{writer.close();} catch(IOException e){e.printStackTrace();}
		}
	}

	/************************ TEMPLATE ENDS HERE ************************/
}
