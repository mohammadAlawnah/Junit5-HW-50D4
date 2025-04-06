package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.najah.code.Recipe;
import main.najah.code.RecipeException;

class RecipeTest {

    Recipe r;

    @BeforeEach
    void setUp() throws Exception {
        r = new Recipe();
    }

    @Test
    @DisplayName("Test valid amount of coffee")
    void testSetAmtCoffee() throws RecipeException {
        r.setAmtCoffee("2");
        assertEquals(2, r.getAmtCoffee());
    }

    @Test
    @DisplayName("Test invalid amount of coffee")
    void testSetInvalidAmtCoffee() {
        assertThrows(RecipeException.class, () -> {
            r.setAmtCoffee("-1");
        });
    }

    @Test
    @DisplayName("Test valid amount of milk")
    void testSetAmtMilk() throws RecipeException {
        r.setAmtMilk("3");
        assertEquals(3, r.getAmtMilk());
    }

    @Test
    @DisplayName("Test invalid amount of milk")
    void testSetInvalidAmtMilk() {
        assertThrows(RecipeException.class, () -> {
            r.setAmtMilk("-1");
        });
    }

    @Test
    @DisplayName("Test valid amount of sugar")
    void testSetAmtSugar() throws RecipeException {
        r.setAmtSugar("4");
        assertEquals(4, r.getAmtSugar());
    }

    @Test
    @DisplayName("Test invalid amount of sugar")
    void testSetInvalidAmtSugar() {
        assertThrows(RecipeException.class, () -> {
            r.setAmtSugar("-1");
        });
    }

    @Test
    @DisplayName("Test valid amount of chocolate")
    void testSetAmtChocolate() throws RecipeException {
        r.setAmtChocolate("5");
        assertEquals(5, r.getAmtChocolate());
    }

    @Test
    @DisplayName("Test invalid amount of chocolate")
    void testSetInvalidAmtChocolate() {
        assertThrows(RecipeException.class, () -> {
            r.setAmtChocolate("-1");
        });
    }

    @Test
    @DisplayName("Test valid price")
    void testSetPrice() throws RecipeException {
        r.setPrice("100");
        assertEquals(100, r.getPrice());
    }

    @Test
    @DisplayName("Test invalid price")
    void testSetInvalidPrice() {
        assertThrows(RecipeException.class, () -> {
            r.setPrice("-10");
        });
    }

    @Test
    @DisplayName("Test valid name")
    void testSetName() {
        r.setName("Latte");
        assertEquals("Latte", r.getName());
    }

    @Test
    @DisplayName("Test toString method")
    void testToString() {
        r.setName("Cappuccino");
        assertEquals("Cappuccino", r.toString());
    }

    @Test
    @DisplayName("Test hashCode method")
    void testHashCode() {
        r.setName("Cappuccino");
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Cappuccino");
        assertEquals(r.hashCode(), anotherRecipe.hashCode());
    }

    @Test
    @DisplayName("Test equals method")
    void testEquals() {
        r.setName("Cappuccino");
        Recipe anotherRecipe = new Recipe();
        anotherRecipe.setName("Cappuccino");
        assertTrue(r.equals(anotherRecipe));

        Recipe differentRecipe = new Recipe();
        differentRecipe.setName("Latte");
        assertFalse(r.equals(differentRecipe));
    }
}
