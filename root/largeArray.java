import java.util.*;
public class largeArray
{
    public static Integer[] groups(int array[],int len)
    {
        int arr[]=new int[len];
        ArrayList<Integer> arrl=new ArrayList<Integer>();
        arr=array.clone();
        Arrays.sort(arr);
        int ct=1,big=0;
        int temp=arr[0];
        for(int i=1;i<len;i++)
        {
            if(temp == arr[i])
            {
                ct++;
            }
            else
            {
                if(ct > big)
                {
                    big=ct;
                    arrl.clear();
                    arrl.add(temp);
                    ct=1;
                }
                if(ct == big)
                {
                    arrl.add(temp);
                }
                ct=1;
            }
            temp=arr[i];
        }
                if(ct > big)
                {
                    big=ct;
                    arrl.clear();
                    arrl.add(temp);
                    ct=1;
                }
                if(ct == big)
                {
                    arrl.add(temp);
                }
                Integer tem[]=arrl.toArray(new Integer[arrl.size()]);                
                return tem;
    }
    
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        int len=s1.nextInt();
        
        int arr[]=new int[len];
        int start=0,end=0,size=0,small=len+1,l=0,r=0;
        int temp=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        boolean flag=false;
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt();
            if(map.get(arr[i]) == null)
            {
                map.put(arr[i],i);
            }
        }
                
        int search;
        Integer arrl[]=groups(arr,len);
        for(int j=0;j<arrl.length;j++)          
        {
            search=arrl[j];
            start=0;
            end=0;
            size=0;
            flag=false;
            for(int i=map.get(search);i<len;i++)
            {
                if(arr[i] == search)
                {
                    if(flag == false)
                    {
                        start=i;
                        flag=true;
                    }
                    end=i;
                }
            }
            size=end-start+1;
            if(size<=small)
            {
                small=size;
                l=start+1;
                r=end+1;
            }
        }
        System.out.println(l+" "+r);
        
    }
}
        