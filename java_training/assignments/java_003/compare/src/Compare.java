import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Compare {
	
	public static void main(String[] args) throws IOException {
		
		boolean areFilesIdentical = true;
		File file1 = new File("/Users/angela/JumpJune2019/java_training/assignments/java_003/compare/file1.rtf");
		File file2 = new File("/Users/angela/JumpJune2019/java_training/assignments/java_003/compare/file2.rtf");
	    
		
		//if 1 of the files do not exist exit 
		if (!file1.exists() || !file2.exists()) {
	      System.out.println("One or both files do not exist");
	      return;
	    }
		
		//Output the file lengths
//		System.out.println("file 1 length:" + file1.length());
//		System.out.println("file 2 length:" + file2.length());
	    
		if (file1.length() != file2.length()) {
	      areFilesIdentical = false;
	    }
	   
	    try {
	        FileInputStream fis1 = new FileInputStream(file1);
	        FileInputStream fis2 = new FileInputStream(file2);
	        
	        int i1 = fis1.read();
	        int i2 = fis2.read();
	        
	        while (i1 != -1) {
	          if (i1 != i2) {
	            areFilesIdentical = false;
	            break;
	          }
	          i1 = fis1.read();
	          i2 = fis2.read();
	        }
	        
	        System.out.println("Output: file 1 and file 2:");
	        System.out.print("Result: ");
	        if (areFilesIdentical) {
	        	System.out.println("identical content");
	        	System.out.println("character length for both: " + file1.length());
	        } else {
	        	System.out.println("different content");
	        	System.out.println("character length for file 1: " + file1.length());
	        	System.out.println("character length for file 2: " + file2.length());
	        }
	       
	        fis1.close();
	        fis2.close();
	        
	      } catch (IOException e) {
	        System.out.println("IO exception");
	        areFilesIdentical = false;
	      }
	}
	
}