public class Staff extends Employee
{
    String title;
    public Staff(String n,String add,String no,String em,String office,String salary,MyDate date,String title)
    {
	super(n,add,no,em,office,salary,date);
	this.title = title;
    }
    @Override
    public String toString() {
	return super.toString()+" Title: "+title;
    }
}