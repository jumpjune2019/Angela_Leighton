package app;

import java.util.Arrays;
//imports the class from the package
import static arrayutils.ArrayUtils.*;

public class StringArrayUtilities2 {

	public static void main(String[] args) {
		
		String myList[] = new String[] {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money","Zoo"};
		
		//Report header
		System.out.println("This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items: ");
		System.out.println("{\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\"}");
		
		//test these cases
		System.out.println("Scenario 1");
		System.out.print("arrayHasExactMatch(myList, \"zo\", false): is "); 
		System.out.println(arrayHasExactMatch(myList, "zo", false));
		
		System.out.println("\nScenario 2");
		System.out.print("arrayHasExactMatch(myList, \"zoo\", false): is "); 
		System.out.println(arrayHasExactMatch(myList, "zoo", false));
		
		System.out.println("\nScenario 3");
		System.out.print("arrayHasExactMatch(myList, \"zoo\", true): is ");
		System.out.println(arrayHasExactMatch(myList, "zoo", true));
		
		System.out.println("\nScenario 4");
		System.out.print("arrayHasExactMatch(myList, \"foo\", true): is "); 
		System.out.println(arrayHasExactMatch(myList, "foo", true));
		
		System.out.println("\nScenario 5");
		System.out.print("arrayHasExactMatch(myList, \"foo\", false): is "); 
		System.out.println(arrayHasExactMatch(myList, "foo", false));
		
		System.out.println("\nScenario 6");
		System.out.print("arrayHasExactMatch (myList, \"delta\", true): is "); 
		System.out.println(arrayHasExactMatch(myList, "delta", true));
		
		System.out.println("\nScenario 7");
		System.out.print("arrayHasExactMatch(myList, \"Delta\", true): is "); 
		System.out.println(arrayHasExactMatch(myList, "Delta", true));
		
		System.out.println("\nScenario 8");
		System.out.print("indexOfOccuranceInArray(myList, \"zo\", false): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "zo", false)));
		
	
		System.out.println("\nScenario 9");
		System.out.print("indexOfOccuranceInArray(myList, \"zoo\", false): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "zoo", false)));
		
		System.out.println("\nScenario 10");
		System.out.print("indexOfOccuranceInArray(myList, \"zoo\", true): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "zoo", true)));
		
		System.out.println("\nScenario 11");
		System.out.print("indexOfOccuranceInArray(myList, \"foo\", true): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "foo", true)));
		
		System.out.println("\nScenario 12");
		System.out.print("indexOfOccuranceInArray(myList, \"foo\", false): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "foo", false)));
		
		System.out.println("\nScenario 13");
		System.out.print("indexOfOccuranceInArray(myList, \"delta\", true): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "delta", true)));
		
		System.out.println("\nScenario 14");
		System.out.print("indexOfOccuranceInArray(myList, \"Delta\", true): returns ");
		System.out.println(Arrays.toString(indexOfOccuranceInArray(myList, "Delta", true)));
	}

}
