package com.sample.helloworld;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    @Test
    public void testMain() {
        // Capture the output of the main method
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Call the main method
            App.main(new String[]{});
            
            // Check the output
            String expectedOutput = "Hello World" + System.lineSeparator();
            assertEquals(expectedOutput, outContent.toString());
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}
