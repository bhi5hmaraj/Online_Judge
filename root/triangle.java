
class triangle
{
    int a,b,c;
    public triangle(int a,int b,int c)throws IllegalTriangleException 
    {
	if((a+b>=c)&&(b+c>=a)&&(c+a>=b))
	{
	    this.a = a;
	    this.b = b;
	    this.c = c;
	}
	else
	    throw new IllegalTriangleException();
    }
    public static void main(String[] args)throws IllegalTriangleException {
	triangle t = new triangle(1, 1, 10);
    }
}

class IllegalTriangleException extends Exception
{
    public IllegalTriangleException()
    {
	super("A triangle with the specified sides cannot be created");
    }
}