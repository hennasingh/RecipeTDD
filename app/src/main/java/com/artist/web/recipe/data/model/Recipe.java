package com.artist.web.recipe.data.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {

    private static final String ID_PREFIX = "id=";
    private static final String TAG = Recipe.class.getSimpleName();
    public static final String TITLE_PREFIX = "title=";

    private final String mId;
    private final String mTitle;
    private final String mDescription;

    private  Recipe(String id, String title, String description) {
        mId = id;
        mTitle = title;
        mDescription = description;
    }

    public static Recipe readFromStream(InputStream stream){
        String id = null;
        String title = null;
        StringBuilder descBuilder = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                if(line.startsWith(ID_PREFIX)){
                    id = line.substring(ID_PREFIX.length());
                    continue;
                }
                if(line.startsWith(TITLE_PREFIX)){
                    title = line.substring(TITLE_PREFIX.length());
                    continue;
                }
                //when readLine is called, the trailing new line char is going to be stripped, we
                //need to put it back in but not for the first line.
                if(descBuilder.length()>0) {
                    descBuilder.append("\n");
                }
                descBuilder.append(line);
            }
        }catch(IOException e){
            Log.e(TAG, "IOException ", e);
        }
        return new Recipe(id, title, descBuilder.toString());

    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }
}
