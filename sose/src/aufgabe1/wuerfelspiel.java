package aufgabe1;
import javax.swing.JOptionPane;

public class wuerfelspiel {
	private Spieler[] spieler;
	
	public wuerfelspiel() {
		anzSpielerFestlegen();
		
	}
	
	public void anzSpielerFestlegen() {
		String input = JOptionPane.showInputDialog("Wie viele Spieler?");
		int anzSpieler = Integer.parseInt(input);
		spieler = new Spieler[anzSpieler]; 
		
	}
}
