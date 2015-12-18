import java.util.*;
class FRGTNLNG {
public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int t=s1.nextInt();
	StringBuffer sb=new StringBuffer();
	for(int z=1;z<=t;z++)
	{
		int N=s1.nextInt();
		String extinct[]=new String[N];
		int num_phrase=s1.nextInt();
		ArrayList<String> current=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
			extinct[i]=s1.next();
		}
		for(int j=1;j<=num_phrase;j++)
		{
			int temp=s1.nextInt();
			for(int k=1;k<=temp;k++)
				current.add(s1.next());
		}
		Collections.sort(current);
		for(int i=0;i<N;i++)
		{
			if(Collections.binarySearch(current, extinct[i]) >= 0)
				sb.append("YES ");
			else
				sb.append("NO ");				
		}
		sb.append("\n");
	}
	System.out.println(sb);
	s1.close();
}
}
