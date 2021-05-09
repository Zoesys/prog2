package aufgabe3;

public class Solitaire {
    private Moves game;
    private State[][] field;

    public Solitaire()
    {
        this.game = new Moves();
        this.field = new State[7][7];
        for(int row = 0; row < this.field.length; row++)
        {
            for(int col = 0; col < this.field[row].length; col++)
            {
                if((row < 2 || row > 4) && (col < 2 || col > 4))
                {
                    this.field[row][col] = State.NOT;
                }
                else
                {
                    this.field[row][col] = State.USED;
                }
            }
        }
        this.field[3][3] = State.FREE;
    }

    /*
     * Geben Sie das Spielfeld aus! Am Anfang sollte auf der
     * Konsole so ein Bild erscheinen:
     *     o o o     
     *     o o o     
     * o o o o o o o 
     * o o o   o o o 
     * o o o o o o o 
     *     o o o     
     *     o o o 
     * 
     */
    public void print()
    {

    	for(int row = 0; row<this.field.length;row++) {
    		for(int col = 0; col<this.field[row].length;col++) {
    			if(this.field[row][col]==State.USED) System.out.print("o");
    			else if(this.field[row][col]==State.NOT) System.out.print(" ");
    			else System.out.print("x");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }

    /*
     * diese Methode gibt ein true zurueck, wenn von der
     * uebergebenen Position (row,col) ein Zug moeglich ist
     * d.h. 
     * 1. auf der angegebenen Position muss ein Stein sein
     * 2. zwei Steine weiter (oben, unten, rechts oder links)
     *      darf kein Stein sein
     * 3. dazwischen muss ein Stein sein
     */
    public boolean possibleFrom(int row, int col)
    {

    	if(row>=0 && row<7 && col>=0 && col<7 && this.field[row][col] == State.USED) {
    		if(row>1 && this.field[row-1][col] == State.USED && this.field[row-2][col] == State.FREE) return true;
    		if(row<5 && this.field[row+1][col] == State.USED && this.field[row+2][col] == State.FREE) return true;
    		if(col<5 && this.field[row][col+1] == State.USED && this.field[row][col+2] == State.FREE) return true;
    		if(col>1 && this.field[row][col-1] == State.USED && this.field[row][col-2] == State.FREE) return true;
    	}
        return false;
    }

    /*
     * diese Methode gibt alle Positionen (Point) zurueck,
     * AUF die von (fromRow,fromCol) aus gesprungen werden
     * kann
     */
    public Point[] possibleTo(int fromRow, int fromCol)
    {
    	int nrOfTo = 0;
        if(!possibleFrom(fromRow, fromCol)) return new Point[nrOfTo];
        boolean up = fromRow>1 && this.field[fromRow-1][fromCol] == State.USED && this.field[fromRow-2][fromCol] == State.FREE;
        boolean down = fromRow<5 && this.field[fromRow+1][fromCol] == State.USED && this.field[fromRow+2][fromCol] == State.FREE;
        boolean right = fromCol<5 && this.field[fromRow][fromCol+1] == State.USED && this.field[fromRow][fromCol+2] == State.FREE;
        boolean left = fromCol>1 && this.field[fromRow][fromCol-1] == State.USED && this.field[fromRow][fromCol-2] == State.FREE;
        if(up) nrOfTo++;
		if(down) nrOfTo++;
		if(right) nrOfTo++;
		if(left) nrOfTo++;
		
		Point[] tos = new Point[nrOfTo];
		int index = 0;
		if(up) tos[index++] = new Point(fromRow-2, fromCol);
		if(down) tos[index++] = new Point(fromRow+2, fromCol);
		if(right) tos[index++] = new Point(fromRow, fromCol+2);
		if(left) tos[index] = new Point(fromRow, fromCol-2);
		
		return tos;
    }

    /* 
     * diese Methode erzeugt ein Moves-Objekt
     * in dieses Moves-Objekt werden mithilfe der
     * Objektmethode addMove() (aus Moves) alle
     * moeglichen Zuege hinzugefuegt
     * (moeglich im aktuellen Zustand von field[][])
     */
    public Moves possibleMoves()
    {
    	Moves possibleMoves = new Moves();
		for(int row = 0; row < this.field.length; row++)
		{
			for(int col = 0; col < this.field[row].length; col++)
			{
				if(possibleFrom(row,col))
				{
					Point from = new Point(row,col);
					Point[] tos = this.possibleTo(row, col);
					for(int index=0; index<tos.length; index++)
					{
						Move move=new Move(from, tos[index]);
						possibleMoves.addMove(move);
					}
				}
			}
		}
		return possibleMoves;
    }

    /*
     * gibt ein true zurueck, wenn im aktuellen Zustand 
     * von field[][] ueberhaupt noch ein Zug moeglich ist
     * sonst false
     */
    public boolean movePossible()
    {
    	for(int row=0; row<this.field.length;row++) {
    		for(int col=0; col<this.field[row].length;col++) {
    			if(possibleFrom(row,col)) return true;
    		}
    	}

        return false;
    }

    /*
     * ruft die Methode move(Move move) auf,
     * wenn ein Zug moeglich ist (dann true zurueck)
     * sonst false
     */
    public boolean moveFirstPossible()
    {
        if(!movePossible()) return false;
        else {
        	Moves possibleMoves = this.possibleMoves();
        	possibleMoves.printMoves();
        	Move move = possibleMoves.getMoveAtIndex(0);
        	this.move(move);
        	return true;
        }
    }

    /*
     * hier wird der Zug Move move ausgefuehrt
     * nach dem Zug ist 
     * 1. die from-Position leer
     * 2. die to-Position mit einem Stein besetzt
     * 3. dazwischen leer (Stein wird "entfernt")
     * falls Zug nicht moeglich, wird eine 
     * IllegalArgumentException geworfen 
     */
    public void move(Move move) throws IllegalArgumentException
    {

    	int middleRow = (move.getFrom().getRow()+move.getTo().getRow())/2;
		int middleCol = (move.getFrom().getCol()+move.getTo().getCol())/2;
		try {
			this.field[move.getFrom().getRow()][move.getFrom().getCol()] = State.FREE;
			this.field[middleRow][middleCol] = State.FREE;
			this.field[move.getTo().getRow()][move.getTo().getCol()] = State.USED;	
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			throw new IllegalArgumentException("Move is not possible(" + move.getFrom().getRow()+", "+move.getFrom().getCol()+") --> "
					+ "( "+move.getTo().getRow()+", "+move.getTo().getCol()+") ");
		}

    }

}

