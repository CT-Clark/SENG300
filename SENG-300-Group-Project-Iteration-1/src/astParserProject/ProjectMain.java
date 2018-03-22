package astParserProject;
import java.io.IOException;

public class ProjectMain {
	static int[] counts;

	/**
	 * 
	 * @param args A string array of command line arguments where the first argument is the type to count and the second argument is the path to
	 *  folder of interest
	 * @throws IOException When file I/O errors occur
	 * @throws IllegalArgumentException When the given path is not to a folder
	 */
	public static void main(String[] args) throws IOException, IllegalArgumentException {
		counts = new int[9];
		
		String targetType = args[0];
		String sourcePath = args[1];
		JavaFilePathFinder fileFinder = new JavaFilePathFinder();
		String[] fileNames = fileFinder.getJavaFiles(sourcePath);
		
		JavaFileParser backend = new JavaFileParser();
		counts = backend.parse(fileNames, sourcePath, targetType);
		


		
		
		System.out.println("Simple Type" + ". Declarations found: " + counts[0] + "; references found: " + counts[1] + ".");
		System.out.println("Annotation Type" + ". Declarations found: " + counts[2] + "; references found: " + counts[3] + ".");
		System.out.println("Interface Type" + ". Declarations found: " + counts[4] + "; references found: " + counts[5] + ".");
		System.out.println("Enum Type" + ". Declarations found: " + counts[6] + "; references found: " + counts[7] + ".");
		System.out.println("Primative Type" + ". Declarations found: " + counts[8] + "; references found: " + counts[9] + ".");

	}

}
