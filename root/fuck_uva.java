import java.util.*;
import java.io.*;

public class fuck_uva {
	
	static class MutableInt {
		int val = 1;
		void inc() {
			++val;
		}
		int get() {
			return val;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		in.readLine();
		
		boolean first = true;
		while (T-- > 0) {
			int cnt = 0;
			Map<String, MutableInt> map = new TreeMap<String, MutableInt>();
			
			String tree;
			while ((tree = in.readLine()) != null) {
				if (tree.isEmpty())
					break;
				MutableInt value = map.get(tree);
				if (value == null) {
					value = new MutableInt();
					map.put(tree, value);
				} else {
					value.inc();
				}
				++cnt;
			}
			if (first)
				first = false;
			else
				System.out.println();
			
			for (String t : map.keySet())
				System.out.printf(Locale.ENGLISH, "%s %.4f%n", 
						t, 100 * (double)map.get(t).get() / (double)cnt);
		}
	}
}