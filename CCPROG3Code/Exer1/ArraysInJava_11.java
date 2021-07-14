import java.util.Scanner;
/** Displays the ages of humans and their dogs using 2-dimensional ragged array
 * of integers
 * @author  Marcus Chiam, David Grasparil, Jamuel Kimhoko, Yazle Ligot
 * @param   nHuman  number of Humans to display, controls the column size of int[][] age
 * @param   nDogs   number of Dogs to Display
 * @param   tempAge temporary variable to hold the ages of Humans/Dogs 
 */
public class ArraysInJava_11 {
    public static void main(String[] args)
    {
        int nHuman, i, nDogs,j, tempAge;
        Scanner sc = new Scanner(System.in);

        System.out.print("Number of Humans: ");
        nHuman = sc.nextInt();
        /* first column is the age of the human owner, 
        the second until the nth column are the ages (in human years) of the 
        different dog pets of the human owner.
        */
        int[][] age = new int[nHuman][];
        for (i=0; i < age.length; i++)
        {
            // Header
            System.out.println("--------------------------------------------");
            System.out.println("HUMAN " + (i+1));
            System.out.println("--------------------------------------------");
            // Input
            System.out.print("Age of Human " + (i+1) + ": ");
            tempAge = sc.nextInt();
            System.out.print("Number of Dogs: ");
            nDogs = sc.nextInt();
            age[i] = new int [nDogs + 1]; // crate array
            age[i][0] = tempAge; // asign first column to human age
            
            for (j=1; j < age[i].length; j++)
            {
                System.out.print("Age of Dog " + j + " of Human " + (i+1) + ": ");
                tempAge = sc.nextInt();
                age[i][j] = (int) Math.ceil(16 * Math.log(tempAge) + 31);
                /*
                Math.ceil = always rounds UP the double
                Math.log = returns natural log of a number
                formula = 16*ln(age of dog) + 31
                */ 
            }
        }
        sc.close();
        System.out.println("--------------------------------------------");
        System.out.println();
        // Display Result
        for(i=0; i < age.length; i++)
        {
            System.out.println("Human " + (i+1) + ", age" + age[i][0]);
            for (j=1; j < age[i].length; j++)
            {
                System.out.print("\u0009"); //tab
                if(age[i][0] < age [i][j])
                    System.out.print("< ");
                else if (age[i][0] == age [i][j])
                    System.out.print("= ");
                else
                    System.out.print("> ");
                System.out.println(age[i][j]);
            }
            System.out.println();
        }
    }
}