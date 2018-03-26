package astParserProject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
public class ProjectMain {
	//static int[] counts;
	public static HashMap<String, int[]> hMapCount = new HashMap<String, int[]>();

	/**
	 * 
	 * @param args A string array of command line arguments where the first argument is the type to count and the second argument is the path to
	 *  folder of interest
	 * @throws IOException When file I/O errors occur
	 * @throws IllegalArgumentException When the given path is not to a folder
	 */
	public static void main(String[] args) throws IOException, IllegalArgumentException {
		
		String targetType = args[0];
		String sourcePath = args[1];
		JavaFilePathFinder fileFinder = new JavaFilePathFinder();
		String[] fileNames = fileFinder.getJavaFiles(sourcePath);
		
		JavaFileParser backend = new JavaFileParser();
		hMapCount = backend.parse(fileNames, sourcePath, targetType);
		
		
		
		 /* Display content using Iterator*/
	      Set set = hMapCount.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         int decs = hMapCount.get(mentry.getKey())[0];
	         int refs = hMapCount.get(mentry.getKey())[1];
	         System.out.println(mentry.getKey() + " Declarations Found: " +decs + " References Found: " + refs );
	     
	      }

	      
		


		
		
		

	}

}
