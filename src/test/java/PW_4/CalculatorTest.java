package PW_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void testDivide_ValidInput() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(-2, calculator.divide(6, -3));
    }

    @Test
    public void testDivide_DivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}
