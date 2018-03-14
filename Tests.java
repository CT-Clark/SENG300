import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class Tests {
	private static String BASEDIR = "C:/Users/Scott Eveleigh/Documents/GitHub/SENG300/ParseTestFiles";
	private static String fileContents = "public class ClassForTesting {\r\n" + 
			"	public void Method() {\r\n" + 
			"        String[] list = {\"one\",\"two\"};\r\n" + 
			"		int num = 12;\r\n" + 
			"        String place = \"Calgary\";\r\n" + 
			"        place = \"Nowhere\";\r\n" + 
			"        java.lang.String person = \"Bob\";\r\n" + 
			"        person = \"ted\";\r\n" + 
			"        java.lang.String people = \"Group\";\r\n" + 
			"        lang.String pop = \"Sprite\";\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"";
	
	//Test for the sourceToString method
	@Test
	public void testForSourceToString() {
		DeclarationCounter dc = new DeclarationCounter();
		String stringOfFile = dc.sourceToString("ParseTestFiles/ClassForTesting.java");
		assertEquals(stringOfFile, fileContents);
	}
	
	//Test for the output printing
	@Test
	public void testPrintOutput() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		DeclarationCounter dc = new DeclarationCounter();
		String[] list = {"C:/Users","java.lang.String"};
		dc.setArgs(list);
		dc.printOutput();
		assertEquals("java.lang.String. Declarations " + 
				"found: 0; references found: 0\r\n", outContent.toString());
		System.setOut(System.out);
	}
	
	//Test to check for correct counting values
	@Test
	public void testDeclarations() {
		DeclarationCounter dc = new DeclarationCounter();
		String[] arg = {BASEDIR, "java.lang.String"};
		dc.setArgs(arg);
		dc.findJavaFiles();
		assertEquals(2, dc.declarationsFound);
		assertEquals(3, dc.referencesFound);
	}
	
	//Test for passing the argument values
	@Test
	public void testSetArgs() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		DeclarationCounter dc = new DeclarationCounter();
		String[] arg = {"bad"};
		dc.setArgs(arg);
		
		assertEquals("Not enough arguments, please provide the pathname and the Java type.\r\n", outContent.toString());
		System.setOut(System.out);
	}
	
	//Test for cannot find .java files
	@Test
	public void testNoJavaFiles() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		DeclarationCounter dc = new DeclarationCounter();
		String[] list = {"", "java.lang.String"};
		dc.setArgs(list);
		dc.findJavaFiles();
		assertEquals("Could not find any .java files\r\n", outContent.toString());
		System.setOut(System.out);
	}
}
