package matrixchoice;

import java.util.Scanner;  // Import the Scanner class
import java.io.*; //Import the Input/Output

public class MatrixChoice {

	public static void main(String[] args) {
		//declare two-dimensional array
		String[][] diceLabels = new String[6][6];
		
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

		// Create a Scanner object
		Scanner myObj = new Scanner(System.in);  
		
		System.out.println("Press 1 to print matrix to screen");
		System.out.println("Press 2 to print matrix to file");
		System.out.println("Press 3 to print matrix to screen and file");
		
		//read user input
		String userInput = myObj.nextLine();
		
		//if user chooses 1
		if (userInput.charAt(0) == '1') {
			//Print dice labels to screen
			printDiceLabels(diceLabels);
		}
		
		//if user chooses 2
		if (userInput.charAt(0) == '2') {
			//Print dice labels to file
			printDiceLabelsToFile(diceLabels);
		}
		
		//if user chooses 3
		if (userInput.charAt(0) == '3') {
			//Print dice labels to screen
			printDiceLabels(diceLabels);
			
			//Print dice labels to file
			printDiceLabelsToFile(diceLabels);
		}
		
		myObj.close();
	}
	
	static void printDiceLabelsToFile(String[][] diceLabels) {
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("filematrix"));
	         
	        //print the header
	 		out.write("Dice Combinations Label Matrix\n");
	 		out.write("\tDie 1 \t\t\tDie 2 \t\t\tDie 3 \t\t\tDie 4 \t\t\tDie 5 \t");
	 		out.write("\t\tDie 6");
	 		
	 		//print line 1
	 		out.write("\nDie 1 \t" + diceLabels[0][0] + "\t\t" + diceLabels[0][1] + "\t"); 
	 		out.write(diceLabels[0][2] + "\t\t" + diceLabels[0][3] + "\t\t" + diceLabels[0][4]); 
	 		out.write("\t" + diceLabels[0][5]);
			
			//print line 2
	 		out.write("\nDie 2 \t" + diceLabels[1][0] + "\t\t" + diceLabels[1][1] + "\t\t"); 
	 		out.write(diceLabels[1][2] + "\t\t\t" + diceLabels[1][3] + "\t\t" + diceLabels[1][4]); 
	 		out.write("\t\t" + diceLabels[1][5]);
	 		
	 		//print line 3
	 		out.write("\nDie 3 \t" + diceLabels[2][0] + "\t" + diceLabels[2][1] + "\t\t"); 
	 		out.write(diceLabels[2][2] + "\t\t" + diceLabels[2][3] + "\t\t" + diceLabels[2][4]); 
	 		out.write("\t\t" + diceLabels[2][5]);
			
			//print line 4
	 		out.write("\nDie 4 \t" + diceLabels[3][0] + "\t\t" + diceLabels[3][1] + "\t\t"); 
	 		out.write(diceLabels[3][2] + "\t\t\t" + diceLabels[3][3] + "\t\t" + diceLabels[3][4]); 
	 		out.write("\t\t" + diceLabels[3][5]);
			
			//print line 5
	 		out.write("\nDie 5 \t" + diceLabels[4][0] + "\t\t" + diceLabels[4][1] + "\t\t"); 
	 		out.write(diceLabels[4][2] + "\t" + diceLabels[4][3] + "\t\t" + diceLabels[4][4]); 
	 		out.write("\t\t" + diceLabels[4][5]);
			
			//print line 6
	 		out.write("\nDie 6 \t" + diceLabels[5][0] + "\t" + diceLabels[5][1] + "\t\t"); 
	 		out.write(diceLabels[5][2] + "\t" + diceLabels[5][3] + "\t" + diceLabels[5][4]); 
	 		out.write("\t\t\t" + diceLabels[5][5]);
	         
	         out.close();
	         System.out.println("File created successfully");
	      }
	      catch (IOException e) {
	      }
		
	}
	
	static void printDiceLabels(String[][] diceLabels) {
	
		//print the header
		System.out.println("Dice Combinations Label Matrix\n");
		System.out.print("\tDie 1 \t\t\tDie 2 \t\t\tDie 3 \t\t\tDie 4 \t\t\tDie 5 \t");
		System.out.println("\t\tDie 6");
		
		//print line 1
		System.out.print("Die 1 \t" + diceLabels[0][0] + "\t\t" + diceLabels[0][1] + "\t"); 
		System.out.print(diceLabels[0][2] + "\t\t" + diceLabels[0][3] + "\t\t" + diceLabels[0][4]); 
		System.out.println("\t" + diceLabels[0][5]);
		
		//print line 2
		System.out.print("Die 2 \t" + diceLabels[1][0] + "\t\t" + diceLabels[1][1] + "\t\t"); 
		System.out.print(diceLabels[1][2] + "\t\t\t" + diceLabels[1][3] + "\t\t" + diceLabels[1][4]); 
		System.out.println("\t\t" + diceLabels[1][5]);
		
		//print line 3
		System.out.print("Die 3 \t" + diceLabels[2][0] + "\t" + diceLabels[2][1] + "\t\t"); 
		System.out.print(diceLabels[2][2] + "\t\t" + diceLabels[2][3] + "\t\t" + diceLabels[2][4]); 
		System.out.println("\t\t" + diceLabels[2][5]);
		
		//print line 4
		System.out.print("Die 4 \t" + diceLabels[3][0] + "\t\t" + diceLabels[3][1] + "\t\t"); 
		System.out.print(diceLabels[3][2] + "\t\t\t" + diceLabels[3][3] + "\t\t" + diceLabels[3][4]); 
		System.out.println("\t\t" + diceLabels[3][5]);
		
		//print line 5
		System.out.print("Die 5 \t" + diceLabels[4][0] + "\t\t" + diceLabels[4][1] + "\t\t"); 
		System.out.print(diceLabels[4][2] + "\t" + diceLabels[4][3] + "\t\t" + diceLabels[4][4]); 
		System.out.println("\t\t" + diceLabels[4][5]);
		
		//print line 6
		System.out.print("Die 6 \t" + diceLabels[5][0] + "\t" + diceLabels[5][1] + "\t\t"); 
		System.out.print(diceLabels[5][2] + "\t" + diceLabels[5][3] + "\t" + diceLabels[5][4]); 
		System.out.println("\t\t\t" + diceLabels[5][5]);
	}
}
