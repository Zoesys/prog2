package uebung1;

public class TicTacToe {
	enum State {EMPTY, RED, BLACK};
	State[][] field;
	
	public TicTacToe()
	{
		field = new State[3][3];
		for(int i=0;i<field.length;i++) {
			for(int j=0;j<field[i].length;j++) {
				field[i][j]=State.EMPTY;
			}
		}
	}
	
	public void makeMove(int i,int j,State player)
	{
		if(field[i][j]==State.EMPTY && player!=State.EMPTY) {
			field[i][j]=player;
		}
	}
	
	public void print()
	{
		for(int i=0; i<field.length;i++) {
			for(int j=0;j<field[i].length;j++) {
				if(field[i][j] == State.RED) {
					System.out.print("x");
				}
				if(field[i][j]==State.BLACK) {
					System.out.print("°");
				}
				if(field[i][j]==State.EMPTY){
					System.out.print("-");
				}
			}
			System.out.println();
		}
	}
	
	public boolean gewonnen() {
		int blackCount = 0;
		int redCount = 0;
		for(int i=0; i<field.length;i++) {
			for(int j=0;j<field[i].length;j++) {
				if(field[i][j] == State.RED) {
					redCount++;
					}
				if(field[i][j] == State.BLACK) {
					blackCount++;
					}
				}
		}
		if(blackCount == 3 || redCount == 3) {
			System.out.print("gewonnen");
			return true;
		}
		else {
			System.out.print("nicht gewonnen");
			return false;
		}
	}
}
	