package astParserProject;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarFilePathFinder {
	String[] jarFilesList;
	
	public String[] readJarFile(String jarName){
		
		try {
		JarFile jarFile = new JarFile(jarName);
		Enumeration<JarEntry> jarEnum = jarFile.entries();
		while (jarEnum.hasMoreElements()) {
			
			System.out.println(jarEnum.nextElement().getName());
			
		}
		
		}catch(IOException ioe) {
			System.out.println("There was an IOException: " + ioe);
		}
		
		return jarFilesList;
	}
	
	
}
