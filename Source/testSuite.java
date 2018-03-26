
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * Runs all tests from the three test suites for the project.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ JavaFileParserTest.class})
public class testSuite {
	static {
		new JavaFileParserTest();
	}
}