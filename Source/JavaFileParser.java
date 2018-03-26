package astParserProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
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
	 * @return A hash map containing the types as keys and an array of the number of declarations and references as the information
	 * and the second element containing the number of references to typeName counted.
	 * @throws IOException If an I/O error occurs while opening or reading the file
	 */
	public HashMap<String, int[]> parse(String[] names, String sourcePath) throws IOException {
		
		// Initilize the parser and visitor
		parser = ASTParser.newParser(AST.JLS8);
		TypeFinderVisitor typeFinder = new TypeFinderVisitor();
		
		
		// For loop to iterate through each .java file
		for (int i = 0; i < names.length; i++) {
			
			// Configure the parser.
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			Map options = JavaCore.getOptions();
			JavaCore.setComplianceOptions(JavaCore.VERSION_1_5, options);
			parser.setCompilerOptions(options);
			parser.setEnvironment(new String[] {}, new String[] { sourcePath }, null, true);
			
			
			
			// Create the path and set the unit name
			String path = sourcePath + "\\" + names[i];
			parser.setUnitName(names[i]);

			// Read the contents of the given .java file into a StringBuilder object
			StringBuilder inputSource = new StringBuilder();
			BufferedReader inputFile = Files.newBufferedReader(Paths.get(path), Charset.defaultCharset());

			String result = "";
			do {
				result = inputFile.readLine();
				if (result != null) {
					inputSource.append(result);
				}
			} while (result != null);

			// Set the parser's source to be input file's contents
			parser.setSource(inputSource.toString().toCharArray());
			
			// Create the ast for the input file
			CompilationUnit ast = (CompilationUnit) parser.createAST(null);
			
			ast.accept(typeFinder);
			
			
			
		}
		// Return the hash map made from the parser
		return typeFinder.hMap;
	}

}
