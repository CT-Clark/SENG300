import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class DeclarationCounter {
	
	private String pathName;
	private String javaTypeName;
	public int declarationsFound = 0;
	public int referencesFound = 0;
	public int x = 0;
	public ArrayList<String> refs = new ArrayList<String>();
	
	public String getPathName() { 
		return pathName;
	}
	
	public String getJavaTypeName() { 
		return javaTypeName;
	}

	
	public void setArgs(String[] args) {
		try {
    		pathName = args[0];
    		javaTypeName = args[1];
    	} catch (ArrayIndexOutOfBoundsException e) {
    		System.out.println("Not enough arguments, please provide the pathname and the Java type.\n");
    	}
	}
	
	//Method to parse and count declarations and references
	public void parseDirectory(String pathName) {//, String javaTypeName, int declarationsFound, int referencesFound) {
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		//String str = sourceToString(pathName);
		parser.setSource(pathName.toCharArray()); // TODO: Which string to parse
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		cu.accept(new ASTVisitor() {
			
			public boolean visit(SimpleType node) {
				String jtn = getJavaTypeName();
				//String jtn = "java.lang.String";
				Name name = node.getName();
				System.out.println("SimpleType " + name + "  " + name.getFullyQualifiedName());
				if (name.getFullyQualifiedName().equals(jtn)) {
					declarationsFound++;
					x = 1;
				}
				
				return false;
			}
			
			public boolean visit(SimpleName node) {
				String name = node.getFullyQualifiedName();
				if (x == 1) {
					refs.add(name);
					x = 0;
				}
				for (int i = 0; i < refs.size(); i++) {
					if (name.equals(refs.get(i))) {
						referencesFound++;
					}
				}
				System.out.println(name);
				return true;
			}
			// TODO: Continue here
		});
	}
	
	//This method checks the given directory for .java files
	//Then passes them to "sourceToString" to make them strings
	//Then to "parseDirectory" to parse them
	public void findJavaFiles() {//String pathName) {
		String pathName = getPathName();
		final File directory = new File(pathName);
		File[] listOfFiles = directory.listFiles(new FilenameFilter() {
			public boolean accept(File directory, String name) {
				return name.endsWith(".java");
			}
		});
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String fileString = sourceToString(file.getAbsolutePath());
				System.out.println(fileString);
				parseDirectory(fileString);
				System.out.println(declarationsFound + " " + referencesFound);
			}
		}
	}
	
	//This method converts a file to one string. It takes the pathname of the file
	//As an argument
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
    
    //This method prints the output of the parsing to the console
    public void printOutput() {
    	String jtn = getJavaTypeName();
    	System.out.println(jtn + ". Declarations found: " + 
    			declarationsFound + "; references found: " + referencesFound);
    }
}
