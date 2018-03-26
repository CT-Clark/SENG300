package astParserProject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * Runs all tests from the three test suites for the project.
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ Test_JavaFileParser.class, Test_ProjectMain.class, Test_Integration.class })
public class Test_Suite {
}
