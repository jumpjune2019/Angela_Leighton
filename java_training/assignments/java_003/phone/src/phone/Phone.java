package phone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Phone {
	
	
	static void testEmptyDataString(String data) throws EmptyDataException {
		if (data.equals("")) {
			throw new EmptyDataException("There is no data.");
		}
	}

	public static void main(String[] args) {
		
		//Thank you to Joel Reyes for help with this code!
		
		String [][] phoneBook= new String[5][3];
		Scanner entry = new Scanner(System.in);
		String data ="";
		
		System.out.println("Creating phone book entries...");
		
		for (int x = 0;  x < phoneBook.length; x++) { 
			System.out.println("Enter name: ");	
			
			try {
				data = entry.nextLine();
				testEmptyDataString(data);
			}
			catch(Exception e) {
				System.out.println("An exception occured: " + e);
				System.out.println("Enter name: ");
				data = entry.nextLine();
			}
			//add name to array
			phoneBook[x][0] = data;
      
            System.out.println("Enter phone number: ");
            
            try {
            	data = entry.nextLine();
            	testEmptyDataString(data);
            }
            catch (Exception e) {
            	System.out.println("An exception occured: " + e);
            	System.out.println("Enter phone number: ");
            	data = entry.nextLine();
            }
            //add phone number to array
	        phoneBook[x][1] = data;
	        
	        System.out.println("Enter city: ");
            
	        try {   	
               	data = entry.nextLine();
               	testEmptyDataString(data);          
			}
	        catch (Exception e) {
            	System.out.println("An exception occured: " + e);
            	System.out.println("Enter city: ");
            	data = entry.nextLine();
	        }
	        
	        //add city to the array
	        phoneBook[x][2] = data;	  
	        
	        System.out.println("You entered: ");
	        System.out.println(phoneBook[x][0] + "\t" + phoneBook[x][1] + "\t" + phoneBook[x][2]);
	        System.out.println("Do you want to enter this data? Y/N");
	        
	        String answer = entry.nextLine();
	        if (answer.equalsIgnoreCase("Y")) {
	        	continue;
	        }else {
	        	x--;
	        }
	        
		 }
		
		entry.close();
		
		System.out.println("Printing to phone.txt...");
		
		printToScreen(phoneBook);
		printToFile(phoneBook);
	}

	static void printToScreen(String[][] book) {
		
		System.out.println("Phonebook App");
		System.out.println("Name \t\t\tPhone \t\t\tCity");
		
		for(int x=0;x<book.length;x++) {
			for(int y=0;y<book[x].length;y++) {
				System.out.print(book[x][y] + "\t\t");
			}
			System.out.println();
		}
		
	}

	static void printToFile(String[][] book) {
	
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("phone.txt"));
			out.write("Name \t\t\tPhone \t\t\tCity\n");
			
			for(int x=0;x<book.length;x++) {
				for(int y=0;y<book[x].length;y++) {
					out.write(book[x][y] + "\t\t");
				}
				out.write("\n");
			}
			
			out.close();
	      }
	      catch (IOException e) {
	      }
	}
}
