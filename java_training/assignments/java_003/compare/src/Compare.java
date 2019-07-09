import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class Compare {
	
	public static void main(String[] args) throws IOException {
		
		boolean areFilesIdentical = true;
		File file1 = new File("/Users/angela/JumpJune2019/java_training/assignments/java_003/compare/file1.rtf");
		File file2 = new File("/Users/angela/JumpJune2019/java_training/assignments/java_003/compare/file3.rtf");
	    
		
		//if 1 of the files do not exist exit 
		if (!file1.exists() || !file2.exists()) {
	      System.out.println("One or both files do not exist");
	      return;
	    }
	    
		//compare file lengths
		if (file1.length() != file2.length()) {
	      areFilesIdentical = false;
	    }
	   
	    try {
	        FileInputStream fis1 = new FileInputStream(file1);
	        FileInputStream fis2 = new FileInputStream(file2);
	        byte[] fileb1 = new byte[(int) file1.length()];
	        byte[] fileb2 = new byte[(int) file2.length()];
	        
	        //read file
	        fis1.read(fileb1);
	        fis2.read(fileb2);
	        
	        //print report
	        System.out.println("Output: file 1 and file 2:");
	        System.out.print("Result: ");
	        
	        if(Arrays.equals(fileb1, fileb2)) {
	        	System.out.println("identical content");
	        	System.out.println("character length for both: " + file1.length());
	        } else {
	        	System.out.println("different content");
	        	System.out.println("character length for file 1: " + file1.length());
	        	System.out.println("character length for file 2: " + file2.length());
	        }
	       
	        //close resources
	        fis1.close();
	        fis2.close();
	        
	      } catch (IOException e) {
	        System.out.println("IO exception");
	        areFilesIdentical = false;
	      }
	}
	
}