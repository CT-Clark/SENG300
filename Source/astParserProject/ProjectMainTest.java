package astParserProject;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

/**
 * 
 * Unit testing for the frontend and TypeFinderVisitor, which handles input and counting of
 * declarations and references
 *
 */
public class ProjectMainTest {
	
	@After
	public void teardown(){
		ProjectMain.hMapCount = null;
	}
	
	/**
	 * Test main called with null as input, this is not allowed.
	 * Ensures program won't crash due to misuse
	 */
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidArgument() throws IllegalArgumentException, IOException{
		String[] badString = {null};
		ProjectMain.main(badString);
	}

	
}


