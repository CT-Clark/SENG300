
public class Master {

	public static void main(String[] args) {
		DeclarationCounter dc = new DeclarationCounter();
		dc.setArgs(args);
		dc.findJavaFiles(args[0]);
		dc.printOutput();

	}

}
