package genarrayswap;

import java.util.*;

public class MainArray {
	
	public static void main(String[] args) {
	
		String[] wines = {"Pinot Noir", "Pinot Grigio", "Chardonnay", "Sangria", "Cabernet Sauvignon"};
		
		List<String> something = new ArrayList<String>(Arrays.asList(wines));
		
		//switch strings
		System.out.println("The first list is: " + Arrays.toString(wines));
		GenArraySwap.swap(something, 1, 4);
		System.out.println("Swap 'Pinot Grigio' and 'Cabernet Sauvignon': " + something);
	}

}
