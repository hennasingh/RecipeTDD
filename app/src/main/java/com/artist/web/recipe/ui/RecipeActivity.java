package com.artist.web.recipe.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.artist.web.recipe.R;
import com.artist.web.recipe.data.local.Favorites;
import com.artist.web.recipe.data.local.RecipeStore;
import com.artist.web.recipe.data.model.Recipe;
import com.artist.web.recipe.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "key_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = findViewById(R.id.title);
        TextView descView = findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this,"recipes");
        String id = getIntent().getStringExtra(KEY_ID);

        final Recipe recipe = store.getRecipe(id);

        if(recipe==null){
            titleView.setVisibility(View.GONE);
            descView.setText(R.string.recipe_not_found);
            return;
        }

        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorite = app.getFavorites();
        final boolean fav = favorite.get(id);

        titleView.setText(recipe.getTitle());
        titleView.setSelected(fav);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = favorite.toggle(recipe.getId());
                titleView.setSelected(result);
            }
        });
        descView.setText(recipe.getDescription());

    }
}
