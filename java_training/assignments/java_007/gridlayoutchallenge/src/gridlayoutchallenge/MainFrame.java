package gridlayoutchallenge;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JLabel lblSeat = new JLabel("No seat selected");
	
	public MainFrame(String title) {
		super(title);
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create swing components
		JLabel lblTitle = new  JLabel("Basic Matrix Demo");
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setVerticalAlignment(JLabel.CENTER);
		
		lblSeat.setHorizontalAlignment(JLabel.CENTER);
		lblSeat.setVerticalAlignment(JLabel.CENTER);
		
		//add swing components
		Container conPane = getContentPane();
		conPane.add(lblTitle, BorderLayout.NORTH);
		conPane.add(lblSeat, BorderLayout.SOUTH);
		
		int rows = genRandomNum();
		int cols = genRandomNum();
		
		int frameHeight = (rows * 50) + 80;
		int frameWidth = cols * 50;
		
		this.setSize(frameWidth, frameHeight);
		
		JPanel panelMatrix = createBoard(rows, cols);
		
		conPane.add(panelMatrix, BorderLayout.CENTER);
	}

    private JPanel createBoard(int width, int height) {
    	char z = 'A';
        final JPanel board = new JPanel(new GridLayout(width, height));
        for(char x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
            	JPanel cell = createCell(z,y);
            	board.add(cell);
            }
            z++;
        }
        return board;
    }
    
    private JPanel createCell(char x, int y) {
    	JPanel cell = new JPanel();
    	
    	cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));
    	cell.setSize(50,50);
    	
    	JButton button = new JButton(x + "-" + (y+1));
    	JLabel label = new JLabel("    " + x + "-" + (y+1));
    	
    	button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblSeat.setText(button.getText());
			}	
		});
    	
    	cell.add(label);
    	cell.add(button);
    
    	return cell;
    }
	
	public static int genRandomNum() {
		return (int)(Math.random() * 4) + 2;
	}
}