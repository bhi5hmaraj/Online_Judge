public class rectangle extends GeometricObject
{
    private int length,breath;
    private double cost;
    public rectangle(int l,int b,double cost) {
	this.length = l;
	this.breath = b;
	this.cost = cost;
    }
    @Override
    public double getArea() {
	return (double)(length*breath);
    }
    @Override
    public double getPerimeter() {
        return (double)(2*(length+breath));
    }
    @Override
    public double getCost() {     
        return cost*getArea();
    }
}