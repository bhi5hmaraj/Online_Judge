import java.util.*;
import java.io.*;
public class uva_10258
{

	/************************ SOLUTION STARTS HERE ************************/

	//DONT FORGET TO COMMIT AND PUSH TO GITHUB
	
	static class Contestant implements Comparable<Contestant>
	{
		boolean isAC[];
		int penalty[];
		int totalPenalty;
		int numOfSolved;
		int id;
		public Contestant(int id) {
			this.id = id;
			isAC = new boolean[11];
			penalty = new int[11];
			totalPenalty = 0;
			numOfSolved = 0;
		}
		@Override
		public int compareTo(Contestant that) {
			if(this.numOfSolved != that.numOfSolved)
				return that.numOfSolved - this.numOfSolved;
			else
			{
				if(this.totalPenalty != that.totalPenalty)
					return this.totalPenalty - that.totalPenalty;
				else
					return this.id - that.id;
			}
		}
	}
	
	private static void solve(FastScanner s1, FastWriter out){

		int t = s1.nextInt();
		s1.nextLine();
		while(t-->0)
		{
			Contestant arr[] = new Contestant[101];
			String in = s1.nextLine();
			while((in != null) && (in.length() != 0))
			{
				in = in.trim();
				Scanner scan = new Scanner(in);
				int id = scan.nextInt();
				int prob = scan.nextInt();
				int time = scan.nextInt();
				char verdict = scan.next().charAt(0);
				scan.close();
				if(arr[id] == null)
					arr[id] = new Contestant(id);
				switch(verdict)
				{
				case 'R':
				case 'U':
				case 'E':
					in = s1.nextLine();
					continue;
				case 'I':
					if(!arr[id].isAC[prob])
					{
						arr[id].penalty[prob] += 20;
					}
					break;
				case 'C':
					if(!arr[id].isAC[prob])
					{
						arr[id].isAC[prob] = true;
						arr[id].numOfSolved++;
						arr[id].totalPenalty += (arr[id].penalty[prob] + time);
						break;
					}
				}
				in = s1.nextLine();
			}
			ArrayList<Contestant> arl = new ArrayList<>();
			for(Contestant con : arr)
				if(con != null)
					arl.add(con);
			
			Collections.sort(arl);
			for(Contestant con:arl)
				out.println(con.id + " " + con.numOfSolved + " " + con.totalPenalty);			
			if(t != 0)
				out.println();
		}

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
