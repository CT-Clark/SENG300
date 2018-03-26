import java.io.*;
import java.util.*;
import java.util.jar.*;

public class ReadFromJar {
    
    LinkedList<String> contents = new LinkedList<>();
    
    /**
     * Reads all files with the .java file extension inside the current directory into strings.
     * Throws an IOException if the JarFile constructor or the input stream does.
     * If the given path is null or does not have a .jar file extension the method returns without doing anything.
     *
     * JarFile constructor documented to throw IOException "if an I/O error has occured"
     * the exact terms of that are unknown.
     * Known causes: the given name does not correspond to a file, the given file is not a .jar file
     *
     * Currently modifies the instance field contents, though this can be modified to return values as a list or
     * array without much effort. Just need to modify the return statements and possibly move the LinkedList field
     * into the method.
     */
    private void readFromJar (String path) throws IOException {
        if (path == null)
            return;
        if (!path.endsWith(".jar"))
            return;
        
        JarFile jar = new JarFile(path);
        Enumeration entries = jar.entries();    // Get the files inside the .jar file
        while (entries.hasMoreElements()) {
            JarEntry ent = (JarEntry) entries.nextElement();
            
            // If the file has a .java extension, get an InputStream for that file and
            // read the file into a string.
            if(ent.getName().endsWith(".java")) {
                InputStream in = jar.getInputStream(ent);
                StringBuilder sb = new StringBuilder();
                byte[] buff = new byte[4096];
                int i = 0;
                while ((i = in.read(buff)) > 0)         // read from file into the buffer
                    sb.append(new String(buff, 0, i));  // convert the bytes into a string and add to StringBuilder ** Uses system default charset
                contents.add(sb.toString());
            }
        }
        return;
    }
    
    public static void main (String[] args) throws IOException{
        ReadFromJar test = new ReadFromJar();
        test.readFromJar("ClassDiagram.xml");
        for (String content : test.contents)
            System.out.println(content);
    }
}