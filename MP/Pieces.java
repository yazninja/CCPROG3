/** The class sets Pieces for the player to use according to their rank, team color, movement and capture mechanics.
 * 
 * 	@author David Nikolai Grasparil
 * 	@author Yazle Sean Ligot
 *  @version 1.0
*/
public class Pieces {
    private final String NAME;
    private String color;
    private int rank;
    private int[] position = new int [2];

    /** This constructor initializes the board of the game
  
	    @param r Board 
        @param c player color
        @param p1 Represents Red side
        @param p2 Represents Blue side 
	*/
    public Pieces(int r, String c, int pY, int pX)
    {
        switch(r)
        {
            case 1:
                this.NAME = "mouse";
                break;
            case 2:
                this.NAME = "cat";
                break;
            case 3:
                this.NAME = "wolf";
                break;
            case 4:
                this.NAME = "dog";
                break;
            case 5:
                this.NAME = "leopard";
                break;
            case 6:
                this.NAME = "tiger";
                break;
            case 7:
                this.NAME = "lion";
                break;
            case 8:
                this.NAME = "elephant";
                break;
        }
        this.color = c;
        this.rank = r;
        position[0] = pY;
        position[1] = pX;


    }
    /** This method captures a piece
  
	    @param Pokemon pikachu
	*/
    public boolean capture(Object Obj) 
    {
        Pieces enemy = (Pieces) Obj;
        if(enemy.rank == 8 && this.rank == 1)
        {
            if(terrain[enemy.position[0]][enemy.position[1]].hasMouse() == true) //idk im lost pero this is not needed pa
                return false;              //im assuming but this is supposed to be if river mouse?
            this.position = enemy.position;
            return true;
        }    
        if(enemy.rank <= this.rank)
        {
            this.position = enemy.position;
            return true;
        }
        return false; // did not eat
    }

    /** This method returns the current position of the piece
  
	@return position Current position of the piece
	*/
    public int[] getPosition()
    {
        return position;
    }

    /** This method returns the rank of the piece
  
	@return rank Rank of the piece
	*/
    public int getRank()
    {
        return rank;
    }
    
    /** This method is the movement of the Lion and Tiger when there is a river 
  
	@param d Direction of the piece
    @return true if move is performed, false if move is invalid
	*/
    public boolean moveRiver(char d)
    {
        if (this.validateMove(d))
        {
            if (this.getRank() == 6 || this.getRank() == 7)  //Lion and Tiger Move
            {
                switch(d)
                {
                    case 'U':
                        position[0] = position[0] + 3; break; //river is above
                    case 'D':
                        position[0] = position[0] - 3; break; //river is below
                    case 'L':
                        position[1] = position[1] - 4; break; //river is to the left
                    case 'R':
                        position[1] = position[1] + 4; break; //river is to the right 
                }
                return true;
            }
        }
        return false;
    }

    /** This method validates if river terrain contains a Mouse piece
  
	@param d Direction of the piece
    @return true if mouse is present, false if no mouse is present
	*/ 
    public boolean validateRiverMove(char d)
    {
        int i;
        int[] startPos = this.getPosition();
        switch(d)
        {
            case 'U':
                for(i=1; i < 4; i++)
                    if(Terrain[startPos[0] + i][startPos[1]].hasMouse)
                        return false;
                break;
            case 'D':
                for(i=1; i < 4; i++)
                    if(Terrain[startPos[0] - i][startPos[1]].hasMouse)
                        return false;
                break;
            case 'L':
                for(i=1; i < 3; i++)
                    if(Terrain[startPos[0] - i][startPos[1]].hasMouse)
                        return false;
                break;
            case 'R':
                for(i=1; i < 3; i++)
                    if(Terrain[startPos[0] + i][startPos[1]].hasMouse)
                        return false;
                break;
        }
        return true;
    }

    /** This method validates if move is possible
  
	@param d Direction of the piece
    @return true if move is valid, false if move is invalid
	*/ 
    public boolean validateMove(char d)
    {
        int[] startPos = this.getPosition();
        // check if position is occupied
        switch(d)
        {
            case 'U':
                if(this.getRank() == 1 && Terrain[startPos[0] +1][startPos[1]].getClassification == 5)    
                    return true;
                else if(!Board[startPos[0] +1][startPos[1]].getOccupied())
                    return true;
                break;
            case 'D':
                if(this.getRank() == 1 && Terrain[startPos[0] -1][startPos[1]].getClassification == 5)    
                    return true;
                else if(!Board[startPos[0] -1][startPos[1]].getOccupied())
                    return true;
                break;
            case 'L':
                if(this.getRank() == 1 && Terrain[startPos[0]][startPos[1] -1].getClassification == 5)    
                    return true;
                else if(!Board[startPos[0]][startPos[1] -1].getOccupied())
                    return true;
                break;
            case 'R':
                if(this.getRank() == 1 && Terrain[startPos[0]][startPos[1] +1].getClassification == 5)    
                    return true;
                else if(!Board[startPos[0]][startPos[1] +1].getOccupied())
                    return true;
                break;
        }
        // special check for mouse in river
        if(this.getRank() == 6 || this.getRank() == 7)
            if(this.validateRiverMove(d));
                return true;

        return false;
    }

	/** This method validates if move is possible
  
	@param direction Direction of the piece
    @return true if move is valid, false if move is invalid
	*/ 
    public boolean move(char direction)
    {
        if(this.validateMove(direction))
        {
            switch(direction)
            {
                case 'U':   position[0]++;  break;
                case 'D':   position[0]--;  break;
                case 'R':   position[1]++;  break; 
                case 'L':   position[1]--;  break;
            }
            return true;
        }
        return false;   // mag error sya sabihin, this move is not valid
    }
    
    public String toString()
    {
        String toReturn="";
        switch(this.rank)
        {
            case 1: toReturn = "M";     break;
            case 2: toReturn = "C";     break;
            case 3: toReturn = "W";     break;
            case 4: toReturn = "D";     break;
            case 5: toReturn = "Le";    break;
            case 6: toReturn = "T";     break;
            case 7: toReturn = "Li";    break;
            case 8: toReturn = "E";     break;
        }
        switch(this.color)
        {
            case "red":     toReturn = toReturn + "r";  break;
            case "blue":    toReturn = toReturn + "b";  break;
        }
        return toReturn;
    }
}

