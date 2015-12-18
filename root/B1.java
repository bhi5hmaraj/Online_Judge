import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner; import java.util.StringTokenizer;
import java.util.regex.Matcher; import java.util.regex.Pattern;

public class B1 {
public static int pow(int a, int exp)
{
    int result = 1;
    while(exp>0)
    {
       result *= a;
       exp--;
    }
    return result;
}
/*
public static String convert(int num)
{
    int test= 0;

    int n;
    int testcase = 0;
    while(pow(26, test) < num)
    {
       testcase += pow(26,test);
       test++;

    }
    test--;
    StringBuffer result = new StringBuffer();

    //System.out.println("***" + num);
    //System.out.println("***" + test);
    //System.out.println("***" + pow(26,test));
    while(num > 0)
    {
       n = num/pow(26,test);
       //for(int i=0;i<=test;i++)
       //{
       //    testcase += pow(26,i);
       //}
       //System.out.println(testcase);
       if(num < testcase)
       {
         result.append("Z");
         num -= n*pow(26,test);
         testcase -= pow(26,test);
         testcase -= pow(26,test - 1);
         test-=2;
         //System.out.println(test);
         //System.out.println(num);
       }

       else
       {
         if (num%pow(26,test)==0 && test!=0)
         n--;

         result.append((char) ('A' + n - 1));
         //System.out.println(test);
         //System.out.println(num);
         //System.out.println(pow(26,test));
         //System.out.println(num/pow(26,test));
         //System.out.println((char) ('A' + n - 1));
         //System.out.println((char) ('A' + num/pow(26,test) - 1));

         num = num - n*pow(26,test);
         testcase -= pow(26,test);
         //System.out.println(num);
         test--;
       }

    }
    return result.toString();
}
*/
static String convert(int N)
{
	if(N <= 26)
		return String.valueOf(arr[N-1]);
	else
		return convert((N-1)/26) + arr[(N-1)%26];
}
static char arr[] = new char[26];
public static void main(String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // TODO Auto-generated method stub
    //Scanner scan = new Scanner(System.in);
    StringBuffer ans = new StringBuffer();
    char alpha='A';
    for(int i=0;i<26;i++)
    	arr[i]=alpha++;
    int num = Integer.parseInt(br.readLine()); 
    //String[] ans = new String[num];
    for(int j = 0; j < num; j++)
    {
        String str = br.readLine();          
        //StringBuffer temp = new StringBuffer();
        //String test2 ="R85";
        //String test3 ="R85C33";
        //String test4 ="223";
        //System.out.println(testmode);
        //System.out.println(testmode.matches("\\d"));
        //System.out.println(testmode.matches("\\d"));
       // System.out.println(test2.matches("R\\d+C\\d+"));
       // System.out.println(test3.matches("R\\d+C\\d+"));
        //System.out.println(test2.matches("\\D+\\d+"));
        //System.out.println(test3.matches("\\D+\\d+"));
        //System.out.println(test3.matches("\\d"));
        //System.out.println(testmode.matches("\d"));
        if (str.matches("R\\d+C\\d+"))
        {
          int[] abc = new int[2];
          Pattern p = Pattern.compile("\\d+");
          Matcher m = p.matcher(str);
          for (int i = 0; m.find(); i++)
          {
           abc[i] = Integer.parseInt(m.group());
          }
           //System.out.println(Arrays.toString(abc));
           //temp.append(convert(abc[1]));
           //temp.append(abc[0]);
           ans.append(convert(abc[1])+abc[0]+"\n");

        }
        else
        {
          String[] part = str.split("(?<=\\D)(?=\\d)");
          int result = 0;

          for(int i = 0 ; i < part[0].length(); i++)
          {
           result += pow(26, part[0].length() - i - 1) * ((int) (part[0].charAt(i) - 'A' + 1));
          }

          ans.append( "R" + part[1]+"C" + result+"\n");

        }
    }  
System.out.println(ans);

}
}