package astParserProject;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
	 * 
	 * A class which extends ASTVisitor and tracks is used to track the number of occurrences of targetType
	 * in an AST.
	 *
	 */
public class TypeFinderVisitor extends ASTVisitor {
		//public int[] refsAndDecsCount = new int[10];
		//refsAndDecsCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
		int[] refsAndDecsCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		//refsAndDecCount[0] = Simple declaration
		//refsAndDecCount[1] = Simple references 
		//refsAndDecCount[2] = Annotation declaration
		//refsAndDecCount[3] = Annotation references
		//refsAndDecCount[4] = Interface declaration
		//refsAndDecCount[5] = Interface references
		//refsAndDecCount[6] = Enum declaration
		//refsAndDecCount[7] = Enum references
		//refsAndDecCount[8] = Primitive declaration
		//refsAndDecCount[9] = Primitive references
		
		public int declarationCount = 0;
		public int referenceCount = 0;
		private String targetType = "";

		/**
		 * Set the targetType
		 * @param typeName The name of the new targetType
		 */
		public void setTargetType(String typeName) {
			targetType = typeName;
		}

	
		
		public boolean visit(TypeDeclaration node) {
			ITypeBinding bind = node.resolveBinding();

			if (bind.getQualifiedName().equals(targetType)) {
				refsAndDecsCount[0]++;
			}
			return true;
		}
		
		public boolean visit(SimpleType node) {
			ITypeBinding bind = node.resolveBinding();

			if (bind.getQualifiedName().equals(targetType)) {
				refsAndDecsCount[1]++;
			}

			return true;
		}
		
		public boolean visit(AnnotationTypeDeclaration node) {
			ITypeBinding bind = node.resolveBinding();

			if (bind.getQualifiedName().equals(targetType)) {
				refsAndDecsCount[2]++;
			}

			return true;
		}
		
	
		
	
		public boolean visit(EnumDeclaration node) {
			ITypeBinding bind = node.resolveBinding();

			if (bind.getQualifiedName().equals(targetType)) {
				refsAndDecsCount[6]++;
			}

			return true;
		}
		
		public boolean visit(PrimitiveType node) {
			ITypeBinding bind = node.resolveBinding();

			if (bind.getQualifiedName().equals(targetType)) {
				refsAndDecsCount[9]++;
			}

			return true;
		}

	}