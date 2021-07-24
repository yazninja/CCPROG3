import java.util.Scanner;
public class Driver {

    public static boolean validateAnimal(String a, String b)
    {
        String[] animalList = {"cat", "dog", "elephant", "leopard", "lion", "mouse", "tiger", "wolf"};
        if (!a.equals(b))
            for (int i=0; i < animalList.length; i++)
                if(a.toLowerCase().equals(animalList[i]))
                    return true;

        return false;
    }
    public static int convertNameToInt(String name)
    {
        int toReturn = 0;
        switch(name.toLowerCase())
        {
            case "mouse":       toReturn = 1;   break;
            case "cat":         toReturn = 2;   break;
            case "wolf":        toReturn = 3;   break;
            case "dog":         toReturn = 4;   break;
            case "leopard":     toReturn = 5;   break;
            case "tiger":       toReturn = 6;   break;
            case "lion":        toReturn = 7;   break;
            case "elephant":    toReturn = 8;   break;
        }
        return toReturn;
    }
    public static boolean whoGoesFirst(String a1, String a2)
    {
        int i1 = convertNameToInt(a1);
        int i2 = convertNameToInt(a2);
        boolean toReturn = false;

        if(i1 < i2)
            toReturn = true;
        
        return toReturn;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String animal1, animal2;
        String color1, color2 = "";
        String temp;
        boolean valid = false;
        //int i;

        System.out.println("----ANIMAL CHESS----");
        System.out.println();

        System.out.println("Animal List:");
        System.out.println("[Cat, Dog, Elephant, Leopard, Lion, Mouse, Tiger, Wolf]");
        System.out.println(); 
        do {
            valid = false;
            System.out.print("Choice: ");
            animal1 = sc.nextLine();
            if(validateAnimal(animal1, null))
                valid = true;
            if(!valid)
                System.out.println("Animal is not in the list! Try again");
        } while(!valid);
        System.out.println();
        System.out.println("---Next Player---");
        do {
            valid = false;
            System.out.print("Choice: ");
            animal2 = sc.nextLine();
            if(validateAnimal(animal1, animal2))
                valid = true;
            if(!valid)
                System.out.println("Animal is not in the list! Try again");
        } while(!valid);
        System.out.println();
        if(whoGoesFirst(animal1, animal2))
        {
            temp = animal1;
            animal1 = animal2;
            animal2 = temp;
        }
        
        System.out.println("The Player who picked " + animal1 + " will go first!");
        System.out.println("The Player who picked " + animal2 + " will go second!");
        System.out.println();


        System.out.println("Color List: Choose a color");
        System.out.println("[Red, Blue]");
        System.out.println(); 
        do {
            valid = false;
            System.out.print("Player 1 (" + animal1 + "): ");
            color1 = sc.nextLine().toLowerCase();
            if(color1.equals("red"))
            {
                color2 = "blue";
                valid = true;
            }
            else if(color1.equals("blue"))
            {
                color2 = "red";
                valid = true;
            }

            if(!valid)
                System.out.println("Color is not in the list! Try again");
        } while(!valid);
        System.out.println();

        System.out.println("Player 1 has " + color1 + " pieces!");
        System.out.println("Player 2 has " + color2 + " pieces!");
        System.out.println();
        sc.close();


    }
}
