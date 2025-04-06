package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Calculator;

@DisplayName("Calculator Tests")
@TestMethodOrder(OrderAnnotation.class)
@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTest {
	
    Calculator calc;

    @BeforeAll
	static void BeforeAll() throws Exception {
        System.out.println("start calculator test");
	}
    
    @BeforeEach
    void setup() {
    	calc = new Calculator();
    }
    
    @Test
    @Order(1)
    @DisplayName("valid add number")
    void testAddValid() {
    	assertEquals(6,calc.add(1,2,3));	
    }
    
    
    @Test
    @Order(2)
    @DisplayName("valid add آNegative number")
    void testAddNegativeNumber() {
    	assertEquals(2,calc.add(1,-2,3));
    }
    
    @Test
    @Order(3)
    @DisplayName("Add Empty array")
    void testAdditionEmptyArray(){
    	assertEquals(0,calc.add());
    }
    
    
    @Test
    @Order(4)
    @DisplayName("Divide Number")
    void testDivideNumber() {
    	assertEquals(2,calc.divide(6, 3));
    }
    
    @Test
    @Order(5)
    @DisplayName("Divide By Zero")
    void testDivideByZero() {
        ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calc.divide(2, 0));
        assertEquals("Cannot divide by zero",ex.getMessage());
    }
    
    
    @ParameterizedTest
    @Order(6)
    @DisplayName("Factory valid")
    @CsvSource({
    	"0,1",
    	"1,1",
    	"5,120",
    	"6,720"
    })
    void testFactory(int num,int expected) {
    	assertEquals(calc.factorial(num),expected);
    }
    
    @Test
    @Order(7)
    @DisplayName("Factory to Negateve number")
    void testFactorialNegative(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> calc.factorial(-3));
        assertEquals("Negative input", ex.getMessage());	
    }
    
    @AfterAll
    public static void teardownAll() {
        System.out.println("All tests Calculator end");
    }
    
	

}
