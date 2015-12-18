import java.util.Random;
public class prog8_coins {
	public static void main(String[] args) {
		Random rand=new Random();
		int result=0;
		int heads=0,tails=0;
		for(int i=1;i<=(int)1e6;i++)
		{
			result=rand.nextInt(2);
			if(result == 1)
				heads++;
			else
				tails++;
		}
		System.out.println("Number of heads="+heads);		
		System.out.println("Number of Tails="+tails);
	}

}
