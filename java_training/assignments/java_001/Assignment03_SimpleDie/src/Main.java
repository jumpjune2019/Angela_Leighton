import java.util.Scanner;  // Import the Scanner class

public class Main {

	public static void main(String[] args) {
		//ask user if he or she wants to roll a die

		// Create a Scanner object
		Scanner myObj = new Scanner(System.in);  
		
		System.out.print("Press any key to throw a pair of dice and press Enter");
		System.out.println("(or Q and Enter to quit)");
		
		//read user input
		String userInput = myObj.nextLine();
	
		if (userInput.toUpperCase().charAt(0) == 'Q') {
			//close scanner
			myObj.close();
			
			//if q then quit game
			return;
		}
		
		//roll the die if the user doesn't quit
		do{
			//tell user what he or she rolled
			System.out.println("You have rolled the following: " + dieRoll());
		
			//ask user if he or she would like to roll again
			System.out.print("Play again? (Y or y) and Enter, ");
			System.out.println("any other key and Enter to Quit");
			
			//get user input
			userInput = myObj.nextLine();
			
		//continue to roll the die while the user says y
		} while (userInput.toUpperCase().charAt(0) == 'Y');
		
		//close scanner
		myObj.close();
		return;

	}
	
	static int dieRoll() {
		
		//get a random number between 1 and 6 inclusive
		int roll = (int)(Math.random() * 6) + 1;
		
		//return random number
		return roll;
	}

}
