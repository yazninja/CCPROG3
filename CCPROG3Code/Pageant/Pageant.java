import java.util.Scanner;
/** Driver program for Object-Oriented Programming activity
 * @author  Marcus Chiam, David Grasparil, Jamuel Kimhoko, Yazle Ligot
 */
public class Pageant {
	public static void main(String[] args) {
		  
		// Declare and instantiate an array of 5 Contestant objects.
		Contestant[] contestants = new Contestant[5];
		Scanner sc = new Scanner(System.in);
    
		//Using a loop, ask user to input name, country, and age of beauty queen contestants. Use these information to instantiate your array.
  		for(int i = 0; i < contestants.length; i++)
		{
			System.out.println("Input the name, country, and age of Contestant " + (i + 1) + ": ");
    		contestants[i] = new Contestant(sc.nextLine(), sc.nextLine(), sc.nextInt());
			sc.nextLine();
  		}
    
  		//Ask user to input 2 talents and add these as talents of the first constestant object.
  		System.out.println("Input first talent: ");
  		contestants[0].addTalent(sc.nextLine());

  		System.out.println("Input second talent: ");
 		contestants[0].addTalent(sc.nextLine());

  		//Write code to check if first contestant can compete in "singing"
  		if (contestants[0].canCompete("singing"))
      	{
      	//Write code to display the result of checking if first contestant is qualified to compete in "singing" The result is true only if the first contestant is at least (not at most) 25 years old.
	  		if (contestants[0].canCompete(25))
      			System.out.println(contestants[0].getName() + " is qualified for singing");
	      	else
        		System.out.println(contestants[0].getName() + " is not qualified for singing");
      	}
	  	else
 			  System.out.println(contestants[0].getName() + " is not qualified for singing");
      
    sc.close();
  }
}