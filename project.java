/* Main file
 *
 * Contributors:
 * Created: March 5, 2018
 *
 */
 
public class project {
	private static String pathName;
	private static String javaTypeName;
    public static void main(String[] args) {
    	int declarationsFound = 0;
    	int referencesFound = 0;
    	
    	
    	try {
    		pathName = args[0];
    		javaTypeName = args[1];
    	} catch (ArrayIndexOutOfBoundsException e) {
    		
    	}
    	
    	//declarationsFound =
    	//referencesFound = 
    	
    	System.out.println(javaTypeName + ". Declarations found: " + 
    			declarationsFound + "; references found: " + referencesFound);
    }
}
