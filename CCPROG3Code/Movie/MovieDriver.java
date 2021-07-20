public class MovieDriver{
	public static void main(String[] args){
	int i,j = 0;
	// 1. Declare and instantiate an array of 5 Movie objects called mustWatch
	Movie[] mustWatch = new Movie[5];

	// 2. Instantiate the first Movie object using the following information: title = X-Men , genre = thriller, year = 2000
	mustWatch[0] = new Movie("X-Men","thriller",2000);
	
	//3. Instantiate the second Movie object using the following information: title = Pokemon the movie , genre = kids
	mustWatch[1] = new Movie("Pokemon","kids");

	// 4. Instantiate the third Movie object using the following information: title = Thor , genre = action , actor = Chris Hemsworth
	mustWatch[2] = new Movie("Thor","action","Chris Hemsworth");
	  
	// 5. Instantiate the fourth Movie object using the following information: title = Frozen 2 , year = 2019
	mustWatch[3] = new Movie("Frozen 2",2019);
	  
	// 6. *Display the total number of movies instantiated
	System.out.println("Total Number of Movies: " + Movie.getCount());

	// 7. Display the title, genre, and year of all movies in mustWatch
	for (i = 0; i < mustWatch.length -1; i++)
  			System.out.println(mustWatch[i].toString());

	// 8. Modify genre of first movie in mustWatch to sci-fi
	mustWatch[0].setGenre("sci-fi");
  
	// 9. Modify genre of 4th movie in mustWatch to kids
  	mustWatch[3].setGenre("kids");
	  
	// 10. Modify year released of second movie in mustWatch to 2019
  	mustWatch[1].setYear(2019);

	// 11. Modify year released of third movie in mustWatch to 2011
	mustWatch[2].setYear(2011);

	// 12. Display the title, genre, and year of all movies in mustWatch
	for (i = 0; i < mustWatch.length -1; i++)
  		mustWatch[i].toString();

	// 13. Add Natalie Portman as another actor to the third movie stored in mustWatch
	mustWatch[2].addActor("Natalie Portman");

	// 14. Add the following actors (in sequence) to the second movie stored in mustWatch: Pikachu, Charizard, Squirtle, Ditto, Mewtwo, Psyduck
	mustWatch[1].addActor("Pikachu");
	mustWatch[1].addActor("Charizard");
	mustWatch[1].addActor("Squirtle");
	mustWatch[1].addActor("Ditto");
	mustWatch[1].addActor("Mewtwo");
	mustWatch[1].addActor("Psyduck");

	// 15. Display all actors of the third movie stored in mustWatch
    System.out.print("Actors in the Third Movie: ");
	mustWatch[2].showActor();

	// 16. Display all actors of the second movie stored in mustWatch
	System.out.print("Actors in the Second Movie: ");
	mustWatch[1].showActor();

	// 17. Declare and instantiate another array of at most 3 movies called myRental
	Movie[] myRental= new Movie[3];

	// 18. Rent all movies that are in the genre of kids from mustWatch. These movies should now be associated also to myRental
  	for(i = 0; i < mustWatch.length - 1; i++)
		if (mustWatch[i].getGenre() == "kids")
		{
			mustWatch[i].rent();
			myRental[j] = mustWatch[i];
			j++;
			Movie.addCount();
		}
			
      
	// 19. *Display the total number of movies instantiated
	System.out.println("Total Movies instantiated: " + Movie.getCount());

	// 20. Display the title, genre, and year of all movies in mustWatch 
	for (i = 0; i < mustWatch.length -1; i++)
  	System.out.println(mustWatch[i].toString());

	// 21. Display the title, genre, and year of all movies in myRental
	for (i = 0; i < myRental.length -1; i++)
  		System.out.println(myRental[i].toString());

	// 22. Rent the movie Frozen 2 again and store that as the last element to myRental
	mustWatch[3].rent();
	myRental[j] = mustWatch[i];
	Movie.addCount();

	// 23. Display the number of times the movie stored in the second element of myRental was rented
	System.out.println(myRental[1].toString() + " was rented " + myRental[1].getRent() + " times.");
	// 24. Set myRental to null
	for (i=0; i < myRental.length; i++)
		if(myRental[i] != null)
		{
			Movie.lessCount();
			myRental[i] = null;
		}
	// 25. Delete the movie object with title X-Men. 
	for (i = 0; i < mustWatch.length -1; i++)
	{	
		if (mustWatch[i].getTitle() == "X-Men")
		{
			mustWatch[i] = null;
			// 26. * Update the total number of movies instantiated. Display the total number of movies instantiated
			Movie.lessCount();				
		}	
	}
	System.out.println("Total Movies instantiated: " + Movie.getCount());
	}
}