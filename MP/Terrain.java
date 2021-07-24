/** The class initializes the tile used in Board with their respective coordinates and classification.
 * 
 * 	@author David Nikolai Grasparil
 * 	@author Yazle Sean Ligot
 *  @version 1.0
*/
public class Terrain {
    
    private int classification;
    private int[] position;
    private boolean trigger;
    private boolean rMouse;
    
    /** This constructor initializes the classification and position of the tile
  
	    @param c Classification of Terrain
        @param x X coordinate from board
        @param y Y coordinate from board
	*/
    public Terrain(int c, int x, int y)
    {
        this.classification = c;
        position = new int[2];
        this.position[0] = y;
        this.position[1] = x;
    }

    /** This method gets the classification of the terrain
  
	    @return classification of the Tile
	*/
    public int getClassification()
    {
        return classification;
    }
    
    /** This method gets the classification of the terrain
  
	    @return position of the Tile
	*/
    public int[] getPosition()
    {
        return position;
    }

    /** This method returns if the terrain is triggered
  
	    @return trigger of the Tile
	*/
    public boolean isTriggered()
    {
        return trigger;
    }

    /** This method returns if a Mouse is present in the tile
  
	    @return rMouse 
	*/
    public boolean hasMouse()
    {
        return rMouse;
    }

    public String toString()
    {
        String toReturn="";
        switch(this.classification)
        {
            case 1: toReturn = "AD1";    break;
            case 2: toReturn = "AD2";    break;
            case 3: toReturn = "TR1";    break;
            case 4: toReturn = "TR2";    break;
            case 5: toReturn = "RIV";    break;
        }
        return toReturn;
    }
}
