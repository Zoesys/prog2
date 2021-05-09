package aufgabe3;

public class SolitaireTest {

	public static void main(String[] args) {
		Solitaire game = new Solitaire();
		game.print();
		System.out.println();
		int zug = 1;
		while(game.moveFirstPossible()) {
			zug++;
			game.print();
		}

	}

}
