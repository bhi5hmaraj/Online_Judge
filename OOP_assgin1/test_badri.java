
public class test_badri {
public static void main(String[] args) {
	int n=10;
	for(int i=1;i<4*n;i++)
		System.out.printf("%d ",i-((int)(i/n)*(int)(i%n)));
}
}
