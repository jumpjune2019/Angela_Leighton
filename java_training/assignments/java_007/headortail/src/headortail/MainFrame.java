package headortail;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	public MainFrame(String title) {
		super(title);
		
		//set layout manager
		setLayout(new FlowLayout());
		
		//create swing components
		JButton btnClick = new JButton("Click to flip!");
		JButton btnReset = new JButton("Reset");
		JLabel lblResults = new JLabel("waiting...");
		
		
		//add swing components
		Container conPane = getContentPane();
		conPane.add(btnClick);
		conPane.add(btnReset);
		conPane.add(lblResults);
		
		btnClick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblResults.setText("I flipped!");
				lblResults.setText("The coin flip is: " + oneOrTwo(coinFlip()) + "!");
			}
			
		});
		
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblResults.setText("waiting...");	
			}
			
		});
	}
	
	protected int coinFlip() {
		
		return (int)(Math.random() * 2) + 1;
	}

	protected String oneOrTwo(int coin) {
		
		if (coin == 1) {
			return "head"; 
		} else {
			return "tail";
		}
	}
}
