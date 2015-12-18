import java.util.Arrays;
import java.util.Date;
import java.util.Random;

class NGL5_test
{
    public static Object max(Comparable arr[])
    {
	if(arr.length == 0)
	    throw new ArrayIndexOutOfBoundsException();
	else
	{
	    Comparable big = arr[0];
	    for(Comparable curr:arr)
	    {
		if(curr.compareTo(big) > 0)
		    big = curr;
	    }
	    return (Object)big;
	}
    }
    
    private static int rand(int start,int end)
    {
	Random rand = new Random();
	return start+rand.nextInt(end-start+1);
    }
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
	GeometricObject arr[] = new GeometricObject[5];
	arr[0] = new Circle(10,1.25);
	arr[1] = new Square(5, 1.2);
	arr[2] = new Square(10,0.25);
	arr[3] = new rectangle(5, 3, 10);
	arr[4] = new Circle(2,5);
	System.out.println("Printing all the objects that can be colored");
	for(GeometricObject obj:arr)
	{
	    if(obj instanceof Colorable)
		((Colorable) obj).howToColor();
	}
	Integer intArr[] = new Integer[10];
	for(int i=0;i<10;i++)
	    intArr[i] = i+1;
	System.out.println("Biggest of the int array="+max(intArr));
	Date dateArr[] =new Date[10];
	for(int i=0;i<10;i++)
	{
	    int year = rand(1900,2015)-1900;
	    dateArr[i] = new Date(year,rand(0,11),rand(1,28));
	}
	System.out.println("Largest date="+max(dateArr));
    }
}