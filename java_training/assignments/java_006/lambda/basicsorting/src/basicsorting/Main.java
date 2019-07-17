package basicsorting;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		sortNumArray();
		sortStringArray();
	
	}
	
	static void sortStringArray() {
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce" };
		
		SortArrays<String> strArray = (a, order, caseSen) -> {
			String[] arr = a;
			//ascending order
			if(order.equalsIgnoreCase("ASC")) {
				//case insensitive
				if (caseSen == true) {
					Arrays.sort(arr);
				//case sensitive
				} else if (caseSen == false) {
					Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
				}
			//descending order
			} else if ( order.equalsIgnoreCase("DESC")) {
				//case in
				if (caseSen == true) {
					Arrays.sort(arr);
					//reverse the array for descending
					Collections.reverse(Arrays.asList(arr));
				} else if (caseSen == false) {
					Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
					Collections.reverse(Arrays.asList(arr));
				}
			}
			
			return arr;
		};
        
        //print array
        System.out.println("\nInitial String Array: " + Arrays.toString(strArr));
	     
	    //sort array ascending with case sensitivity 
	    strArr = strArray.sort(strArr,"ASC",true);
	    System.out.println("Sorted ASC and CASE SENSITIVITY ON: " + Arrays.toString(strArr));
	    
	    //sort array ascending without case sensitivity 
	    strArr = strArray.sort(strArr,"ASC",false);
	    System.out.println("Sorted ASC and CASE SENSITIVITY OFF: " + Arrays.toString(strArr));
	     
	  //sort array descending with case sensitivity 
	    strArr = strArray.sort(strArr,"DESC",true);
	    System.out.println("Sorted DESC and CASE SENSITIVITY ON: " + Arrays.toString(strArr));
	    
	    //sort array descending without case sensitivity 
	    strArr = strArray.sort(strArr,"DESC",false);
	    System.out.println("Sorted DESC and CASE SENSITIVITY OFF: " + Arrays.toString(strArr));
	}
	
	static void sortNumArray() {
		Integer[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
				
		 SortArrays<Integer> intArray = (a, order, caseSen) -> {
             Integer[] arr = a;
             if(order.equalsIgnoreCase("ASC")){
            	 Arrays.sort(arr);
             }else if(order.equalsIgnoreCase("DESC")) {
            	 Arrays.sort(arr,Collections.reverseOrder());
             }
             
             return arr;
         };
            
         //print array
         System.out.println("Initial Integer Array: " + Arrays.toString(numArr));
	     
	     //sort array ascending 
	     numArr = intArray.sort(numArr,"ASC",false);
	     System.out.println("Sorted ASC: " + Arrays.toString(numArr));
	     
	     //sort array descending
	     numArr = intArray.sort(numArr,"DESC" ,false);
	     System.out.println("Sorted DESC: " +Arrays.toString(numArr));
	}

}
