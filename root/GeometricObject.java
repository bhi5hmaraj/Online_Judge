public abstract class GeometricObject implements Comparable<GeometricObject>
{
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract double getCost();
    public double costOfPaintingAShape(GeometricObject g)
    {
	return g.getArea()*g.getCost();
    }
    @Override
    public int compareTo(GeometricObject that) {
	double this_area = this.getArea();
	double that_area = that.getArea();
	if(Math.abs(this_area-that_area) <= 1e-9)
	    return 0;
	else if(this_area > that_area)
	    return 1;
	else 
	    return -1;
    }
    public static GeometricObject max(GeometricObject g1,GeometricObject g2)
    {
	if(g1.compareTo(g2) > 0)
	    return g1;
	else
	    return g2;
    }
    public static void main(String[] args) {
	GeometricObject arr[] = new GeometricObject[4];
	arr[0] = new Circle(4, 2.0);
	arr[1] = new Circle(10, 0.1);
	arr[2] = new rectangle(10, 20, 0.5);
	arr[3] = new rectangle(10, 5, 2.0);
	System.out.println("Cost for painting different shapes");
	for(GeometricObject obj:arr)
	{
	    System.out.printf("Cost = %.2f\n",obj.getCost());
	}
	System.out.println("The big circle has an area = "+max(arr[0],arr[1]).getArea());
	System.out.println("The Big Rectangle has an area = "+max(arr[2],arr[3]).getArea());
    }
}