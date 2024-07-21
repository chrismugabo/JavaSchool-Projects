import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {
		Calculator calculator = new Calculator();
		int a = 1000;
		int b = 500;
		int actual = calculator.add(a, b);
		int expected = 1500;
		assertEquals(expected, actual);
	}

	@Test
	void testSubtract() {
		Calculator calculator = new Calculator();
		int a = 1000;
		int b = 500;
		int actual = calculator.subtract(a, b);
		int expected = 500;
		assertEquals(expected, actual); 
	}
	@Test
	void testMultiply() {
		Calculator calculator = new Calculator();
		int a = 1000;
		int b = 500;
		int actual = calculator.multiply(a, b);
		int expected = 500000;
		assertEquals(expected, actual); 
	}
	@Test
	void testRemainder() {
		Calculator calculator = new Calculator();
		int a = -10;
		int b = 7;
		int actual = calculator.remainder(a, b);
		int expected = -3;
		assertEquals(expected, actual); 
	}
	@Test
	void testModulo() {
		Calculator calculator = new Calculator();
		int a = -10;
		int b = 7;
		int actual = calculator.modulo(a, b);
		int expected = 4;
		assertEquals(expected, actual); 
	}
	@Test
	void testPower() {
		Calculator calculator = new Calculator();
		int a = 2;
		int b = 3;
		double actual = calculator.power(a, b);
		double expected = 8;
		assertEquals(expected, actual); 

}
	@Test
	void testExponent() {
		Calculator calculator = new Calculator();
		int a = 2;
		double actual = calculator.exponent(a);
		double expected = 7.38905;
		assertEquals(expected, actual,0.0001); 

}
}