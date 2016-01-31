import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;



public class facebookTestGen {
    static class FastWriter{
	BufferedWriter writer;
	public FastWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public FastWriter(String file){
	    try
	    {
		writer = new BufferedWriter(new PrintWriter(file));
	    }
	    catch(FileNotFoundException e)
	    {
		e.printStackTrace();
	    }
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
    static final int LIMIT = (int)1e4;
    static final int N_MAX = 2000;
    static final int T_MAX = 50;
    private static void generate(FastWriter out)
    {
	Random rand = new Random();
	//int N = 2 + rand.nextInt(N_MAX);
	int N = N_MAX;
	out.println(N);
	while(N-->0)
	{
	    int x = LIMIT - rand.nextInt((2 * LIMIT) + 1);
	    int y = LIMIT - rand.nextInt((2 * LIMIT) + 1);
	    out.println(x+" "+y);
	}
    }


    public static void main(String[] args) {
	//FastWriter  out = new FastWriter(System.out);
	FastWriter out = new FastWriter("C:\\Users\\bhisR\\Documents\\test_files_dump\\facebook1_in.txt");
	int t = T_MAX;
	out.println(t);
	while(t-->0)
	{
	    generate(out);
	}	
	out.close();
	System.out.println("COMPLETED");
    }
}
