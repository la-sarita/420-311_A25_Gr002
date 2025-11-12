package mv.sdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addReturnsSum() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void divideThrowsWhenDividingByZero() {
        Calculator calculator = new Calculator();
        ArithmeticException ex = assertThrows(
                ArithmeticException.class, () -> calculator.div(1, 0));
        assertEquals("division by zero", ex.getMessage());
    }
}