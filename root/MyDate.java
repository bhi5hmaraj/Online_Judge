public class MyDate
{
    String year,month,day;
    public MyDate(String year,String month,String day) {
	this.year = year;
	this.month = month;
	this.day = day;
    }
    @Override
    public String toString() {
	return day+"-"+month+"-"+year;
    }
}