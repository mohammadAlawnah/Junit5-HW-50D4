package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import main.najah.code.RecipeBook;
import main.najah.code.Recipe;


class RecipeBookTest {
	
	RecipeBook rb;
	Recipe r;
	
    @BeforeAll
    static void BeforeAll() {
    	System.out.print("Before All Test");
    }
	

	@BeforeEach
	 void setUp() throws Exception {
		rb = new RecipeBook();
		r = new Recipe();
		r.setName("CoffeA");
		r.setAmtCoffee("2");
	    r.setAmtMilk("1");
	    r.setAmtSugar("0");
	    r.setAmtChocolate("2");
	    r.setPrice("50");
		
	}
	

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	
	 @AfterEach
	 void AfterEach(TestInfo testInfo) {
	       System.out.println(testInfo.getDisplayName()+"Test had done");
	    }
	 

}
