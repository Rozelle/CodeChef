class Point
{
    public int x,y;
    Point()
    {
        x=y=0;
    }
    Point(int a,int b)
    {
        x=a;
        y=b;
    }

    //returns false if polygon is concave and true if it is convex
    boolean isConvex(Point points[],int n)
    {
        boolean negetive = false;
        boolean positive = false;
        int a,b,c;
        float crossProduct;
        for(a=0;a<n;a++)
        {
            b=(a+1)%n;
            c=(b+1)%n;
            crossProduct=getCrossProduct(points[a],points[b],points[c]);
            if(crossProduct<0)
                negetive=true;
            else if(crossProduct>0)
                positive=true;
            if(negetive && positive)
                return false;
        }
        return true;
    }
    public float getCrossProduct(Point a,Point b,Point c)
    {
        float BAx = a.x-b.x;
        float BAy = a.y-b.y;
        float BCx = c.x-b.x;
        float BCy = c.y-b.y;
        // Calculate the Z coordinate of the cross product.
        return (BAx * BCy - BAy * BCx);
    }
    
    //returns true if points of the polygon are linear else returns false
    public boolean isLinear(Point points[], int n)
    {
        Point a,b,c;
        int i,j,k;
        for(i=0;i<n;i++)
        {
            j=(i+1)%n;
            k=(j+1)%n;
            a=points[i];
            b=points[j];
            c=points[k];
            if(((a.y-b.y)*(a.x-c.x))!=((a.y-c.y)*(a.x-b.x)))
                return false;
        }
        return true;
    }
}