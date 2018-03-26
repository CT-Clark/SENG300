import static org.junit.Assert.assertArrayEquals;

import java.io.File;

import org.junit.Test;

public enum e{}

public class E {
    public void speak() {
    }

    public String getType() {
        return "Generic animal";
    }
}

public class Cat extends E {
    @Override
    public void speak() { // This is a good override.
        System.out.println("Meow.");
    }

    @Override
    public String gettype() { // Compile-time error due to mistyped name.
        return "Cat";
  
