/** Constructor and Method Class for Object-Oriented Programming activity
 * @author  Marcus Chiam, David Grasparil, Jamuel Kimhoko, Yazle Ligot
 */
public class Contestant {
	private String name, country;
    private String[] talents;
    private int age;
	// initializes the name, country, and age of the participant in the competition, based on the given parameters. This constructor also initializes the array of talents to contain at most 3 Strings
	public Contestant(String n, String c, int a){
		name = n;
		country = c;
		age = a;
		talents = new String[3];
	}
	// initializes the name and country of the participant in the competition, based on the given parameters. This constructor also initializes the array of talents to contain at most 3 Strings and sets the default age of the contestant to 18
    public Contestant(String n, String c){
		name = n;
    	country = c;
		age = 18;
		talents = new String[3];
	}
	// returns the name of the competition participant
    public String getName(){
		return name;
	}
	// returns the country that the participant is representing
    public String getCountry(){
		return country;
	}
	// adds the parameter to the list of talents of the participant, only if the array is not fully filled yet (that is, there is at least 1 String that is not initialized)
    public void addTalent(String t){
		if (talents[talents.length -1] == null)
			talents[talents.length -1] = new String(t);
	}
	//  checks if the parameter matches one of the defined talents of the participant. Note that checking is also done to prevent program crashing, should there be no initialized talents. In which case, the method returns false.
    public boolean canCompete(String t){
		if(talents != null)
		{
			int i;
			for(i = 0; i < talents.length; i++)
				if (talents[i] == t)
					return true;
		}
		
		return false;
    }
	// checks if t matches one of the defined talents of the participant and if participant is at most maxAge. Note that checking is also done to prevent program crashing, should there be no initialized talents. In which case, the method returns false
    public boolean canCompete(String t,int maxAge){
		if(talents != null)
		{
			int i;
			if (age <= maxAge)
        		for(i = 0; i < talents.length; i++)
			    	if (talents[i] == t)
				    	return true;
		}
		return false;
    }
	// returns true if participant is at least equal to minAge
    public boolean canCompete(int minAge){
      if (age >= minAge)
				return true;
		  return false;
    }
    // returns a concatenation of the name, country, and age of the participant
    public String toString(){
		return name + ", " + country + ", " + age;
    }
}