/* Main file
 *
 * Contributors: Cody Clark, Scott Eveleigh, Daniel Nwaroh
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
import java.io.*;
import java.io.FileReader;
import java.util.Scanner;

 
public class project {
	private static String pathName;
	private static String javaTypeName;
    
    public static void main(String[] args) {
    	int declarationsFound = 0;
    	int referencesFound = 0;
    	boolean success = true;
    	//String str = args[0];
    	
    	// Gets the path name and Java type to search as command line arguments
    	try {
    		pathName = args[0];
    		javaTypeName = args[1];
    	} catch (ArrayIndexOutOfBoundsException e) {
    		success = false;
    		System.out.println("Not enough arguments, please provide the pathname and the Java type.\n");
    	} if (success) {
    		// Prints out the result
        	System.out.println(javaTypeName + ". Declarations found: " + 
        			declarationsFound + "; references found: " + referencesFound);
    	}
		//declarationsFound =
    	//referencesFound = 
    	
		
    }
    
    public String sourceToString(String pathName) {
    	Scanner input = null;
    	StringBuilder sb = new StringBuilder();
    	String sourceString = "";
    	try {
    		input = new Scanner(new File(pathName));
    		while (input.hasNextLine()) {
    			String line = input.nextLine();
    			sb.append(line);
    			sb.append("\r\n");
    		}
    		input.close();
    		sourceString =  sb.toString();
    	}
    	catch (FileNotFoundException fnfe) {
    		System.out.println("File not Found");
    	}
    	return sourceString;
    }
    
    /*
	 * TODO: Javedoc formatting, parse the source
	 */
	public void parseDirectory(String pathName, String javaTypeName, int declarationsFound, int referencesFound) {
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		String str = sourceToString(pathName);
		parser.setSource(str.toCharArray()); // TODO: Which string to parse
		parser.setKind(ASTParser.K_COMPILATION_UNIT); //Sets sourced to be parsed

		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		cu.accept(new ASTVisitor() {
			// TODO: Continue here
			public boolean visit(VariableDeclarationFragment node) {
				SimpleName name = node.getName();
				int lineNumber = cu.getLineNumber(name.getStartPosition());
				System.out.println(name.toString());
				System.out.println(lineNumber);
				return false;
				}
			});
		}
	
}