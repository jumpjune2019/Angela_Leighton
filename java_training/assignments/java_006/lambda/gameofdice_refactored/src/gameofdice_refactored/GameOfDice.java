package gameofdice_refactored;

import java.util.Scanner;

public class GameOfDice {
	
	//declare two-dimensional array
	static String[][] diceLabels = new String[6][6];

	public static void main(String[] args) {
		
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
		
		System.out.println("Welcome to the dice throw challenge!");
		System.out.println("Do you feel lucky? \"Punk\"...Do ya?");
		System.out.print("Press any key and ENTER to throw your dice or ");
		System.out.println("(Q or q) to chicken your butt off...");

		// Create a Scanner object
		Scanner myObj = new Scanner(System.in); 
		
		//read user input
		String userInput = myObj.next();
		
		//if q or Q then quit game
		if (userInput.toUpperCase().charAt(0) == 'Q') {
			//close scanner
			myObj.close();
			
			System.out.println("See ya later alligator!");

			return;
		}
		
		//roll the dice if the user doesn't quit
		do {
			playDice();
			
			//ask user if he or she would like to roll again
			System.out.print("Press any key and ENTER to throw your dice or ");
			System.out.println("press (Q or q) to quit");
			
			//get user input
			userInput = myObj.next();
			
		//continue to roll the dice while the user says yes
		} while (userInput.toUpperCase().charAt(0) != 'Q');
		
		//close scanner
		myObj.close();
		System.out.println("Thanks for being a sport! Laters!");
		return;
	}
	
	static void playDice() {
		System.out.println("Rolling the dice...");
		
		RollDie dieRoll = () -> (int)(Math.random() * 6) + 1;
		
		//roll the dice
		int x = dieRoll.dieRoll();
		int y = dieRoll.dieRoll();
		
		int a = dieRoll.dieRoll();
		int b = dieRoll.dieRoll();
		
		//tell user what he or she rolled
		System.out.print("You have rolled a " + x + " and " + y + " > the ");
		System.out.println(rollName(x,y));
		
		//tell user what the computer rolled
		System.out.print("I have rolled a " + a + " and " + b + " > the ");
		System.out.println(rollName(a,b));
		
		//determine who won
		if ((x+y) > (a+b)) {
			//user won
			System.out.println("You win!!");
			System.out.print("Did you cheat?? Gimme another try, c'mon ");
			
		} else if ((x+y) < (a + b)) {
			//the computer won
			System.out.println("I win!!");
			System.out.print("Wanna try again? ");
			
		} else if ((x+y) == (a + b)) {
			//there's a tie
			if ((x == y) && (a == b)) {
				//everybody has doubles, stale mate
				System.out.print("Stalemate! You're tough, let's try for a tiebreaker ");
			} else if (x == y) {
				//user has doubles and wins
				System.out.println("Damn! You win on a Double! What luck!");
				System.out.print("Did you cheat?? Gimme another try, c'mon ");
				
			} else if (a == b) {
				//computer has doubles and wins
				System.out.println("Damn! I win on a Double! Ah! I pity you fool!");
				System.out.print("Wanna try again? ");
			} else {
				//no one has doubles
				System.out.print("Stalemate! You're tough, let's try for a tiebreaker "); 	
			}
		}
	}
	
	static String rollName(int x, int y) {
		
		return diceLabels[x-1][y-1].toString();
	}
}
