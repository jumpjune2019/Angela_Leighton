package preterm_swing;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ClientPanel extends JPanel implements ListSelectionListener{
	
	private static final long serialVersionUID = -5258341689704940233L;
	private JList<String> listClients;

	public ClientPanel() {
		  
		//set size
		Dimension size = getPreferredSize();
		size.width = 220;
		this.setPreferredSize(size);
		
		//add list of unassigned clients
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		//initialize with unassigned clients
		listClients = new JList<String>(MainFrame.getListModel());
		
		listClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//add list selection handler
		listClients.addListSelectionListener(this);
		
		//set the size of the list
		listClients.setPreferredSize(new Dimension(300, 300));
		listClients.setFixedCellWidth(150);
		
		//add components
		add(listClients);
	}
	
	// Handle list selection events.
	public void valueChanged(ListSelectionEvent le) {
		
		// Get the index of the changed item.
		int idx = listClients.getSelectedIndex();
		// Display selection, if item was selected.
		if(idx != -1) {
			MainFrame.setCurrent(MainFrame.getListModel().get(idx));
			MainFrame.setCurrentIndex(idx);
		} 
	}
}
