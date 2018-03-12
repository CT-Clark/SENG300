/* Main file
 *
 * Contributors: Cody Clar, Scott Eveleigh, Daniel Nwaroh
 * Created: March 5, 2018
 *
 * TODO: Provide description of what this program does
 */
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
 
public class project {
	private static String pathName;
	private static String javaTypeName;
    
    public static void main(String[] args) {
    	int declarationsFound = 0;
    	int referencesFound = 0;
    	
    	// Gets the path name and Java type to search as command line arguments
    	try {
    		pathName = args[0];
    		javaTypeName = args[1];
    	} catch (ArrayIndexOutOfBoundsException e) {
    		System.out.println("Not enough arguments, please provide the pathname and the Jave type.\n");
    	}
    	
		/*
		 * TODO: Javedoc formatting, parse the source
		 */
		public void parseDirectory(String pathName, String javaTypeName, int declarationsFound, int referencesFound) {
			ASTParser parser = ASTParser.newParser(AST.JLS9);
			parser.setSource(str.toCharArray()); // TODO: Which string to parse
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
 
			final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
 
			cu.accept(new ASTVisitor() {
				// TODO: Continue here
			}
		}
				
		//declarationsFound =
    	//referencesFound = 
    	
		// Prints out the result
    	System.out.println(javaTypeName + ". Declarations found: " + 
    			declarationsFound + "; references found: " + referencesFound);
    }
}
