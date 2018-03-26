import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class JavaFileParser {
	private ASTParser parser;

	/**
	 * 
	 * @param names An array containing the names of .java files in sourcePath, the names must include the .java extension
	 * @param sourcePath A string representing the path of the files being considered
	 * @param typeName A string containing the fully qualified name of the type whose declarations and references are being counted
	 * @return An integer array of length 2 with the first element containing the number of declarations of typeName counted,
	 * and the second element containing the number of references to typeName counted.
	 * @throws IOException If an I/O error occurs while opening or reading the file
	 */
	public HashMap<String, int[]> parse(String[] names, String sourcePath) throws IOException {
		parser = ASTParser.newParser(AST.JLS8);
		TypeFinderVisitor typeFinder = new TypeFinderVisitor();
		
		
		HashMap<String, int[]> hMapJFP = new HashMap<String, int[]>();

		for (int i = 0; i < names.length; i++) {
			// Configure the parser.
			
			
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			
			//Map<String, String> options = JavaCore.getOptions();
			Map options = JavaCore.getOptions();
			JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
			parser.setCompilerOptions(options);
			
			parser.setEnvironment(new String[] {}, new String[] { sourcePath }, null, true);
			
		
			
			parser.setSource(names[i].toCharArray());
			// Create the ast for the input file
			CompilationUnit ast = (CompilationUnit) parser.createAST(null);
			
			ast.accept(typeFinder);
			
			
			
		}
	
		return typeFinder.hMap;
	}

}
