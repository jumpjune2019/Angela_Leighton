package headortail;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the game of Head or Tail where you will flip your life away!");
		System.out.println("Press the F key and flip your luck!");
		
		//read user input
		String userInput = scan.nextLine();
		
		CoinToss coinFlip = () -> (int)(Math.random() * 2) + 1;
		CoinSide oneOrTwo = (int c) -> { 
			if (c == 1) {
				return "head"; 
			} else {
				return "tail";}
			};
		do {
			//user chooses to flip the coin
			if (userInput.equalsIgnoreCase("F")) {
				//tell user what side the coin landed on
				System.out.println("The coin flip is: " + oneOrTwo.oneOrTwo(coinFlip.coinFlip()) + "!");
			}
			//ask user if they want to play again
			System.out.println("END OR CONTINUE: “Press the F key to try again, press Q or q to Quit");
			
			userInput = scan.nextLine();
		
		//play until the user quits
		} while(!userInput.equalsIgnoreCase("Q"));
		
		//release resources
		scan.close();
		
		System.out.println("Thank you for playing.");
		
	}

}
