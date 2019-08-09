package preterm_swing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClientStore {
	private Client[] dataStore;
	private int dataCount;
	
	ClientStore(String f) {
		// for now this is hard coded, until
		// we learn how to work with a combination of objects and arraylist
		dataStore = new Client[25];
		dataCount = 0;
		boolean success = loadClientFromFile(f);
		if(!success) {
			// we have a problem
			System.out.println("The file was not loaded and the datastore is empty");
		}
	}

	// for now, this is internal to the method;
	// will be used by loadClientFromFile() method
	void addClient(Client client) {
		if(dataCount < 25) {
			dataStore[dataCount] = client;
			dataCount++;
		} else {
			System.out.println("We have reached our limit of 25 clients");
		}
	}

	boolean loadClientFromFile(String f) {
		// the file will be configured as a Comma Separated Value (CSV) file.
		String fileLine;
		String[] record;
		Client client;
		
		boolean first = true;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			while ((fileLine = br.readLine()) != null) {
				// skip the first line of the CSV 
				// it contains the field names
				if(first == true) {
					first = false;
					continue;
				}
				record = fileLine.split(",");
				if (record.length == 3) {
					client = new Client(record[1], record[2], Integer.parseInt(record[0]));
				} else {
					client = new Client(record[1], record[2], Integer.parseInt(record[0]), record[3]);
				}
				addClient(client);
//  				System.out.println(fileLine);
			}
			
		} catch(IOException exc) {
			System.out.println("IO Error: " + exc);
		}
		
		return true;
	}
	Client find(String first, String last) {
		//returns client if found
		//returns null if client not found
		
		Client found = null;
		
		for(int x = 0; x < dataStore.length; x++) {
			if (first.equalsIgnoreCase(dataStore[x].getClientFirstName())) {
				if (last.equalsIgnoreCase(dataStore[x].getClientLastName())) {
					found = dataStore[x];
					return found;
				}
			}
		}
		return found;
	}

	Client find(String find) {
		//returns client if found
		//returns null if client not found
		
		Client found = null; 
		
		for (int y = 0; y < dataStore.length; y++) {
			if (dataStore[y].getFullName().equalsIgnoreCase(find)) {
				found = dataStore[y];
				return found;
			} else {
				String initials = "ID: " + dataStore[y].getClientId() + "/" + dataStore[y].getClientInitials();
				if (initials.equalsIgnoreCase(find)) {
					found = dataStore[y];
					return found;
				}
			}	
		}
		
		
		
		return found;
	}
	
	Client find(int findID) {
		//returns client if found
		//returns null if client not found

		Client found = null;
		for(int x = 0; x < dataStore.length; x++) {
			if (findID == dataStore[x].getClientId() ) {
				found = dataStore[x];
				return found;
			}
		}
		
		return found;
	}

	// could return an empty store
	Client[] getClientStore() {
		return dataStore;
	}
	
	int getClientDataCount() {
		return dataCount;
	}
	
}