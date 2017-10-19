package Test;

/**
 * Created by Lukas on 16.10.2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    HelloWorld greeter = new HelloWorld();

    @Test
    public void test() {
        assertEquals("Hello World! ", greeter.greetings(""));
    }
}