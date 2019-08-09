package preterm_swing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Seats {
	
	public static String[][] loadRoomMatrixFromFile(String fileName) {
		// the file will be configured as a Comma Separated Value (CSV) file.
		String fileLine;
		String[][] seats = new String[10][10];
		int x=0; //row counter
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			while ((fileLine = br.readLine()) != null) {
				
				seats[x] = fileLine.split(",");
				x++;
			}
			
		} catch(IOException exc) {
			System.out.println("IO Error: " + exc);
			
			//set all seats to vacant
			for(int y = 0; y < 10; y++) {
				for(int z = 0; z < 10; z++) {
					seats[y][z] = "vacant";
				}
			}
			//get the client store from the MainFrame class
			ClientStore clients = MainFrame.getAllClients();
			
			//remove all seat assignments
			for(int c = 0; c < clients.getClientDataCount(); c++) {
				clients.getClientStore()[c].setSeat(null);
			}
			
			MainFrame.setAllClients(clients);
		} 
		
		return seats;
	}
	
	public static void saveRoomMatrixToFile(String[][] seats) {
		//write the seat matrix to a file
	}
}