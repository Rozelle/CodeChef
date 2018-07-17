import java.util.*;
public class HammingCode
{
   public static void main(String args[])
   {
       Scanner sc=new Scanner(System.in);
       int i;
       
       int a[]=new int[4];
       System.out.println("Enter the data bits: ");
       for(i=3;i>=0;i--)
            a[i]=sc.nextInt();
       
       int c[]=new int[3];
       c[0]=(a[0]+a[1]+a[2])%2;
       c[1]=(a[1]+a[2]+a[3])%2;
       c[2]=(a[3]+a[0]+a[1])%2;
       
       System.out.println("After Hamming Code, data:");
       for(i=3;i>=0;i--)
            System.out.print(a[i]+" ");
       for(i=2;i>=0;i--)
            System.out.print(c[i]+" ");
       System.out.println();
       
       int r[]=new int[7];
       System.out.println("Enter the data received: ");
       for(i=0;i<7;i++)
            r[i]=sc.nextInt();
            
       int chk[]=new int[3];
       chk[0]=(r[3]+r[1]+r[2]+r[6])%2;
       chk[1]=(r[0]+r[2]+r[1]+r[5])%2;
       chk[2]=(r[0]+r[2]+r[3]+r[4])%2;  
       int sum=(4*chk[2])+(2*chk[1])+(1*chk[0]);
       
       if(sum==0)
       {
           System.out.println("Data received is correct!");
           System.out.print("Data is: ");
       }
       if(sum==1)
       {
           System.out.println("Error check bit 2 is incorrect");
           r[6]=(r[6]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==2)
       {
           System.out.println("Error check bit 1 is incorrect");
           r[5]=(r[5]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==3)
       {
           System.out.println("Error data bit 1 is incorrect");
           r[1]=(r[1]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==4)
       {
           System.out.println("Error check bit 0 is incorrect");
           r[4]=(r[4]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==5)
       {
           System.out.println("Error data bit 3 is incorrect");
           r[3]=(r[3]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==6)
       {
           System.out.println("Error data bit 0 is incorrect");
           r[0]=(r[0]+1)%2;
           System.out.print("Correct data is: ");
       }
       if(sum==7)
       {
           System.out.println("Error data bit 2 is incorrect");
           r[2]=(r[2]+1)%2;
           System.out.print("Correct data is: ");
       }
       for(i=0;i<7;i++)
                System.out.print(r[i]+" ");
   }
}
