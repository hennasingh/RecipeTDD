package com.artist.web.recipe.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.artist.web.recipe.R;
import com.artist.web.recipe.data.local.InMemoryFavorites;
import com.artist.web.recipe.injection.TestRecipeApplication;
import com.artist.web.recipe.ui.RecipeActivity;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private final InMemoryFavorites mMemoryFavorites;

    public RecipeRobot launch(ActivityTestRule rule){
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launch(ActivityTestRule rule, String id){
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle(){
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot descriptionText(@StringRes int stringId){
        return checkViewHasText(R.id.description, stringId);

    }

     public RecipeRobot(){
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext()
                .getApplicationContext();
        mMemoryFavorites = (InMemoryFavorites) app.getFavorites();
        mMemoryFavorites.clear();
    }

    public RecipeRobot setFavorite(String id){
        mMemoryFavorites.put(id,true);
        return this;
    }

    public RecipeRobot isFavorite(){
        return checkIsSelected(R.id.title);
    }
}
