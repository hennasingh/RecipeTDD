package com.artist.web.recipe.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.artist.web.recipe.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeStore {

    private List<Recipe> mRecipes = new ArrayList<>();
    private final Map<String,Recipe> mRecipeMap = new HashMap<>();

    public RecipeStore(Context context, String directory){
        List<InputStream> streams = getAssetStreams(context.getAssets(), directory);

        for(InputStream stream :streams){
            Recipe recipe = Recipe.readFromStream(stream);
            if(recipe!=null){
                mRecipes.add(recipe);
                mRecipeMap.put(recipe.getId(),recipe);
            }
        }
    }

    public List<Recipe> getRecipes() {
        return mRecipes;
    }

    private static List<InputStream> getAssetStreams(AssetManager manager, String directory){

        List<InputStream> streams = new ArrayList<>();
        String[] fileNames = getFilenames(manager,directory);

        for(String fileName: fileNames){
            File file = new File(directory, fileName);
            try {
                InputStream stream = manager.open(file.getPath());
                if(stream!=null){
                    streams.add(stream);
                }
            } catch (IOException e) {

            }
        }
        return streams;
    }

    private static String[] getFilenames(AssetManager manager, String directory){
        if(directory==null)return new String[0];

        try {
            return manager.list(directory);
        } catch (IOException e) {
            return new String[0];
        }
    }

    public Recipe getRecipe(String id) {
        return mRecipeMap.get(id);
    }
}
