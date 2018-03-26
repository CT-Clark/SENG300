
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

/**
 * 
 * Unit testing for the front end which handles input directory
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


