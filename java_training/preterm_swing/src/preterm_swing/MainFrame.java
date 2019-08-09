package preterm_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 3408972000890906107L;
	private static String current;
	private static int curIndex;
	private static ClientStore allClients;
	private static String[][] allSeats = new String[10][10];
	private static DefaultListModel<String> listModel;
	private static ClientPanel clientPanel;
	private static MatrixPanel seatMatrix;
	
	public MainFrame(String title, ClientStore clients) {
		super(title);
		
		allClients = clients;
		allSeats = Seats.loadRoomMatrixFromFile("seats.csv");
		listModel = new DefaultListModel<String>();
		
		//add all clients without a seat to JList
		for(int x = 0; x < allClients.getClientDataCount(); x++) {			
			if (allClients.getClientStore()[x].getSeat() == null) {
				listModel.addElement(clients.getClientStore()[x].getFullName());
			}
		}
				
		//set layout manager
		setLayout(new BorderLayout());
		
		//set size of grid and JFrame
		int rows = 10;
		int cols = 10;
		
		int frameHeight = rows * 50;
		int frameWidth = cols * 50;
		
		this.setSize(frameWidth + 600, frameHeight + 200);
		
		//create list of client JList
		clientPanel = new ClientPanel();
		
		//create seat matrix
		seatMatrix = new MatrixPanel();
		
		//add reset and print buttons
		JPanel pnlButtons = new JPanel();
		
		JButton printList = new JButton("Print List");
		printList.setAlignmentX(CENTER_ALIGNMENT);
		printList.setPreferredSize(new Dimension(80, 40));
		
		//print list of clients with assigned seats
		printList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\nClients with Assigned Seats");
				System.out.println("Client\t\t\t\t\tID\t\t\tSeat");
				System.out.println("--------------------------------------------------------------------");
				for(int p = 0; p < allClients.getClientDataCount(); p++) {
					if ( allClients.getClientStore()[p].getSeat() != null) {
						if (!allClients.getClientStore()[p].getSeat().equals("")) {
							String name = allClients.getClientStore()[p].getFullName();
							//pad full name to a length of 30
							for(int n = name.length(); n < 31; n++) {
								name += " ";
							}
							System.out.println(name + "\t\t" + allClients.getClientStore()[p].getClientId() + "\t\t\t" + clients.getClientStore()[p].getSeat());
						}
					}
				}
			}
		});
		
		JButton reset = new JButton("Reset All Seats");
		
		reset.setAlignmentX(CENTER_ALIGNMENT);
		reset.setPreferredSize(new Dimension(120, 40));
		
		//add event handler
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				resetAllSeats();		
				
			}
		});
		
		pnlButtons.add(reset, BorderLayout.CENTER);
		pnlButtons.add(printList, BorderLayout.SOUTH);
		
		Container conPane = getContentPane();
		conPane.add(seatMatrix, BorderLayout.EAST);
		conPane.add(clientPanel, BorderLayout.WEST);
		conPane.add(pnlButtons, BorderLayout.SOUTH);
	}
	
	public static void resetAllSeats() {
		
		//remove all clients from JList
		listModel.removeAllElements();
	
		//add all clients to JList
		for(int x = 0; x < allClients.getClientDataCount(); x++) {
			listModel.addElement(allClients.getClientStore()[x].getClientFirstName() + " " + allClients.getClientStore()[x].getClientLastName());
		}
		
		for(int r = 0; r < 10; r++) {
			for(int c = 0;c < 10;c++) {
				allSeats[r][c] = "vacant";
			}
		}
		
		//remove all assigned seats in ClientStore
		for(int l = 0; l < allClients.getClientDataCount(); l++) {
			allClients.getClientStore()[l].setSeat("");
		}

		//reload seat matrix and client panel
		seatMatrix.loadBoard();	
		seatMatrix.validate();
		clientPanel.validate();
	}
	
	public static void setCurrent(String in) {
		current = in;
	}
	
	public static String getCurrent() {
		return current;
	}
	
	public static void setCurrentIndex(int index) {
		curIndex = index;
	}
	
	public static int getCurrentIndex() {
		return curIndex;
	}
	
	public static void setListModel(DefaultListModel<String> dlm) {
		listModel = dlm;
	}
	
	public static DefaultListModel<String> getListModel(){
		return listModel;
	}
	
	public static void setAllSeats (String[][] seats) {
		allSeats = seats;
	}
	
	public static String[][] getAllSeats(){
		return allSeats;
	}
	
	public static void setAllClients(ClientStore clients) {
		allClients = clients;
	}
	
	public static ClientStore getAllClients() {
		return allClients;
	}
}