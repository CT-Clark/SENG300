import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

package astParserProject;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class Test_JavaFileParser {
	private static String BASEDIR = "C:\\Users\\Sarah\\Documents\\SENG300\\GroupIteration2";
	private JavaFileParser contentParser;
	
	@Before
	public void setup(){
		contentParser = new JavaFileParser();
	}
	
	@After
	public void teardown(){
		
	}
	
	@Test
	public void simpleCountDeclarationTest() throws IOException{
		String[] names = { "A.java", "B.java" };
		String sourcePath = BASEDIR+"\\test";
		String targetType = "A";
		int[] results = contentParser.parse(names, sourcePath, targetType);
		assertEquals(1, results[0]);
	}
	
	@Test
	public void simpleCountReferenceTest() throws IOException{
		String[] names = { "A.java", "B.java" };
		String sourcePath = BASEDIR+"\\test";
		String targetType = "A";
		int[] results = contentParser.parse(names, sourcePath, targetType);
		assertEquals(4, results[1]);
	}
}
