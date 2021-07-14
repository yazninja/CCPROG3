import java.util.*;

public class JustMeNow {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int discount, q;
        double price;
        String name;
        discount = 25;
        System.out.print("Enter Unit Price: ");
        price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter Quantity: ");
        q = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        
        System.out.println();
        System.out.println(q + " " + name + " @ " + price);
        System.out.println("     Less " + discount + "%  =" + (price-(price/discount)));
        System.out.println("Total Due: PhP " + q*(price-(price/discount)));

        sc.close();
    }     
}