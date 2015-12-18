public class Circle extends GeometricObject
{
    private int radius;
    private double cost;
    Circle(int radius,double cost)
    {
	this.radius = radius;
	this.cost = cost;
    }
    @Override
    public double getArea() {
	return Math.PI*Math.pow(radius, 2);
    }
    @Override
    public double getPerimeter() {
	return 2*Math.PI*radius;
    }
    public double getCost() {
	return cost*getArea();
    }
}