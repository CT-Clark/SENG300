import javax.lang.model.type.ArrayType;
import javax.lang.model.type.UnionType;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IntersectionType;
import org.eclipse.jdt.core.dom.NameQualifiedType;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WildcardType;

public class ASTCounter extends ASTVisitor {
	
	private int declarations = 0;
	
	public int getDeclarations() { return declarations; }
	
	public void process(CompilationUnit cu) {
		cu.accept(this);
	}
	
	public boolean visit(PrimitiveType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(SimpleType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(QualifiedType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(NameQualifiedType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(WildcardType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(ArrayType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(ParameterizedType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(UnionType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public boolean visit(IntersectionType node) {
		System.out.println(node.toString());
		return true;
	}
	
	public void printAll() {
		
	}
}
