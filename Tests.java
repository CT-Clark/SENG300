import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class Tests {
	private static String BASEDIR = "C:/Users/Scott Eveleigh/Documents/GitHub/SENG300/ParseTestFiles";
	
	
	//Test for the sourceToString method
	@Test
	public void testForSourceToString() {
		DeclarationCounter dc = new DeclarationCounter();
		String fileContents = "public class ClassForTesting {\r\n" + 
				"	public void Method() {\r\n" + 
				"		int num = 12;\r\n" + 
				"        String place = \"Calgary\";\r\n" + 
				"        place = \"Nowhere\";\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"";
		String stringOfFile = dc.sourceToString("ClassForTesting.java");
		assertEquals(stringOfFile, fileContents);
	}
	
	//Unfinished test
	@Test
	public void testFindJavaFiles() {
		DeclarationCounter dc = new DeclarationCounter();
		try {
			dc.findJavaFiles(BASEDIR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	@Test
	public void testDeclarations() {
		DeclarationCounter dc = new DeclarationCounter();
		try {
			dc.findJavaFiles(BASEDIR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
