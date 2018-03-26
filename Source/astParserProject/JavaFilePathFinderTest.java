package astParserProject;
import static org.junit.Assert.*;

import java.io.File;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Unit tests for the path finder that is used to find .java files in a directory.
 *
 */
public class JavaFilePathFinderTest {

	private static String BASEDIR = "C:\\Users\\Sarah\\SENG300";
	private JavaFilePathFinder pathFinder;
	
	@Before
	public void setup(){
		pathFinder = new JavaFilePathFinder();
	}
	
	@After
	public void teardown(){
		
	}
	
	/*
	 * Tests the case if the path finder is called with a null value String
	 * Should throw an IllegalArgumentException since that type of input is not allowed
	 * This helps makes sure the program won't crash due to misuse 
	 */
	@Test (expected = IllegalArgumentException.class)
	public void null_input(){
		
		String str;
		str = null;
		pathFinder.getJavaFiles(str);
		
	}

	/*
	 * Test the case if path finder is called with a string that is not a directory.
	 * Should throw an IllegalArgumentException since that type of input is not allowed
	 * This helps makes sure the program won't crash due to misuse
	 */
	@Test (expected = IllegalArgumentException.class)
	public void nondirectory_input(){
		
		String str;
		str = "NotADirectory";
		pathFinder.getJavaFiles(str);
		
	}


	/*
	 * Tests the case where use of where all files in the directory are .java files
	 * Should return the .java that were in the directory
	 * This helps makes sure the program works in normal use cases
	 */
	@Test 
	public void allFilesJava(){
			
			String str;
			str = BASEDIR + File.separator + "\\tests\\GoodExtensions";
			String[] results = pathFinder.getJavaFiles(str);
			
			String [] expected  =  new String[] {"A.java","B.java","C.java","D.java","E.java"};
			assertArrayEquals(expected, results);
			
		}
	
	/*
	 * Tests the case where use of where some files in the directory are .java files
	 * Should return the .java that were in the directory
	 * This helps makes sure the program works in normal use cases
	 */
	@Test 
	public void someFilesJava(){
			
			String str;
			str = BASEDIR + File.separator + "\\tests\\MixExtensions";
			String[] results = pathFinder.getJavaFiles(str);
			
			String [] expected  =  new String[] {"A.java","B.java"};
			assertArrayEquals(expected, results);
			
	}
	
	/*
	 * Tests the case where use of where none of the files in the directory are .java files
	 * Should return the .java that were in the directory
	 * This helps makes sure the program works in normal use cases
	 */
	@Test 
	public void NoFilesJava(){
			
			String str;
			str = BASEDIR + File.separator + "\\tests\\BadExtensions";
			String[] results = pathFinder.getJavaFiles(str);
			
			String [] expected  =  new String[] {};
			assertArrayEquals(expected, results);
			
	}
}