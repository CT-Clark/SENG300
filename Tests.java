import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tests {

	//Test for the sourceToString method
	@Test
	public void testForSourceToString() {
		project p = new project();
		String fileContents = "public class ClassForTesting {\r\n" + 
				"	public void Method() {\r\n" + 
				"		\r\n" + 
				"	}\r\n" + 
				"}\r\n" + 
				"";
		String stringOfFile = p.sourceToString("ClassForTesting.java");
		assertEquals(stringOfFile, fileContents);
	}
}
