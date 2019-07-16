package genarrayswap;

import java.util.*;
	
public class GenArraySwap{
	
	public static <T> void swap(List<?> arrList, int y, int z) {
		Collections.<T>swap(arrList, y, z);
	}
	
}