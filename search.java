class search
{
    public static void main(String args[])
    {
        int a[]=new int[10];
        int i,j,key,mid,min,max;
        boolean flag=false;
        for(i=0;i<10;i++)
            a[i]=i;
        key=9;
        min=0;
        max=9;
        while(min<=max)
        {
            mid=min+max/2;
            if(a[mid]==key)
            {
                flag=true;
                break;
            }
            else
            if(a[mid]>key)
                max=mid-1;
            else
                min=mid+1;
        }
        if(flag==true)
            System.out.println("found");
        else
            System.out.println("Not found");
    }
}
