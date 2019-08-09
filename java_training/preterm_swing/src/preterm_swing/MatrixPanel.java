package preterm_swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class MatrixPanel extends JPanel {

	private static final long serialVersionUID = -8370475276533922960L;
	private static JPanel board;
	private int width = 10;
	private int height = 10;
	
	public MatrixPanel() {
		
		setLayout(new BorderLayout());
		
		//load the seat matrix into a 2D array
		MainFrame.setAllSeats(Seats.loadRoomMatrixFromFile("seats.csv"));
		
		//load the grid with seats
		loadBoard();
	}
	
	private void createRowHeader(char row) {
		JPanel rowCell = new JPanel();
		
		//create row label
		JLabel label = new JLabel("Row " + row);
		rowCell.add(label);

		//add row label cell to board
		board.add(rowCell);	
	}
	
	private void createColHeaders() {
		
        JPanel header = new JPanel();
        //add blank cell
        board.add(header);
        
        //add seat numbers
        for (int h=1;h<11;h++) {
        	header = new JPanel();
        	JLabel label = new JLabel("Seat " + h);
        	header.add(label);

        	//add cell to board
        	board.add(header);
        }
	}
	
    private JPanel createCell(char x, int z, int y) {
    	JPanel cell = new JPanel();
    	String occupy = "";
    	JButton button;
    	JLabel label;
    	
    	cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
    	
    	occupy = MainFrame.getAllSeats()[z][y];
    	
    	if (occupy.equals("vacant")) {
    		button = new JButton("book");
    		label = new JLabel(occupy);
    	} else {
    		button = new JButton("unbook");
    		label = new JLabel("ID: " + occupy);
    	}
    	
    	button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (button.getText().equals("book")) {
					//find the client to book
					Client person = MainFrame.getAllClients().find(MainFrame.getCurrent());
					
					if (person != null) {
						
						//get the client's new seat
						String s = x + "-" + (y+1);
						
						//set the new seat
						person.setSeat(s);
					
						//update the client panel
						MainFrame.getListModel().remove(MainFrame.getCurrentIndex());
						label.setText("ID: " + person.getClientId() + "/" + person.getClientInitials());
						
						//change the button text
						button.setText("unbook");
						
						MainFrame.setCurrent("");
					}
					
				} else if (button.getText().equals("unbook")){
					Client person = MainFrame.getAllClients().find(label.getText());
					
					if (person != null) {
						//only add the person if they are not in the list already
						if (!MainFrame.getListModel().contains(person.getFullName())) {
							//add the client back to the list
							MainFrame.getListModel().addElement(person.getFullName());
						}
						
						//remove the seat from the client
						person.setSeat("");
						
						//set the label to vacant
						label.setText("vacant");
						
						//change the button text
						button.setText("book");
					}
				}
			}	
		});
    	
    	cell.add(label);
    	cell.add(button);
    
    	return cell;
    }

    public void loadBoard() {
    	
    	//add extra row for col and row headers
		width++;
		height++;
		
		//remove all components MatrixPanel
		this.removeAll();
		
        board = new JPanel(new GridLayout(width, height, 6, 6));
        board.setBackground(Color.BLUE);
        
        //set the size of the grid
        board.setPreferredSize(new Dimension(900, 625));
        
        //add seat numbers to grid
        createColHeaders();
		
        //set the size back to original for grid
		width--;
		height--;
        
		//set row letter
		char z = 'A';
        for(char x = 0; x < width; x++) {
        	createRowHeader(z);
            for(int y = 0; y < height; y++) {
            	JPanel cell = createCell(z,x,y);
            	board.add(cell);
            }
            //increment row letter
            z++;
        }
        
        board.revalidate();
        board.repaint();
        add(board, BorderLayout.NORTH);
    }
}
