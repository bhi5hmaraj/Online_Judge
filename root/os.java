import java.util.Scanner;
public class os {
	private static Scanner s1;

	public static void main(String[] args) {
		System.out.print(System.getProperty("sun.arch.data.model"));
		s1 = new Scanner("/a/b/c/d");
		s1.useDelimiter("/");
		while(s1.hasNext())
		{
			System.out.println(s1.next());
		}
	}

}
