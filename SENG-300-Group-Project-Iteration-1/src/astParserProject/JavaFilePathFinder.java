package astParserProject;
import java.io.File;
import java.util.ArrayList;

/**
 * Class that gets a list of paths to .java files
 * 
 */
public class JavaFilePathFinder {

	/**
	 * METHOD: getJavaFiles()
	 * <p>
	 * Use this to get all the .java files from a directory
	 * 
	 * @param directoryPath
	 * 			A String that is assigned to the path of the target directory
	 * 
	 * @return
	 * 			A String[] of paths to all the .java files in the target directory
	 * @throws IllegalArgumentException 
	 *          If the path of the target directory doesn't exist
	 */
	public String[] getJavaFiles(String directoryPath) throws IllegalArgumentException{ 
		
		if (directoryPath == null){
			throw new IllegalArgumentException();
		}
		//Initialize an String ArrayList for the java file paths
		ArrayList<String> javaFilesList = new ArrayList<String>();
		//Get the directory that is assigned to the user's path
		File directory = new File(directoryPath);
		//IF: the given directory path IS a directory, get the java files
		if(directory.isDirectory() == true) {
			//Get a a list of all the files in the directory
			File[] javaFiles = directory.listFiles();
			//FOR: each file in the directory, do a series of checks
			for(int i = 0;i < javaFiles.length;i++) {
				//IF: the file is NOT a directory, continue to the next check
				if(javaFiles[i].isDirectory() == false){
					//Get the file extension of the file
					String filePath = javaFiles[i].toString();
					String fileExtension = filePath.substring(filePath.lastIndexOf("."));
					//IF: the file extension IS .java (Java file), add it's name to the ArrayList
					if(fileExtension.equals(".java")){
						javaFilesList.add(javaFiles[i].getName());
					}
				}
			}
			//Create a String[] for the java file paths
			String[] javaFilesPaths = new String[javaFilesList.size()];
			//FOR: convert the ArrayList for the java file paths into a String[]
			for(int i = 0;i < javaFilesList.size();i++) {
				javaFilesPaths[i] = javaFilesList.get(i);
			}
			//RETURN: a String[] that holds all the paths for all java files in the directory
			return javaFilesPaths;
		}
		//ELSE: the given directory path is NOT a directory, throw an exception
		else {
			throw new IllegalArgumentException();
		}
	}

}
