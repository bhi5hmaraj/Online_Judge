public class Square extends GeometricObject implements Colorable
{
    private int side;
    private double cost;
    public Square(int side,double cost)
    {
	this.side = side;
	this.cost = cost;
    }
    @Override
    public double getArea() {
	return Math.pow(side, 2);
    }
    @Override
    public double getPerimeter() {
	return (double)(4*side);
    }
    @Override
    public double getCost() {
	return cost*getArea();
    }
    public void howToColor()
    {
	System.out.println("Color all four sides of the square");
    }
}