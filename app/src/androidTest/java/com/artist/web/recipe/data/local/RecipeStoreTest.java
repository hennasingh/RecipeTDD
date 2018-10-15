package com.artist.web.recipe.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.artist.web.recipe.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecipeStoreTest {

    @Test
    public void nullDirectory(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.getRecipes());
        assertEquals(0,store.getRecipes().size());
    }

    @Test
    public void count(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.getRecipes());
        assertEquals(4,store.getRecipes().size());
    }

    @Test
    public void getChocolatePudding(){
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("chocolate_pudding");
        assertNotNull(recipe);
        assertEquals("chocolate_pudding",recipe.getId());
        assertEquals("Chocolate Pudding",recipe.getTitle());
    }


}