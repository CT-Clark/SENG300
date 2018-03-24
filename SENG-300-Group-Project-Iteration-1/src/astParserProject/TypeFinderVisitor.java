package astParserProject;

import java.util.HashMap;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.UnionType;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleMemberAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IntersectionType;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.NameQualifiedType;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WildcardType;

/**
	 * 
	 * A class which extends ASTVisitor and tracks is used to track the number of occurrences of targetType
	 * in an AST.
	 *
	 */
public class TypeFinderVisitor extends ASTVisitor {
	
		public HashMap<String, int[]> hMap = new HashMap<String, int[]>();
	
		
	
		



	
		
		public boolean visit(TypeDeclaration node) {
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[0]++;
							
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}
			
			return true;
		}
		
		
		public boolean visit(SingleMemberAnnotation node) {
			//ITypeBinding bind = node.resolveBinding();

			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		public boolean visit(NormalAnnotation node) {
			//ITypeBinding bind = node.resolveBinding();

			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		
		public boolean visit(MarkerAnnotation node) {
			//ITypeBinding bind = node.resolveBinding();

			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}

			return true;
		}
		
		
		
		
		public boolean visit(AnnotationTypeDeclaration node) {
			//ITypeBinding bind = node.resolveBinding();

			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[0]++;
							
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}

			return true;
		}
		
	
		
	
		public boolean visit(EnumDeclaration node) {
			//ITypeBinding bind = node.resolveBinding();

			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.toString());
				item[0]++;
							
			}else{
				int[] tempArray = {1,0};
				hMap.put(node.getName().toString(), tempArray);
			}

			return true;
		}
		
		
		public boolean visit(PrimitiveType node) {
			//System.out.println(node.toString());
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		}
		
		public boolean visit(SimpleType node) {
			
			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
				
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.getName().toString(), tempArray);
			}
			return true;
		}
		/*
		public boolean visit(QualifiedType node) {
			//System.out.println(node.toString() + "QualifiedType");
			
			if (hMap.containsKey(node.getName().toString())){
							
				int[] item = hMap.get(node.getName().toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		*/
		
		/*
		public boolean visit(NameQualifiedType node) {
			//System.out.println(node.toString() + "NameQualifiedType");
			
			if (hMap.containsKey(node.getName().toString())){
				
				int[] item = hMap.get(node.getName().toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		*/
		
		/*
		public boolean visit(WildcardType node) {
			//System.out.println(node.toString() + "WildcardType");
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		*/
		
		
		public boolean visit(ArrayType node) {
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		}
		
		/*
		public boolean visit(ParameterizedType node) {
			//System.out.println(node.toString() + "ParameterizedType");
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		} 
		*/
		
		
		/*
		public boolean visit(UnionType node) {
			//System.out.println(node.toString() + "UnionTyp");
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			
			return true;
		}
		*/
		
		/*
		public boolean visit(IntersectionType node) {
			//System.out.println(node.toString()+ "IntersectionType");
			
			if (hMap.containsKey(node.toString())){
				
				int[] item = hMap.get(node.toString());
				item[1]++;
							
			}else{
				int[] tempArray = {0,1};
				hMap.put(node.toString(), tempArray);
			}
			return true;
		}
		*/
		

	}