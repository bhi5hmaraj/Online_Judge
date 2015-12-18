
public class prog18_pattern {
	public static void main(String[] args) {
		int space=9;
		int col=1;
		int curr=0;
		for(int i=1;i<=10;i++)
		{
			for(int s=1;s<=space;s++)
				System.out.print(" ");
			for(int j=1;j<=col;j++)
			{
				if(j>((col/2)+1))
				{
					curr=(curr-1);
				}
				else
				{
					curr=(curr+1);					
				}
				System.out.print(curr%10);
			}
			col+=2;
			space--;
			System.out.println();
		}
		
	
}
}
