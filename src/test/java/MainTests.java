import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Main tests
 */
public class MainTests {

    /**
     * Checking the successful execution Main#calc(String input)
     */
    @Test
    public void calc_Success_Test(){

        Assertions.assertEquals("3", Main.calc("1 + 2"));
        Assertions.assertEquals("5", Main.calc("10 / 2"));
        Assertions.assertEquals("20", Main.calc("10 * 2"));
        Assertions.assertEquals("8", Main.calc("10 - 2"));
        Assertions.assertEquals("0", Main.calc("2 - 2"));
        Assertions.assertEquals("-8", Main.calc("2 - 10"));
        Assertions.assertEquals("2", Main.calc("8 / 3"));

        Assertions.assertEquals("III", Main.calc("I + II"));
        Assertions.assertEquals("V", Main.calc("X / II"));
        Assertions.assertEquals("XX", Main.calc("X * II"));
        Assertions.assertEquals("VIII", Main.calc("X - II"));
    }

    /**
     * Checking the unsuccessful execution Main#calc(String input) when the user enters the wrong format of a mathematical expression
     */
    @Test
    public void calc_Fail_Test1(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("1 + 2 + 3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("1 + V"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("one sub two"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("1"));
        Assertions.assertThrows(ArithmeticException.class, () -> Main.calc("I - II"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("11 - 10"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("10 - 0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("10 s 2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("10s / 2s"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("Vs / Vs"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("s10 / s2"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.calc("sV / sV"));
    }


}
