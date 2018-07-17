import java.io.*;
class oregion
{
    public static void main(String args[])
    throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int s,i,j,m,n,p,q,t,u,k=0,r=0,l;
        int sum[][]=new int[20][20];
        do
        {
            do
            {
                System.out.println("Enter no of rows and columns: ");
                m=Integer.parseInt(br.readLine());
                n=Integer.parseInt(br.readLine());
            }while(m<0||m>77||n<0||n>77);
            if(m==0&&n==0)
                break;
            int a[][]=new int[m][n];
            System.out.println("Enter elements:");
            for(i=0;i<m;i++)
            {
                for(j=0;j<n;j++)
                    a[i][j]=Integer.parseInt(br.readLine());
            }
            //initializing array so that if all sums are negetive,we get max of that
            for(j=0;j<20;j++)
                sum[k][j]=-100;
            //finding all possible sums
            p=0;
            q=n;
            t=m;
            u=0;
            r=0;
            while(u<(n-2))
            {
                while(q>(u+2))
                {
                    while(p<(m-2))
                    {
                        while(t>(p+2))
                        {
                            s=0;
                            for(i=p;i<t;i++)
                                for(j=u;j<q;j++)
                                    if(i==p||i==(t-1)||j==u||j==(q-1))
                                        s+=a[i][j];
                            sum[k][r++]=s;
                            t--;
                        }
                        p++;
                        t=m;
                    }
                    q--;
                    p=0;
                    t=m;
                }
                u++;
                q=n;
                t=m;
                p=0;
            }
            k++;
            r=0;
        }while(k<0);
        for(i=0;i<k;i++)
        {
            l=sum[i][0];
            for(j=1;j<20;j++)
            {
                if(l<sum[i][j])
                    l=sum[i][j];
            }
            if(l!=-100)
                System.out.println("\nAns: "+l);
            else
                System.out.println("No possible subgroups");
        }
    }
}

        