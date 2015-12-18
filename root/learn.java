 class myClass
{
    static void print()
    {
	System.out.println("super class");
    }
}
 class subclass extends myClass
 {
     static void print()
     {
	 System.out.println("sub class");
     }
 }
 
 class learn
 {
     public static void main(String[] args) {
	subclass ob1 = new subclass();
	Double a = 1/0.0;
	Double b = 0.0/1;
	System.out.println("a"+a.hashCode()+"a="+a);
	System.out.println("b"+b.hashCode());
    }
 }