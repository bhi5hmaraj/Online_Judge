public class Faculty extends Employee
{
    String rank;
    public Faculty(String n,String add,String no,String em,String office,String salary,MyDate date,String rank)
    {
	super(n,add,no,em,office,salary,date);
	this.rank = rank;
    }
    @Override
    public String toString() {
	return super.toString()+" Rank: "+rank;
    }
}
        