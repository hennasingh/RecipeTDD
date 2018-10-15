package com.artist.web.recipe.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {

    @Test
    public void water() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("water", recipe.getId());
        assertEquals("Water", recipe.getTitle());
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.",recipe.getDescription());
    }

    @Test
    public void mixed() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/mixed.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("punch", recipe.getId());
        assertEquals("Punch", recipe.getTitle());
        assertEquals(
                "Juice of 3 lemons\n" +
                        "1 orange\n" +
                        "1 pint grape juice\n" +
                        "1 cup sugar\n" +
                        "1 cup water\n" +
                        "1 pine apple juice\n" +
                        "Mix all together and strain. Add large piece of ice.",recipe.getDescription());
    }

}