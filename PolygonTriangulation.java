import java.util.*;
class PolygonTriangulation
{
    Point points[];
    int n;
    public void input()
    {
        Scanner sc=new Scanner(System.in);
        
        //user inputs number of points in the polygon
        System.out.print("Enter no of vertices of the polygon : ");
        n=sc.nextInt();
        System.out.println();
        
        //user inputs the x and y co-ordinates of the points
        points=new Point[n];
        int x,y;
        System.out.println("Enter x and y co-ordinates of the points in cyclic order");
        for(int i=0;i<n;i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            points[i]=new Point(x,y);
        }
        
        //checking input
        boolean flag1=new Point().isConvex(points,n);
        boolean flag2=new Point().isLinear(points,n);
        if(flag1==false)
        {
            System.out.println("The polygon entered in concave. Thus triangulation cannot be done!");
            return;
        }
        else
        if(flag2==true)
        {
            System.out.println("All points of polygon entered are linear. Thus triangulation cannot be done!");
            return;
        }
        else
            minTriangulationCost();
    }
    
    // A utility function to find distance between two points in a plane
    public double dist(Point p1, Point p2)
    {
        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }

    // A utility function to find cost of a triangle. The perimeter is considered as cost of the triangle
    public double cost(int i, int j, int k)
    {
        Point p1 = points[i], p2 = points[j], p3 = points[k];
        return dist(p1, p2) + dist(p2, p3) + dist(p3, p1);
    }
    
    // Main logic of dynamic programming
    public void minTriangulationCost()
    {
        Scanner sc=new Scanner(System.in);
        if(n<3)
        {
            System.out.println("The polygon should have atleast 3 sides, else triangulation cannot be done!");
            return;
        }
        
        // Table to store results of subproblems is table[][]
        // table[i][j] stores cost of triangulation of polygon with vertices/points from Pi to Pj.
        // The entry table[0][n-1] stores the final result.
        double table[][]=new double[n][n];
        // table filled using recursive formula in diagonal fashion
        // region above the diagonal is only filled and the lower region is empty
        int index[][]=new int[n][n];
        for(int gap = 0; gap < n; gap++)
        {
            //this loop keeps track of the no of columns to left empty in every row,
            // since we are only fillinng the upper triangle of the matrix
            for(int i=0, j=gap; j<n; j++)
            {
                //since atleast 3 points are needed to form a triangle
                if(j < i+2 )
                    table[i][j] = 0.0;
                else
                {
                    table[i][j] = 1000000.0;//max value
                    for(int k=i+1;k<j;k++)
                    {
                        double val = table[i][k] + table[k][j] + cost(i,j,k);
                        if(val < table[i][j] )
                        {
                            table[i][j]=val;      
                            index[i][j]=k;
                        }
                    }
                }
            }
        }
        
        //printing result
        System.out.println("\n\nMinimum cost of triangulation of the polygon is : "+table[0][n-1]);
        System.out.println("Triangles formed are:");
        printTriangles(0,n-1,1,index);
    }
    public void printTriangles(int i,int j,int count,int index[][])
    {
        if(j<i+2 || count>n-2)
            return;
        else
        {
            int k=index[i][j];
            System.out.println("V"+i+" V"+k+" V"+j);
            printTriangles(i,k,count++,index);
            printTriangles((k+1)%n,j,count++,index);
        }
    }
    public static void main(String args[])
    {
        System.out.println("Program to find minimum cost of triangulation of polygon using dynamic programing");
        new PolygonTriangulation().input();
        System.out.println("\n\n-Riya Gupta\n-Rozelle Jain\n-Amrutha Srinivasan\n-Udit Shyam Padhi");
    }
}