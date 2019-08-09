package preterm_swing;

//client object

public class Client {
	private String lastname;
	private String firstname;
	private int id;
	private String bookedSeat;
	
	Client(String l, String f, int i) {
		lastname = l;
		firstname = f;
		id = i;
	}
	
	Client(String l, String f, int i, String seat) {
		lastname = l;
		firstname = f;
		id = i;
		bookedSeat = seat;
	}
	
	String getSeat() {
		return bookedSeat;
	}
	
	void setSeat(String s) {
		bookedSeat = s;
	}
	
	int getClientId() {
		return id;
	}
	
	String getClientLastName() {
		return lastname;
	}
	
	String getClientFirstName() {
		return firstname;
	}
	
	String getClientInitials() {
		char[] initialsArr = {' ', ' '};
		initialsArr[0] = firstname.charAt(0);
		initialsArr[1] = lastname.charAt(0); 
		return new String(initialsArr);
	}
	
	String getFullName() {
		return firstname + " " + lastname;
	}

	String getFullClientString() {
		String full = ("id: " + id + " lastname: " + lastname + " firstname: " + firstname);
		return full;
	}
}
