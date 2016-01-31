class floating
{
	public static void main(String[] args) {
		int i = 1<<26 + 1113 ;
		float f = (float)i;
		System.out.println(i);
		System.out.println(Float.toString(f));
	}
}