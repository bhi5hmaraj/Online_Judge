public class Student extends Person
{
    final String status;
    public Student(String n,String add,String no,String em,String status)
    {
	super(n,add,no,em);
	this.status = status;
    }    
    @Override
    public String toString() {
	return super.toString()+" Status: "+status;
    }
}