package com.artist.web.recipe.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesFavorite implements Favorites{

    private SharedPreferences pref;

    public SharedPreferencesFavorite(Context context) {
        pref = context.getSharedPreferences("favorites.xml",Context.MODE_PRIVATE);
    }

    public boolean get(String id){
        return pref.getBoolean(id,false);
    }

    public void put(String id, boolean fav){
        SharedPreferences.Editor editor = pref.edit();
        if(fav){
            editor.putBoolean(id, true);
        }else{
            editor.remove(id);
        }
        editor.apply();

    }

    public boolean toggle(String id){
        boolean fav= get(id);
        put(id, !fav);
        return !fav;
    }
}
