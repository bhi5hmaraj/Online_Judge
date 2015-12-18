import java.util.*;
public class appleTree
{
    static boolean visit[];
    static int move(int start,boolean right,HashMap<Integer,Integer> map,int key[])
    {
        int apples=0;
        boolean r=right;
        int i=start,j;
        try
        {
        outer:
        while(i>=0 && i<key.length)
        {
            if(r == true)
            {
                j=i;
                do
                {
                    j++;
                    if(j>key.length)
                        break outer;
                }while(visit[j] == true);
                visit[j]=true;
                apples+=map.get(key[j]);
                r=false;
            }
            else
            {
                j=i;
                do
                {
                    j--;
                    if(j<0)
                        break outer;
                }while(visit[j] == true);
                visit[j]=true;
                apples+=map.get(key[j]);
                r=true;
            }
            i=j;
        }
        }
        catch(Exception e)
        {}
        finally
        {
        return apples;
        }
    }
                
            
        
        
    public static void main(String args[])
    {
        Scanner s1=new Scanner(System.in);
        int len=s1.nextInt();
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        int arr[]=new int[len+1];
        for(int i=0;i<len;i++)
        {
            arr[i]=s1.nextInt();
            map.put(arr[i],s1.nextInt());
        }
        arr[len]=0;
        Arrays.sort(arr);
        int start=Arrays.binarySearch(arr,0);
        visit=new boolean[len+1];        
        visit[start]=true;
        int a=move(start,true,map,arr);
        visit=new boolean[len+1];
        visit[start]=true;
        int b=move(start,false,map,arr);
        System.out.println(Math.max(a,b));
    }
}