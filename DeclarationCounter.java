import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Scanner;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class DeclarationCounter {
	
	private String pathName;
	private String javaTypeName;
	public int declarationsFound = 0;
	public int referencesFound = 0;
	
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
	
	public void parseDirectory(String pathName, String javaTypeName, int declarationsFound, int referencesFound) {
		ASTParser parser = ASTParser.newParser(AST.JLS9);
		String str = sourceToString(getPathName());
		parser.setSource(str.toCharArray()); // TODO: Which string to parse
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);

		//cu.accept(new ASTVisitor()) {
			// TODO: Continue here
		//}
	}
	
	
	public void findJavaFiles(String pathName) throws IOException {
		final File directory = new File(pathName);
		File[] listOfFiles = directory.listFiles(new FilenameFilter() {
			public boolean accept(File directory, String name) {
				return name.endsWith(".java");
			}
		});
		for (File file : listOfFiles) {
			if (file.isFile()) {
				String fileString = sourceToString(file.getName());
				//Call ASTParser with string
			}
		}
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
    
    public void printOutput() {
    	String jtn = getJavaTypeName();
    	System.out.println(jtn + ". Declarations found: " + 
    			declarationsFound + "; references found: " + referencesFound);
    }
}
