package astParserProject;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Unit tests for the backend of the system. The backend handles parsing and analysis of the files.
 *
 */
public class Test_JavaFileParser {
	private static String BASEDIR = "C:\\Users\\Kyle\\git\\SENG-300-Group-Project-Iteration-1\\SENG-300-Group-Project-Iteration-1";
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
