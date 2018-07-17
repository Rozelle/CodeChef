import java.util.*;
import java.security.*;
import java.math.BigInteger;
public class RSA
{
   public static void main(String args[])
   {
       Scanner sc=new Scanner(System.in);
       int p=BigInteger.probablePrime(8,new Random()).intValue();
       int q=BigInteger.probablePrime(8,new Random()).intValue();
       int n=p*q;
       
       //finding e
       int e=2;
       int z=(p-1)*(q-1);
       while(z%e ==0 && e<z)
            e++;
       
       //calculating d where de mod (p-1)(q-1) = 1
       int d=2;
       while((d*e) % ((p-1)*(q-1)) != 1)
            d++;
       
       //printing all values
       System.out.println("p = "+p+"\nq = "+q);
       System.out.println("Public key : ("+e+" , "+n+")");
       System.out.println("Private key : ("+d+" , "+n+")");
       
       System.out.print("\nEnter message as an integer : ");
       BigInteger pt=BigInteger.valueOf(sc.nextInt());
       System.out.println();
       
       BigInteger ct=pt.pow(e).mod(BigInteger.valueOf(n));
       System.out.println("Cipher text / Encrypted data: "+ct);
       
       System.out.println("Plain text / Decrypted data: "+(ct.pow(d).mod(BigInteger.valueOf(n))));
   }
}
