//make sure to save this as Mini1.java
import java.util.*;
/** This is our first mini activity.
 * @author Nathalie Lim-Cheng
 * @version 1.0
 */


public class Mini1
{

    public static void main(String[] args)
    {
        double num1, num2;
        String str;
        Scanner sc= new Scanner(System.in);
        
        //float num3 = (float)3.14;
        System.out.print("Enter first num: ");
        num1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter second num: ");
        str = sc.nextLine();
        num2 = Double.parseDouble(str);

        System.out.println( num1 + num2);
        System.out.println( "num1 -num2 = " + (num1 -num2));
        System.out.println( "num1 * num2 = " + num1 * num2);
        System.out.println( "num1 / num2 = " + num1 / num2);
        System.out.println( "num1 > num2 = " + (num1 > num2));
        System.out.println( "num1 <= num2 = " + (num1 <= num2));
        System.out.println( "!(num1 == num2) = " + !(num1 == num2));
        sc.close();
    }
}