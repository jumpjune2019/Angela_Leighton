package gameofdice;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {
	
	private static JLabel lblResults = new JLabel("");
	private static JLabel lblWinner = new JLabel("");
	
	//declare two-dimensional array
	static String[][] diceLabels = new String[6][6];

	public MainFrame(String title) {
		super(title);
		
		loadDiceLabels();
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create swing components
		JButton btnClick = new JButton("Play a Game of Dice!");
		
		//add swing components
		Container conPane = getContentPane();
		conPane.add(btnClick, BorderLayout.NORTH);
		conPane.add(lblResults, BorderLayout.CENTER);
		conPane.add(lblWinner, BorderLayout.SOUTH);
		
		btnClick.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				playDice();
			}	
		});
	}
	
	private void loadDiceLabels() {
		//fill diceLabels array
		diceLabels[0][0] = "Snake eyes";
		diceLabels[0][1] = "Ace caught a deuce";
		diceLabels[0][2] = "Easy four";
		diceLabels[0][3] = "Little Phobe";
		diceLabels[0][4] = "Sixie from Dixie";
		diceLabels[0][5] = "The Devil";
		diceLabels[1][0] = "Austrailian yo";
		diceLabels[1][1] = "Ballerina";
		diceLabels[1][2] = "OJ";
		diceLabels[1][3] = "Easy six";
		diceLabels[1][4] = "Skinny Dugan";
		diceLabels[1][5] = "Easy eight";
		diceLabels[2][0] = "Little Joe from Kokomo";
		diceLabels[2][1] = "The fever";
		diceLabels[2][2] = "Brooklyn forest";
		diceLabels[2][3] = "Skinny McKinney";
		diceLabels[2][4] = "Easy eight";
		diceLabels[2][5] = "Lou Brown";
		diceLabels[3][0] = "No field five";
		diceLabels[3][1] = "Jimmie Hicks";
		diceLabels[3][2] = "Big Red";
		diceLabels[3][3] = "Square pair";
		diceLabels[3][4] = "Jesse James";
		diceLabels[3][5] = "Tennessee";
		diceLabels[4][0] = "Easy six";
		diceLabels[4][1] = "Bennie Blue";
		diceLabels[4][2] = "Eighter from Decater";
		diceLabels[4][3] = "Railroad nine";
		diceLabels[4][4] = "Puppy paws";
		diceLabels[4][5] = "Six five no jive";
		diceLabels[5][0] = "Six one you're done";
		diceLabels[5][1] = "Easy eight";
		diceLabels[5][2] = "Nina from Pasadena";
		diceLabels[5][3] = "Big one on the road";
		diceLabels[5][4] = "Yo";
		diceLabels[5][5] = "Midnight";
		
	}

	static int dieRoll() {
		return (int)(Math.random() * 6) + 1;
	}
	
	static void playDice() {
		
		String results = "";
		String winner = "";
		
		lblResults.setText("Rolling the dice...");
		
		//roll the dice
		int x = dieRoll();
		int y = dieRoll();
		
		int a = dieRoll();
		int b = dieRoll();
		
		//tell user what he or she rolled
		results = "You have rolled a " + x + " and " + y + " > the " + rollName(x,y);
		
		//tell user what the computer rolled
		results += "\nI have rolled a " + a + " and " + b + " > the " + rollName(a,b);

		//display the results of the game
		lblResults.setText(results);
		
		//determine who won
		if ((x+y) > (a+b)) {
			//user won
			winner = "You win!!";
			winner += "\nDid you cheat?? Gimme another try, c'mon ";
			lblWinner.setText(winner);
			
		} else if ((x+y) < (a + b)) {
			//the computer won
			winner = "I win!!";
			winner += "\nWanna try again? ";
			lblWinner.setText(winner);
			
		} else if ((x+y) == (a + b)) {
			//there's a tie
			if ((x == y) && (a == b)) {
				//everybody has doubles, stale mate
				winner = "Stalemate! You're tough, let's try for a tiebreaker ";
				lblWinner.setText(winner);
			} else if (x == y) {
				//user has doubles and wins
				winner = "Damn! You win on a Double! What luck!";
				winner += "\nDid you cheat?? Gimme another try, c'mon ";
				lblWinner.setText(winner);
			} else if (a == b) {
				//computer has doubles and wins
				winner = "Damn! I win on a Double! Ah! I pity you fool!";
				winner += "\nWanna try again? ";
				lblWinner.setText(winner);
			} else {
				//no one has doubles
				winner = "Stalemate! You're tough, let's try for a tiebreaker ";
				lblWinner.setText(winner);
			}
			
			//display the winner
			lblWinner.setText(winner);
			System.out.println(winner);
		}
	}
	
	static String rollName(int x, int y) {
		
		return diceLabels[x-1][y-1].toString();
	}
}
