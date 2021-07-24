import java.nio.channels.ClosedSelectorException;

/** The class repersents the board and initializes the board setting from terrain type and sides of the board(i.e. Red and Blue sides).
 * 
 * 	@author David Nikolai Grasparil
 * 	@author Yazle Sean Ligot
 *  @version 1.0
*/
public class Board {
    private Terrain[] terrain;
    private Pieces[] player1;
    private Pieces[] player2;
    private boolean occupied;
    private final int ROWS = 9;
    private final int COLUMNS = 7;
    
    /** This constructor initializes the board of the game
  
	    @param t Board 
        @param p player?
        @param r Represents Red side
        @param b Represents Blue side 
	*/
    public Board(String leftColor, String rightColor)
    {
        terrain = new Terrain[63];
        player1 = new Pieces[8];
        player2 = new Pieces[8];
        setLand();
        setDen();
        setRiver();
        setPieces(leftColor, rightColor);
    }

    /** This method checks if the tile is occupied
  
	    @return true if tile is occupied, false if tile is not occupied
	*/

    public boolean getOccupied()
    {
        return occupied;
    }
    public void setPieces(String lC, String rC)
    {
        player1[0] = new Pieces(1, lC, 6, 2);
        player1[1] = new Pieces(2, lC, 1, 1);
        player1[2] = new Pieces(3, lC, 2, 2);
        player1[3] = new Pieces(4, lC, 5, 1);
        player1[4] = new Pieces(5, lC, 4, 2);
        player1[5] = new Pieces(6, lC, 0, 0);
        player1[6] = new Pieces(7, lC, 6, 0);
        player1[7] = new Pieces(8, lC, 0, 2);

        player2[0] = new Pieces(1, rC, 0, 6);
        player2[1] = new Pieces(2, rC, 5, 7);
        player2[2] = new Pieces(3, rC, 4, 6);
        player2[3] = new Pieces(4, rC, 1, 7);
        player2[4] = new Pieces(5, rC, 2, 6);
        player2[5] = new Pieces(6, rC, 6, 8);
        player2[6] = new Pieces(7, rC, 0, 8);
        player2[7] = new Pieces(8, rC, 6, 6);


        //int r, String c, int pY, int pX
    }

    /** This method initializes the board with rivers
  
	*/
    public void setRiver()
    {
        
        int i,j,k;
        for (i = 3 ; i < 6 ; i++)
            for (j = 1 ; j < 6 ; j++)
            {
                k=0;
                while(k < terrain.length && terrain[k] != null)
                {
                    if (terrain[k].getPosition()[0] == j && terrain[k].getPosition()[1] == i && terrain[k].getPosition()[0] != 3)
                        terrain[k].setClassification(5);
                    k++;
                }
            }
               
                    
    }

    /** This method initializes the board with dens
  
	*/
    public void setDen()
    {
        int i=0;
        while(i < terrain.length && terrain[i] != null)
        {
            if (terrain[i].getPosition()[0] == 3 && terrain[i].getPosition()[1] == 0)
                terrain[i].setClassification(1);
            else if (terrain[i].getPosition()[0] == 3 && terrain[i].getPosition()[1] == 8)
                terrain[i].setClassification(2);
            i++;
        }
    }
    public void setLand()
    {
        int k=0;
        for (int i=0; i < COLUMNS; i++)
            for (int j=0; j < ROWS; j++)
            {
                terrain[k] = new Terrain(i,j);
                k++;
            }
    }

    /** This method initializes the board with rivers, dens, and traps
  
	    @param leftColor Red team 
        @param rightColor Blue team
	*/
    public void setBoard(String lC, String rC)
    {
        /* 1- leftDen 2-rightDen 3-leftTrap 4-rightTrap 5-river*/
        setRiver();
        setDen();
        setLand();
        setPieces(lC,rC);
        // no traps yet setTrap();
    }
    

    public void displayBoard()
    {
        int i, j, k = 0;
        int[] tempPos;
        boolean printed;
        System.out.println("     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  "); // top boarder || Y
        
        for (i = 0; i < COLUMNS; i++)
        {
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+");
            System.out.print("  " + (i+1) + "  |");
            for (j = 0; j < ROWS; j++)
            {
                printed=false;
                for(k=0; k < player1.length - 1; k++)
                {
                    if(player1[k + 1] != null)
                    {
                        tempPos = player1[k].getPosition();
                        if(j== tempPos[1] && i == tempPos[0])
                        {
                            System.out.print(player1[k].toString());
                            printed = true;
                        }
                            
                    }
                }
                for(k=0; k < player2.length - 1; k++)
                {
                    if(player2[k + 1] != null)
                    {
                        tempPos = player2[k].getPosition();
                        if(j == tempPos[1] && i == tempPos[0])
                        {
                            System.out.print(player2[k].toString());
                            printed = true;
                        }
                            
                    }
                }
                if(!printed)
                    for(k=0; k < terrain.length -1; k++)
                    {
                        if(terrain[k + 1] != null)
                        {
                            tempPos = terrain[k].getPosition();
                            if(j == tempPos[1] && i == tempPos[0])
                            {
                                System.out.print(terrain[k].toString());
                            }   
                        }
                    }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+"); 
    }
    /** This method occupies the tile

        @return true if the tile is not occupied, false if occupied
	*/
    public boolean occupy()
    {
        if(this.getOccupied()) // if already occupied return false (occupy failed)
            return false;
        
        this.occupied = true; // occupy the space in Board and return true signifying that the occupation worked properly
        return true;
    }

    /** This method deoccupies the tile

        @return true if the tile is occupied, false if not occupied
	*/
    public boolean deoccupy()
    {
        if(!this.getOccupied())
            return false;
        
        this.occupied = false;
        return true;
    }

    /** This method checks if the winning tile is occupied by the player
        
        @return true if Animal den is occupied, false if not occupied
	*/
    public boolean isGameOver() //fix - should add an occupied attribute to terrain, or use trigger attribute
    {
        if (terrain[0].getOccupied() || terrain[1].getOccupied())
            return true;

        return false;
    }
}
