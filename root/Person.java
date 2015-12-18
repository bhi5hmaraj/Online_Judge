public class Person
{
   String name,address,number,email;
   public Person(String n,String add,String no,String em) {
    name = n;
    address = add;
    number = no;
    email = em;
}
   @Override
    public String toString() {
       return "Name:"+name+" Address: "+address+" Number: "+number+" Email: "+email;
    }
}