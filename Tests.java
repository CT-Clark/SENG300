import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class Tests {

	//Test for the sourceToString method
	@Test
	public void testForSourceToString() {
		DeclarationCounter dc = new DeclarationCounter();
		String fileContents = "public class ClassForTesting {\r\n" + 
				"	public void Method() {\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"";
		String stringOfFile = dc.sourceToString("ClassForTesting.java");
		assertEquals(stringOfFile, fileContents);
	}
	
	//Should print only the java files in directory to console
	@Test
	public void testParseDirectory() {
		DeclarationCounter dc = new DeclarationCounter();
		try {
			dc.findJavaFiles("C:/Users/Scott Eveleigh/Documents/GitHub/SENG300");
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		
	}
}
