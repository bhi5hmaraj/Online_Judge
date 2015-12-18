import java.util.ArrayList;
import java.util.Scanner;
class person
{
	String name;
	person()
	{
		name = null;
	}
	person(String name)
	{
		if(name.length() == 1)
			throw new KKException("Enter a valid name ");
		else
			this.name = name;
	}
	String getName()
	{
		return name;
	}
}

class student extends person
{
	int roll, marks;
	int getRoll()
	{
		return roll;
	}
	int getMarks()
	{
		return marks;
	}
}
class faculty extends person
{
	int emp_no;
	int getEmp()
	{
		return emp_no;
	}
}
class Main2
{
public static void main(String[] args){
person arr[] = new person[5];
System.out.println("enter names");
Scanner s1 = new Scanner(System.in);
for(int i=0;i<5;i++)
{
	try
	{
	arr[i]=new person(s1.next());
	}
	catch(KKException e)
	{
		System.out.println("enter string with len > 1");
		continue;
	}
}


}
}

class KKException extends RuntimeException
{

	KKException(String str)
	{
		super(str);
	}
}


interface human
{
	void head();
	
	void spine();
}
interface ape
{
	void apehead();
}
abstract class indian implements human,ape 
{
	public void head()
	{
		System.out.println("indian is a human");
	}
	public void spine()
	{
	}
	
}

class bhishma
{

}
class hari
{
	public static void main(String[] args) {
		bhishma obj = new bhishma();
	}
}