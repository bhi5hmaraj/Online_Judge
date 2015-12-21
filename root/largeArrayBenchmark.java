import java.io.*;
import java.util.*;

public class largeArrayBenchmark  {
    public static void main(String []args) throws IOException {
	InputReader      in  = new InputReader(System.in);
	OutputWriter out = new OutputWriter(System.out);
	solve(in, out);
	out.close();
    }
    
    static void addToMap(int key,int number,HashMap<Integer,ArrayList<Integer>> map)
    {
        
        if ((map.get(key)) == null) {            
            map.put(key, new ArrayList<Integer>());
        }
        (map.get(key)).add(number);
    }
    
    private static void solve(InputReader s1, OutputWriter out){
	
	int len=s1.readInt();
        int arr[]=new int[len];
        int start=0,end=0,size=0,small=len+1,l=0,r=0,big=0;       
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>(len);
        ArrayList<Integer> arrl=null;
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.readInt();
            addToMap(arr[i],i,map);
        }
           ArrayList<ArrayList<Integer>> cand=new ArrayList<ArrayList<Integer>>(); 
           int temp_big=0;
        for(Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet())
        {
            arrl=(ArrayList<Integer>)e.getValue();
            temp_big=arrl.size();
            if((temp_big >= big))
            {
                if(temp_big > big )
                {
                    cand.clear();
                }
                cand.add(arrl);
                big=arrl.size();
            }
               }
        if((cand.get(0)).size() == 1)
            out.print("1 1");
        else
        {
            for(ArrayList<Integer> arl:cand)
            {
                start=arl.get(0);
                end=arl.get(arl.size()-1);
                size=end-start+1;             
                if(size<small)
                {
                    small=size;
                    l=start+1;
                    r=end+1;
                }  
            }
            out.print(l);out.print(" ");out.print(r);
        }
    }

    static class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;

	public InputReader(InputStream stream) {
	    this.stream = stream;
	}

	public int read() {
	    if(numChars == -1)
		throw new InputMismatchException();
	    if(curChar >= numChars) {
		curChar = 0;
		try {
		    numChars = stream.read(buf);
		} catch(IOException e) {
		    throw new InputMismatchException();
		}
		if(numChars <= 0)
		    return -1;
	    }
	    return buf[curChar++];
	}

	public int readInt() {
	    int c = read();
	    while(isSpaceChar(c))
		c = read();
	    int sgn = 1;
	    if(c == '-') {
		sgn = -1;
		c = read();
	    }
	    int res = 0;
	    do {
		if(c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = read();
	    } while(!isSpaceChar(c));
	    return res * sgn;
	}

	public String readString() {
	    int c = read();
	    while(isSpaceChar(c))
		c = read();
	    StringBuilder res = new StringBuilder();
	    do {
		if(Character.isValidCodePoint(c))
		    res.appendCodePoint(c);
		c = read();
	    } while(!isSpaceChar(c));
	    return res.toString();
	}

	public boolean isSpaceChar(int c) {
	    if(filter != null)
		return filter.isSpaceChar(c);
	    return isWhitespace(c);
	}

	public static boolean isWhitespace(int c) {
	    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
	    return readString();
	}

	public interface SpaceCharFilter {
	    public boolean isSpaceChar(int ch);

	}

    }
    static class OutputWriter{
	BufferedWriter writer;
	public OutputWriter(OutputStream stream){
	    writer = new BufferedWriter(new OutputStreamWriter(stream));
	}
	public void print(int i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(long i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(double i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(boolean i) {
	    try{writer.write(String.valueOf(i));} catch(IOException e){e.printStackTrace();}
	}
	public void print(char i) {
	    try{writer.write(i);} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o){
	    try{writer.write(o.toString());} catch(IOException e){e.printStackTrace();}
	}
	public void print(Object o[]){
	    try{writer.write(Arrays.deepToString(o));} catch(IOException e){e.printStackTrace();}
	}
	public void print(String s){
	    try{writer.write(s);} catch(IOException e){e.printStackTrace();}
	}
	public void println(){
	    try{writer.write('\n');} catch(IOException e){e.printStackTrace();}
	}
	public void print(char []c){
	    try{writer.write(c);} catch(IOException e){e.printStackTrace();}
	}
	public void close(){
	    try{writer.close();} catch(IOException e){e.printStackTrace();}
	}
    }
}