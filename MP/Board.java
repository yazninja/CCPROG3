/** The class repersents the board and initializes the board setting from terrain type and sides of the board(i.e. Red and Blue sides).
 * 
 * 	@author David Nikolai Grasparil
 * 	@author Yazle Sean Ligot
 *  @version 1.0
*/
public class Board {
    private Terrain[][] terrain;
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
    public Board(Terrain t, int p, String r, String b)
    {
        terrain[ROWS][COLUMNS] = t;
        this.setBoard(r, b);
    }
    public Board(String leftColor, String rightColor)
    {
        setBoard(leftColor, rightColor);
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
        terrain[3][1] = new Terrain(5, 3, 1); //river
        terrain[4][1] = new Terrain(5, 4, 1); //river
        terrain[5][1] = new Terrain(5, 5, 1); //river
        terrain[3][2] = new Terrain(5, 3, 2); //river
        terrain[4][2] = new Terrain(5, 4, 2); //river
        terrain[5][2] = new Terrain(5, 5, 2); //river

        terrain[3][4] = new Terrain(5, 3, 4); //river
        terrain[4][4] = new Terrain(5, 4, 4); //river
        terrain[5][4] = new Terrain(5, 5, 4); //river
        terrain[3][5] = new Terrain(5, 3, 5); //river
        terrain[4][5] = new Terrain(5, 4, 5); //river
        terrain[5][5] = new Terrain(5, 5, 5); //river
    }

    /** This method initializes the board with dens
  
	*/
    public void setDen()
    {
        terrain[3][0] = new Terrain(1, 3, 0); // Left den
        terrain[3][8] = new Terrain(2, 3, 8); // RIght den
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
        setPieces(lC,rC);
        // no traps yet setTrap();
    }
    //single print tiles and 2 if conditions for terrain and pieces
    public void displayBoard()
    {
        int i;
        System.out.println("  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  ");
        System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----");
        for (i = 0; i < ROWS - 1; i++)
        {
            System.out.println("  |  " + terrain[i][0] + "  |  " + terrain[i][1] + "  |  " + terrain[i][2] + "  |  " + terrain[i][3] + "  |  " + terrain[i][4] + "  |  " + terrain[i][5] + "  |  " + terrain[i][6] + "  |  " + terrain[i][7] + "  |  " + terrain[i][8] + "  ");
            if (i == ROWS -1)
               System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----"); 
        }
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
        if (terrain[3][0].getOccupied() || terrain[3][8].getOccupied())
            return true;

        return false;
    }
}
