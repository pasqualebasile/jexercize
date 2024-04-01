package org.example.var;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class IntCalcTest {

    @Test
    void multiplyDueInteriPositiviCheDannoVenti() {
        IntCalc calc = new IntCalc();
        assertEquals(19,calc.multiply(5,4));
    }

    @Test
    void divide() {
        IntCalc calc = new IntCalc();
        try {
            calc.divide(20,0);
        }
        catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }

    }
}