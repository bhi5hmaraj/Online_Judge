public class NGL4_main
{
    public static void main(String[] args) {
	Person p = new Person("Person1", "No.143,Fifth Avenue", "987654213", "person1@gmail.com");
	Student s = new Student("Student1", "No.512 tenth Avenue", "985476321", "student2@gmail.com", "sophomore");
	Employee e = new Employee("Employee1", "No.255, Avenue", "87456213", "employee2@gmail.com", "Teacher", "30,000", new MyDate("2015", "January", "15"));
	Faculty f = new Faculty("Faculty1", "address 2", "987454321", "faculty1@gmail.com", "Computer Science department", "50,000", new MyDate("2013", "April", "25"), "Assistant Professor");
	Staff sf = new Staff("Staff1", "address2", "988754221", "staff@gmail.com", "Computer Science Department", "40,000", new MyDate("2005", "February", "14"), "Head of Department");
	System.out.println(p+"\n"+s+"\n"+e+"\n"+f+"\n"+sf);
    }
}