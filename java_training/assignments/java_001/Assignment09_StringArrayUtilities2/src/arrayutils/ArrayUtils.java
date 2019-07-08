package arrayutils;

public class ArrayUtils {


	public static boolean arrayHasExactMatch(String[] arr, String match, boolean caseSen) {
		
		//if the match is case sensitive
		if (caseSen) {
			//loop thru the array
			for(int x=0;x<arr.length;x++) {
				//if there's a match return true
				if (arr[x] == match) {
					return true;
				}
			}
		//if the match is not case sensitive
		}else {
			//loop thru the array
			for(int x=0;x<arr.length;x++) {
				//if there's a match return true
				if (arr[x].equalsIgnoreCase((match))) {
					return true;
				}
			}
		}
		
		//if there is not a match return false
		return false;
		
	}
	
	public static int[] indexOfOccuranceInArray(String[] arr, String match, boolean caseSen) {
		
		 //declare array to return
		 int[] matches = new int[] {0};
		 
	 	//if the match is case sensitive
		if (caseSen) {
			//loop thru the array
			for(int x=0;x<arr.length;x++) {
				//if there's a match add index to matches
				if (arr[x] == match) {
					matches[0] = x;
				}
			}
		//if the match is not case sensitive
		}else {
			//loop thru the array
			for(int x=0;x<arr.length;x++) {
				//if there's a match add index to matches
				if (arr[x].equalsIgnoreCase((match))) {
					matches[0] = x;
				}
			}
		}
		
		//if there are no matches return -1
		if (matches[0] == 0) {
			matches[0] = -1;
		}
		
		//return the array of indexes
		return matches;
		
	 }	
}