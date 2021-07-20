/** The class Movie represents a movie in an online setting.(ex. iTunes)
 * 
 * 	@author David Nikolai Grasparil
 * 	@author Jamuel Erwin Kimhoko
 * 	@author Marcus Ivan Chiam
 * 	@author Yazle Sean Ligot
*/

public class Movie {
	private final String TITLE;
	private String genre;
	private int year;
	private String[] actor;
	private int rented = 0;
	private static int count = 0;
	
    /** This constructor initializes the title, genre, and year released of the movie, based on the given parameters. This constructor also increments the count attribute of the object Movie.
  
	    @param t title of the Movie       
	    @param g genre of the movie       
	    @param y year that the movie was released   
	*/
	public Movie(String t, String g, int y)
	{
		this(t, g);
		year = y; 
	}

	/** This constructor initializes the title and genre of the movie, based on the given parameters. This constructor also increments the count attribute of the object Movie.
  
        @param t title of the Movie       
        @param g genre of the movie       
	*/
	public Movie(String t, String g)
	{
		TITLE = t;
		genre = g; // validate
		addCount();
		actor = new String[5];
		rented = 0;
	}

	/** This constructor initializes the title and genre of the movie, based on the given parameters. This constructor also initializes the array of actors to contain at most 5 strings.
  	
        @param t title of the Movie       
        @param g genre of the movie 
	    @param a actor in the movie
	*/
	public Movie(String t, String g, String a)
	{
		this(t, g);
		actor[0] = a;
	}

	/** This constructor initializes the movie's title and year it was released, based on the given parameters. This constructor also increments the count attribute of the object Movie.         

        @param t title of the Movie       
        @param y year of the movie 
	*/
	public Movie(String t, int y)
	{
		TITLE = t;
		year = y;
		addCount();
		rented = 0;
		actor = new String[5];

	}
	
	/** This method sets the year of the movie object to the year provided
  
	    @param y year of the movie

	*/
	public void setYear(int y)
	{
    	this.year = y;
	}

	/**  This method validates if the given genre matches any one in the list: 
		 drama, horror, comedy, biography, sci-fi, action, romance, and kids
  
	  @param g genre of the movie.
	  @return true if genre is in the list, false if otherwise.

	*/
	public boolean validateGenre(String g)
	{
		int i;
		String Valid[] = {"drama", "horror", "comedy", "biography", "sci-fi", "action", "romance", "kids"};

		for(i = 0; i < Valid.length; i++)
			if(Valid[i].compareToIgnoreCase(g) == 0)
				return true;
		return false;
	}

	/** The method sets the genre of the movie object to the genre provided, if the given genre is invalid, the default assigned is comedy.
  
	  @param g genre of the movie

	*/
	public void setGenre(String g)
	{
		/*
		The following are the only valid genres: drama, horror, comedy, biography, sci-fi, action, romance, and kids. 
		if the given genre is invalid, the default assigned is comedy. 
		The genre can still be updated later, if wanted.  
		However, if the genre to be assigned is invalid, the last valid genre assigned to the same movie will be retained. 
		*/
		if(validateGenre(g)) // validated
			genre = g;		
    		
		
	}
	
	/** This method adds an actor to the array. Adding an actor will fail if the array is full. 
	    @param a actor in the movie
	*/
	public void addActor(String a)
	{
    	int i;
		for (i = actor.length -1; i >= 0; i--)   
			if (actor[i] != null)   
				break;       
		
		if (i < actor.length -1)
			actor[i+1] = a;
	}

	/** This method increments the count for the number of times a movie is rented.
	*/
	public void rent()
	{
		rented++;
	}
	
	/** This method returns true if the movie is rented at least 10,000 times and false if otherwise.
  
    	@return true if rented is at least 10000, false if rented is less than 10000
	*/
	public boolean isBlockbuster()
	{
    	if(rented >= 10000)
        	return true;
      	return false;
	}
	
	/** The method returns the amount of time the movie is rented.

        @return number of times the Movie provided was rented
    */
	public int getRent()
	{
		return rented;
	}
	
	/** The method returns the Genre of the movie.

	    @return Genre of the Movie provided
	*/
	public String getGenre()
	{
        return genre;
	}
	
	/** This method returns the Year when the Movie was released.

	    @return Year when the Movie was released
	*/
	public int getYear()
	{
    return year;
	}

   /** This method returns the title of the Movie. 

	    @return title of the Movie 
	*/
	public String getTitle()
	{
		return TITLE;
	}
	
	/** This method returns the list of actors in the movie in the form of an array.

	    @return array of actors in the movie
	*/
	public String[] getActor()
	{
		return actor;
	}

	/** This method shows the list of actors in the movie in the form of an array. */
	public void showActor()
	{
		int i=0;
		String toShow[] = getActor();
		while(i < toShow.length -1 && toShow[i + 1] != null)
		{
			System.out.print(toShow[i] + ", ");
      		i++;
		}
		System.out.println(toShow[i]);

	}

	/** This method returns the number of movies instantiated.

	    @return number of movies instantiated
	*/
	public static int getCount()
	{
		return count;
	}

	/** This method returns a concatenation of the movie's title, genre and year.

	    @return a concatenation of this format "title, genre, year" of a movie
	*/
	public String toString()
	{
        return TITLE + ", " + genre + ", " + year;
	}

	/** This method returns the result of comparing the current movie's and the parameter's title, genre, and year released.
  
		@param obj Movie object to compare to.
		@return true if the current movie and parameter's title, genre, and year released is the same, false if otherwise.
	*/
	public boolean equals(Object obj)
	{
    	Movie movie = (Movie) obj;
    	if(movie == null)
      		return false;
    	return movie.TITLE == TITLE && movie.getGenre() == genre && movie.getYear() == year;
	}
  
	/** This method decrements the total number of movie objects when a movie is deleted. */
	public static void lessCount()
	{
		count --;
	}
  
	/** This method increments the total number of movie objects when a movie is added. */
	public static void addCount()
	{
		count ++;
	}	
}