//Edited from PC
//edited in onedrive
public class A {
	int i,j;
A()
{
	i=1;
	j=2;
}
public static void main(String[] args) {
	A obj1=new A();
	A obj2=obj1;
	System.out.println(obj1.equals(obj2));
}
}
