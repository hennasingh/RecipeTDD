package com.artist.web.recipe.ui;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.artist.web.recipe.R;
import com.artist.web.recipe.test.RecipeRobot;

import org.junit.Rule;
import org.junit.Test;

public class RecipeActivityTest {

    private static final String CARROTS_ID = "creamed_carrots" ;

    @Rule
    public ActivityTestRule<RecipeActivity> mActivityTestRule = new ActivityTestRule<>(
            RecipeActivity.class,true,false);

    @Test
    public void recipeNotFound() {
        new RecipeRobot()
                .launch(mActivityTestRule)
                .noTitle()
                .descriptionText(R.string.recipe_not_found);

//        onView(withId(R.id.description))
//                .check(matches(withText(R.string.recipe_not_found)));
//        onView(withId(R.id.title))
//                .check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavorite(){
        new RecipeRobot().launch(mActivityTestRule,CARROTS_ID)
                         .setFavorite(CARROTS_ID);

//        launchRecipe(CARROTS_ID);
//
//        onView(withId(R.id.title))
//                .check(matches(withText("Creamed Carrots")))
//                .check(matches(not(isSelected())))
//                .perform(click())
//                .check(matches(isSelected()));
    }

    @Test
    public void alreadyFavorite(){
        new RecipeRobot()
                .setFavorite(CARROTS_ID)
                .launch(mActivityTestRule,CARROTS_ID)
                .isFavorite();

//         onView(withId(R.id.title))
//                .check(matches(isSelected()));
    }

    private void launchRecipe(String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID,id);
        mActivityTestRule.launchActivity(intent);
    }


}