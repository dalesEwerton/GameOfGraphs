package Graph;

import Characters.CharsLoadder;
import Characters.Player;

public class Main {
	
	public Main() {
		Actions a = new Actions();
		a.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
		/*CharsLoadder chrs = new CharsLoadder();
		chrs.loadChars();
		Character cs[] = chrs.getChars();
		
		for (Character c : cs) {
			System.out.println(c.toString());
		}*/
	}

}
