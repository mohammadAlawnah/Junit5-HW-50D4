package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.Product;

public class ProductTest {
    Product p;
    
    @BeforeAll
    static void BeforeAll() {
    	System.out.print("Before All Test");
    }
	

	@BeforeEach
	 void setUp() throws Exception {
		p = new Product("iphone", 1000);
	}
	
	
	//Initialization Product Tests?
	

	@Test
	@Disabled
	@DisplayName("Create Product with the right data")
	void testValidProductPrice() {
		assertEquals("iphone",p.getName());
		assertEquals(1000,p.getFinalPrice());
		assertEquals(0,p.getDiscount());
		assertEquals(1000,p.getFinalPrice());
	}
	
	@Test
	@DisplayName("Not producing a product at a negative price")
	void testInvalidProductPrice() {
		assertEquals((assertThrows(IllegalArgumentException.class,()->new Product("Phone",-500))).getMessage(),"Price must be non-negative");
	}
	
	
	
	//Discount Tests
	@Test
	@DisplayName("Invalid Discount")
	void testInvalidDiscount() {
	//	System.out.print(assertThrows(IllegalArgumentException.class,()->p.applyDiscount(-20.0)));
	assertEquals((assertThrows(IllegalArgumentException.class,()->p.applyDiscount(-20.0))).getMessage(),"Invalid discount");
	}
	
	@Test
	@DisplayName("Valid Discount")
	void testValidDiscount() {
		p.applyDiscount(10);
		assertEquals(p.getDiscount(),10);	
	}
	
	
	
	
	@DisplayName("true value Product after discount")
	@ParameterizedTest
	@CsvSource({
		"10.0,900.0",
		"0.0,1000.0",
		"50.0,500.0"
	})
	void testValueProductAfterDiscount(double discountPercentage,double expectedPrice) {
		p.applyDiscount(discountPercentage);
		assertEquals(p.getFinalPrice(),expectedPrice);
	}
	
	@Test
	@DisplayName("test applying discount with timeout")
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void testDiscountWithinTime() {
	    p.applyDiscount(20);
	    assertEquals(20, p.getDiscount());
	}
	
	 @AfterEach
	 void AfterEach(TestInfo testInfo) {
	       System.out.println(testInfo.getDisplayName()+"Test had done");
	    }
	 
	 @Test
	 @DisplayName("test getters")
	 void testGetters() {
	     assertEquals("iphone", p.getName());
	     assertEquals(1000.0, p.getPrice());
	     assertEquals(0.0, p.getDiscount());
	 }

	
	
	
    @AfterAll
    static void afterAll() {
    	System.out.print("After All Test");
    }
	


}
