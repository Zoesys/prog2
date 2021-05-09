package uebung1;

public class uebungTest {

	public static void main(String[] args) {
		TicTacToe T1 = new TicTacToe();
		
		T1.makeMove(0,0,TicTacToe.State.RED);
		T1.makeMove(2, 1, TicTacToe.State.BLACK);
		T1.makeMove(2, 2, TicTacToe.State.RED);
		T1.makeMove(0, 2, TicTacToe.State.BLACK);
		T1.makeMove(1, 1, TicTacToe.State.RED);
		T1.print();
		T1.gewonnen();

	}

}
