
public class prog2_ascii {
	public static void main(String[] args) {
		//System.out.println("Chatacter   Value");
		for(int i=1;i<=127;i++)
		{
				System.out.print((char)(i)+" - "+i+"       ");
				if(i%7==0)
					System.out.println();
		}
	}
}
