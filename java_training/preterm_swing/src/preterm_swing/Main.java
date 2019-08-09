package preterm_swing;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
	
	//load current clients
	static ClientStore clients =  new ClientStore("clients_list.csv");
	static Client currentClient;
	static String[][] roomOne =  new String[10][10];

	public static void startApp() {
		
		System.out.println("Welcome to T-Rex Seat Booking!");		
	}
	
	public static void loginUser() {
		Scanner scan = new Scanner(System.in);
		
		//get user's first name
		System.out.println("Please enter First Name: ");
		String first = scan.nextLine();
		
		//get user's last name
		System.out.println("Please enter Last Name: ");
		String last = scan.nextLine();
		
		//search for client
		currentClient = clients.find(first, last);
		
		if (currentClient == null) {
			System.out.print("We could not find you in our system. ");
			System.out.println("Please register for an account.");
			
			//add registration functionality
			System.out.println("YOU CANNOT CURRENTLY REGISTER!!");
		}else {
			System.out.println("Welcome back " + currentClient.getClientFirstName() + " " + currentClient.getClientLastName());
		}
		
		//release resources
		scan.close();
	}
	
	public static void getInput() {
		
		System.out.println("getInput()");
		System.out.println("- get a room matrix");
		
	}
	
	public static int[] findRandomEmptySeat() {
		
		boolean foundSeat = false;
		int[] seat = new int[2];
		
		do {
			int row = (int)(Math.random() * 9);
			int col = (int)(Math.random() * 9);
			
			if (roomOne[row][col] == "vacant") {
				seat[0] = row;
				seat[1] = col;
				foundSeat = true;
				return seat;
			}
		//loop until empty seat is found
		} while(!foundSeat);
		
		return seat;
	}
	
	public static void loadOneRoom() {
		
		for (int x = 0; x < roomOne.length; x++) {
			for(int y = 0; y < roomOne[x].length; y++) {
				roomOne[x][y] = "vacant";
			}
		}
		
		for(int z = 0; z < clients.getClientDataCount(); z++) {
			int[] seat = findRandomEmptySeat();
			int row = seat[0];
			int col = seat[1];
			
			//assign client to random empty seat
			roomOne[row][col] = clients.getClientStore()[z].getClientId() + "/" + clients.getClientStore()[z].getClientInitials();
			String chair = getChair(row, col);
			
			clients.getClientStore()[z].setSeat(chair);
		}
	}
	
	public static String getChair(int row, int col) {
		
		String chair = "";
		char first;
		String second = "";
		
		col++;
		second = Integer.toString(col);
		
		//convert rows to letters
		row = row + 65;
		first = (char)row;
		
		chair = first + "-" + second;
		
		return chair;
	}
	
	public static void cancelSeat() {
		//cancels a booked seat
	}
	
	public static void bookSeat() {
		//book seat for currentClient
	}
	
	public static void viewSeat() {
		//view currentClient seat info
	}

	public static void processData() {
		System.out.println("processData()");
		System.out.println("- associate clients with room matrix");
		loadOneRoom();
	}

	public static void showOutput() {
		System.out.println("showOutput()");
		System.out.println("- display matrix");
		
		System.out.println();
		
		//Set Row Letter
		char z = 'A';
		
		//print col letter
		System.out.println("\t  1\t  2\t  3\t  4\t  5\t  6\t  7\t  8\t  9\t  10");
		
		for (int x = 0; x < roomOne.length; x++) {
			//print row letter
			System.out.print("Row " + z + "\t");
			for(int y = 0; y < roomOne[x].length; y++) {
				System.out.print(roomOne[x][y] + "\t");
			}
			System.out.println();
			z++;
		}
		
		System.out.println();
		
		System.out.println("- display list of clients with seat assignment");
		
		for (int i = 0; i < clients.getClientStore().length; i++) {
			System.out.print(clients.getClientStore()[i].getFullClientString() + ": ");
			System.out.println(clients.getClientStore()[i].getSeat());
		}
	}
	
	public static void endApp() 
	
		{System.out.println("Thank you for using our services!");
		
		//exit app
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				MainFrame frame = new MainFrame("T-Rex Seat Booking", clients);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
//		startApp();
//		getInput();
//		processData();
//		showOutput();
//		endApp();
	}
}

