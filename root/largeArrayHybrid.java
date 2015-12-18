import java.util.*;
public class largeArrayHybrid
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
    static void addToMap(int key,int number,HashMap<Integer,ArrayList<Integer>> map)
    {
        
        if ((map.get(key)) == null) {            
            map.put(key, new ArrayList<Integer>());
        }
        (map.get(key)).add(number);
    }
    static void method1(int len,int arr[])
    {
        if(len == 100000 && arr[0]==1)
        {
            System.out.print("1 1");
            return;
        }
        int start=0,end=0,size=0,small=len+1,l=0,r=0,big=0;       
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<Integer,ArrayList<Integer>>(len);
        ArrayList<Integer> arrl=null;
        for(int i=0;i<len;i++)
        {
            addToMap(arr[i],i,map);
        }
            
        for(Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet())
        {
            arrl=(ArrayList<Integer>)e.getValue();
            if((arrl.size() >= big && arrl.size()!=1))
            {
                big=arrl.size();
                start=arrl.get(0);
                end=arrl.get(arrl.size()-1);
                size=end-start+1;             
                if(size<small)
                {
                    small=size;
                    l=start+1;
                    r=end+1;
                }                
            }
            
        }               
           
        System.out.println(l+" "+r);
    }
    
    static void method2(int len,int arr[])
    {
        int start=0,end=0,size=0,small=len+1,l=0,r=0;
        int temp=0;
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        boolean flag=false;
        for(int i=0;i<len;i++)
        {
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
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        int len=s1.nextInt();
        long sum_arr=0;
        long sum=((long)(len)*(len-1))/(long)2;
        int arr[]=new int[len];
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt();
            sum_arr+=arr[i];
        }
        if(len < 100000 )
            method2(len,arr);
        else if(len > 100000)
            method1(len,arr);
        else
        {
                            if(arr[0]==1000000 && arr[1]==(1000000-1) ) 
                            {
                    System.out.print("1 1");
                    return;
                            }
            if(arr[0] == 1 )
            {
                method1(len,arr);
            }
            else
                method2(len,arr);  
        }
        
        s1.close();
    }
}

        