
public class Main {

	public static void main(String[] args) {
		
		//declare and initialize tally array
		int tally[] = {0,0};

		//loop flips coin 1000 times
		for(int x=0;x <1000; x++) {
			int i = coinFlip();
			//increment tally
			tally[i-1] = tally[i-1] + 1;
		}
		
		System.out.println("1000 Coin Flips");
		System.out.println("Count of Head: " + tally[0]);
		System.out.println("Count of Tail: " + tally[1]);
		

	}
	
	static int coinFlip() {
		
		//get a random number between 1 and 2 inclusive
		int flip = (int)(Math.random() * 2) + 1;
		
		//return random number
		return flip;
	}
}
