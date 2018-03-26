package astParserProject;

import java.util.HashMap;
import javax.lang.model.type.ArrayType;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.NameQualifiedType;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;


/**
	 * 
	 * A class which extends ASTVisitor and tracks is used to track the number of occurrences of targetType
	 * in an AST.
	 *
	 */
public class TypeFinderVisitor extends ASTVisitor {
	
		public HashMap<String, int[]> hMap = new HashMap<String, int[]>();
		
		public boolean visit(TypeDeclaration node) {
			
			// Checks if the hash map contains node already
			 // If it does then add 1 to its declarations
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[0]++;
			// If not then add it to the hash map with 1 reference			
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}
			
			return true;
		}
		
		
		public boolean visit(SingleMemberAnnotation node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
			// If not then add it to the hash map with 1 reference			
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		public boolean visit(NormalAnnotation node) {

			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
			// If not then add it to the hash map with 1 reference		
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		
		public boolean visit(MarkerAnnotation node) {
		
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
					
			// If not then add it to the hash map with 1 reference		
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		
		
		
		public boolean visit(AnnotationTypeDeclaration node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its declarations 
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[0]++;
			// If not then add it to the hash map with 1 declarations				
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}

			return true;
		}
		
	
		
	
		public boolean visit(EnumDeclaration node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its declarations 
			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.toString());
				item[0]++;
			// If not then add it to the hash map with 1 declarations				
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}

			return true;
		}
		
		
		public boolean visit(PrimitiveType node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
			// If not then add it to the hash map with 1 reference				
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		}
		
		public boolean visit(SimpleType node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
				
			// If not then add it to the hash map with 1 reference		
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.getName().toString(), tempArray);
			}
			return true;
		}
		
		
		
		
		public boolean visit(ArrayType node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
				
			// If not then add it to the hash map with 1 reference	
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		}
		
		
		
		
		public boolean visit(QualifiedType node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.getName().toString())){
							
				int[] item = hMap.get(node.getName().toString());
				item[1]++;
				
			// If not then add it to the hash map with 1 reference
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		
		
		
		public boolean visit(NameQualifiedType node) {
			
			// Checks if the hash map contains node already
			// If it does then add 1 to its references
			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[1]++;
				
			// If not then add it to the hash map with 1 reference					
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		
	
		
	

	}