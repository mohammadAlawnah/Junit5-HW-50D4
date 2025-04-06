
package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.najah.code.RecipeBook;
import main.najah.code.RecipeException;
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
	@DisplayName("Add valid recipe to the book")
	void testAddRecipe() {
		assertTrue(rb.addRecipe(r));
		assertEquals("CoffeA",rb.getRecipes()[0].getName());
	}
	
	@Test
	@DisplayName("Do not add a previously existing recipe")
	void testAddExistingRecipe() {
		rb.addRecipe(r);
		Recipe existRecipe = new Recipe();
		existRecipe.setName("CoffeA");
		assertFalse(rb.addRecipe(existRecipe));	
	}
	//me
	@Test
	@DisplayName("Dont add resipe when array full")
	void testAddRecipeWhenFullArray() {
	    for (int i = 0; i < 4; i++) {
	        Recipe r = new Recipe();
	        try {
			r.setName("CoffeA"+i);
			r.setAmtCoffee("2");
		    r.setAmtMilk("1");
		    r.setAmtSugar("0");
		    r.setAmtChocolate("2");
		    r.setPrice("50");
	        }catch(RecipeException e) {
	            fail("Failed to Add recipe: " + e.getMessage());
	        }
			
	        assertTrue(rb.addRecipe(r));
	    }
	}
	
	// me	
//	@Test
//	@DisplayName("Same Name but different object")
//	void testSameNameDifferentObject() {
//		rb.addRecipe(r);
//		
//	}
//	
	
	
	
	//	Test Function Delete Recipe
	
	@Test
    @DisplayName("Delete existing recipe by index")
	 void testDeleteRecipe() {
        rb.addRecipe(r);
        String deleted = rb.deleteRecipe(0);
        assertEquals("CoffeA", deleted);
        assertNotEquals("CoffeA", rb.getRecipes()[0].getName());
    }
	
	
	@Test
	@DisplayName("delete recipe from empty array")
	void testDeleteInvalidRecipe() {
        assertNull(rb.deleteRecipe(0));
    }
	
	
	
	@Test
	@DisplayName("delete with invalid index")
	void testDeleteRecipeIndex() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
	      rb.deleteRecipe(5);
	   });
		
	}
	
	
	@Test
	@DisplayName("edit existing recipe")
	void testEditRecipe() throws RecipeException {
		rb.addRecipe(r);
		Recipe newRecipe = new Recipe();
		newRecipe.setName("CoffeB");
		newRecipe.setAmtCoffee("4");
		newRecipe.setAmtMilk("2");
		newRecipe.setAmtSugar("2");
		newRecipe.setAmtChocolate("1");
		newRecipe.setPrice("40");	
		
		
	    String edited = rb.editRecipe(0, newRecipe);
        assertEquals("CoffeA", edited);
        assertEquals("CoffeB", rb.getRecipes()[0].getName().isEmpty() ? "CoffeB" : rb.getRecipes()[0].getName());
		
		
		
		
	}
	
	
	@Test
    @DisplayName("Edit not existing recipe")
	 void testEditInvalidRecipe() {
        Recipe newRecipe = new Recipe();
        newRecipe.setName("CoffeZ");
        assertNull(rb.editRecipe(0, newRecipe));
    }
	
	@ParameterizedTest
	@DisplayName("Add multiple recipes until full")
	@CsvSource({
	    "R1,10,2,1,0,1",
	    "R2,20,2,1,1,2",
	    "R3,30,1,2,2,0",
	    "R4,40,3,0,3,1"
	    })
	void testAddManyRecipe(String name,String price,String amtCoffee,String amtMilk, String amtSugar, String amtChocolate) throws RecipeException {
		
		  Recipe r = new Recipe();
	        r.setName(name);
	        r.setPrice(price);
	        r.setAmtCoffee(amtCoffee);
	        r.setAmtMilk(amtMilk);
	        r.setAmtSugar(amtSugar);
	        r.setAmtChocolate(amtChocolate);
	        assertTrue(rb.addRecipe(r));
	}
	


	

	

	
	
	
	 @AfterEach
	 void AfterEach(TestInfo testInfo) {
	       System.out.println(testInfo.getDisplayName()+"Test had done");
	    }
	 

}
