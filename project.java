/* Main file
 *
 * Contributors: Cody Clar, Scott Eveleigh, Daniel Nwaroh
 * Created: March 5, 2018
 *
 * TODO: Provide description of what this program does
 */
import java.io.*;
//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
//import java.util.Scanner;
import java.util.Set;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.*;
//import org.eclipse.jdt.core.dom.SimpleName;
//import org.eclipse.jdt.core.dom.TypeDeclaration;
//import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

 
public class project {
	private static String pathName;
	private static String javaTypeName;
	
	enum Quark{ UP, DOWN}
	
	// Parses the java file to find declarations and references of a particular Java type
	public static void parse(String str, Results results) {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(str.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setResolveBindings(true);
 
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
 
		cu.accept(new ASTVisitor() {
 
			Set<String> names = new HashSet<String>();
			
			String a;
			
			// TODO: Find the declarations node type, find the references node type
			// After that it's really just logic and string checking
			/*
			public boolean visit(TypeDeclaration node) {
				SimpleName name = node.getName();
				this.names.add(name.getIdentifier());
				if (name.getIdentifier() == results.type) {
					System.out.println("Declaration of '" + name + "' at line"
							+ cu.getLineNumber(name.getStartPosition()));
					
					results.declarations++;
				}
				System.out.println(results.declarations);
				return false; // do not continue 
			}
			*/
			
			public boolean visit(AnnotationTypeDeclaration node) {
				SimpleName name = node.getName();
				System.out.println(name);
				return false;
			}
			
			public boolean visit(EnumDeclaration node) {
				SimpleName name = node.getName();
				System.out.println(name);
				return false;
			}
			
			public boolean visit(TypeDeclaration node) {
				SimpleName name = node.getName();
				System.out.println(name);
				return false;
			}
 
			public boolean visit(SimpleType node) {
				
				System.out.println(node.getName());
				return true;
			}
		});
 
	}
    
	// Generates the path names to the java files within the specified directory
	// Returns the filepath as a string to pass to the parser
	public static String readFileToString(String filePath) throws IOException {
		StringBuilder fileData = new StringBuilder(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
 
		char[] buf = new char[10];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			//System.out.println(numRead);
			String readData = String.valueOf(buf, 0, numRead);
			fileData.append(readData);
			buf = new char[1024];
		}
 
		reader.close();
 
		return  fileData.toString();	
	}
	
	public static void main(String[] args) {
    	Results results = new Results();
    	
    	// Gets the path name and Java type to search as command line arguments
    	// Then it creates an array of java files contained within the directory
    	try {
    		pathName = args[0];
    		javaTypeName = args[1];
    		results.type = javaTypeName;

            File[] files = new File(pathName).listFiles();
            //If this pathname does not denote a directory, then listFiles() returns null. 

            for (File file : files) {
                if (file.isFile() && file.getName().contains(".java")) {
                    parse(readFileToString(file.getAbsolutePath()), results);
                    //System.out.println(file.getAbsolutePath());
                }
            }
            
    	} catch (ArrayIndexOutOfBoundsException e) {
    		System.out.println("Not enough arguments, please provide the pathname and the Java type.\n");
    	} catch (NullPointerException e) {
    		System.out.println("That directory does not exist, please provide a correct directory.\n");
    	} catch (IOException e) {
    		System.out.println("IOException");
    	}
    	
    	results.printResults();
    }
}

final class Results {
	int declarations = 0;
	int references = 0;
	String type;
	
	public void printResults() {
		System.out.println("Total declarations of "+type+": "+this.declarations);
		System.out.println("Total references of "+type+": "+this.references);
	}
}

final class DoesItWork{}
/*
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
}
*/
