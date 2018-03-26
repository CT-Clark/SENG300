package astParserProject;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * 
 * Unit testing for the frontend, which handles input and finding files
 *
 */
public class Test_ProjectMain {
	private static String BASEDIR = "C:\\Users\\Kyle\\git\\SENG-300-Group-Project-Iteration-1\\SENG-300-Group-Project-Iteration-1";
	private JavaFilePathFinder frontEnd;
	
	@Before
	public void setup(){
		frontEnd  = new JavaFilePathFinder();
	}
	
	/**
	 * Test an invalid input where the path is to a nonexistent directory
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nonExistentPath(){
		frontEnd.getJavaFiles(BASEDIR+"\\test\\thisIsntReal");
	}
	
	/**
	 * Test when an invalid input where the path is that of an existing file
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalidPathFile(){
		frontEnd.getJavaFiles(BASEDIR+"\\test\\A.java");
	}
	
	@Test
	public void validPath(){
		// Both arrays are sorted because we care about the contents of the array, not the precise order of its elements.
		String[] expected = new String[] {"A.java", "B.java", "C.java", "D.java"};
		Arrays.sort(expected);
		
		String[] results = frontEnd.getJavaFiles(BASEDIR+"\\test");
		Arrays.sort(results);
		
		assertArrayEquals(expected, results);
	}
}
