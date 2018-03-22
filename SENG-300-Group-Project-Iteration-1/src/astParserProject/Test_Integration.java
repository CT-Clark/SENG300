package astParserProject;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Integration testing on the backend and frontend as used in ProjectMain
 *
 */
public class Test_Integration {
	private static String BASEDIR = "C:\\Users\\Jaydon\\git\\SENG-300-Group-Project-Iteration-1-1\\SENG-300-Group-Project-Iteration-1";
	@Before
	public void setup(){
		
	}
	
	@After
	public void teardown(){
		// Restore the static field counts to null after running the test
		ProjectMain.counts = null;
	}
	/*
	 * Tests to find the references of class types
	 */
	@Test
	public void validPathDeclarationCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "A";
		String[] input = {targetType, sourcePath};
		
		ProjectMain.main(input);
		
		assertEquals(1, ProjectMain.counts[0]);
	}
	
	/*
	 * Tests to find the references of class types
	 */
	@Test
	public void validPathReferenceCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "A";
		String[] input = {targetType, sourcePath};
		
		ProjectMain.main(input);

		
		assertEquals(4, ProjectMain.counts[1]);
	}
	/*
	 * Tests to find the references of Primative types
	 */
	@Test
	public void validPathReferencePrimativeCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "int";
		String[] input = {targetType, sourcePath};
		
		ProjectMain.main(input);
		
		
		assertEquals(1, ProjectMain.counts[1]);
	}
	/*
	 * Tests to find the declarations of Simple types
	 */
	@Test
	public void validPathDeclarationSimpleCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "java.lang.Integer";
		String[] input = {targetType, sourcePath};
		
		ProjectMain.main(input);
		assertEquals(1, ProjectMain.counts[1]);
	}
	
	/*
	 * WE DID FIND A BUG WITH ENUM BUT DID NOT HAVE TIME TO RESOLVE IT
	 * Tests to find declarations to Enums
	 */
	@Test
	public void validPathDeclarationEnumCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "e";
		String[] input = {targetType, sourcePath};
		
		ProjectMain.main(input);
		assertEquals(1, ProjectMain.counts[0]);
	}
	
	/*
	 * WE DID FIND A BUG WITH ANNOTATION BUT DID NOT HAVE TIME TO RESOLVE IT
	 * Tests to find declarations to annotations
	 */
	@Test
	public void validPathDeclarationAnnotationCounts() throws IllegalArgumentException, IOException{
		String sourcePath = BASEDIR + File.separator + "test" + File.separator +"GoodExtensions";
		String targetType = "Overide";
		String[] input = {targetType, sourcePath};
		
		
		ProjectMain.main(input);
		System.out.println(ProjectMain.counts[0]);
		assertEquals(1, ProjectMain.counts[0]);
	}
	
	
	
	
}
