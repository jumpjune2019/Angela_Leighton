
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Coin Flip Program");
		System.out.println("The coin flip is: " + headsOrTails(coinFlip()));
	}
	
	static int coinFlip() {
		
		//get a random number between 1 and 2 inclusive
		int flip = (int)(Math.random() * 2) + 1;
		
		//return random number
		return flip;
	}
	
	static String headsOrTails(int flip) {
		String coin;
		
		//if the number is 1 return Head
		if (flip == 1) {
			coin = "Head";
		//if the number is 2 return Tail
		} else {
			coin = "Tail";
		}
		
		return coin;
	}

}
