public class Employee extends Person
{
    String office,salary;
    MyDate date;
    public Employee(String n,String add,String no,String em,String office,String salary,MyDate date)
    {
	super(n,add,no,em);
	this.office = office;
	this.salary = salary;
	this.date = date;
    }
    @Override
    public String toString() {
	return super.toString()+" Office: "+office+" Salary: "+salary+"\nDate: "+date.toString();
    }
}