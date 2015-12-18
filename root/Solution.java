import java.util.*;
public class Solution {
    
    
    private static String filter(String str)
    {
	HashSet<Character> filter = new HashSet<>();
	StringBuilder sb = new StringBuilder();
	for(char c:str.toCharArray())
	{
	    if(!filter.contains(c))
	    {
		filter.add(c);
		sb.append(c);		
	    }
	}
	return sb.toString();
    }
    public static <Key> void frequency(HashMap<Key , java.lang.Integer> mp , Key k)
    {
    	//Finds frequency of of each element of generic type Key
    	Integer query = mp.get(k);
    	if(query == null)
    		mp.put(k, new Integer(1));
    	else
    	{
    		mp.put(k, query + 1);
    	}
    }
    public static void main(String[] args) {
        Scanner s1= new Scanner(System.in);
        int len = s1.nextInt();
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int i=1;i<=len;i++)
        {
            String curr = s1.next();
            curr = filter(curr);
            for(char c:curr.toCharArray())
        	frequency(freq, c);
        }
        int ct =0;
        for(Map.Entry<Character, Integer> e:freq.entrySet())
        {
            if(e.getValue() == len)
        	ct++;
        }
        System.out.println(ct);
        s1.close();
    }
}