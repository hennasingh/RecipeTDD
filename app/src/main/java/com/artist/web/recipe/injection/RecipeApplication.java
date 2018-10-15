package com.artist.web.recipe.injection;

import android.app.Application;

import com.artist.web.recipe.data.local.Favorites;
import com.artist.web.recipe.data.local.SharedPreferencesFavorite;

public class RecipeApplication extends Application {

    private Favorites mFavorites = null;

    public Favorites getFavorites(){
        if(mFavorites == null){
            mFavorites = new SharedPreferencesFavorite(this);
        }
        return mFavorites;
    }
}
