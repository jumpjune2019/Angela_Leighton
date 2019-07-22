package headortail;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	static JFrame frame;

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				MainFrame frame = new MainFrame("Heads or Tails");
				frame.setSize(500, 400);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
