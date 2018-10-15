package com.artist.web.recipe.injection;

import com.artist.web.recipe.data.local.Favorites;
import com.artist.web.recipe.data.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication {

    private final Favorites mFavorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return mFavorites;
    }
}
