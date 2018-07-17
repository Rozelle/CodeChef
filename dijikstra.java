import java.util.*;
public class dijikstra
{
    public static int n,v,cost[][],dist[];
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j;
        
        System.out.print("Enter no of vertices: ");
        n=sc.nextInt();
        
        cost=new int[n][n];
        System.out.println("Enter cost matrix:");
        for(i=0;i<n;i++)
           for(j=0;j<n;j++)
           {
               cost[i][j]=sc.nextInt();
               if(cost[i][j]==0)
                    cost[i][j]=999;
           }
        
        System.out.print("Enter source matrix: ");
        v=sc.nextInt();
        
        dist=new int[n];
        for(i=0;i<n;i++)
            dist[i]=cost[v][i];
        
        dij();
        
        System.out.println("Cost of reaching node "+v+"from");
        for(i=0;i<n;i++)
            if(i!=v)
                System.out.println(i+" is "+dist[i]);
    }
    public static void dij()
    {
        boolean flag[]=new boolean[n];
        int i,min,u;
        for(i=0;i<n;i++)
            flag[i]=false;
        int count=2;
        while(count<=n)
        {
            min=999;
            u=v;
            for(i=0;i<n;i++)
                if(dist[i]<min && flag[i]==false)
                {
                    min=dist[i];
                    u=i;
                }
            flag[u]=true;
            for(i=0;i<n;i++)
                if(dist[i]>dist[u]+cost[i][u] && flag[i]==false)
                    dist[i]=dist[u]+cost[i][u];
            count++;
        }
    }
}
