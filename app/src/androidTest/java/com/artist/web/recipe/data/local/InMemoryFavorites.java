package com.artist.web.recipe.data.local;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavorites implements Favorites {
    private Map<String,Boolean> mFavMap = new HashMap<>();

    @Override
    public boolean get(String id) {
        Boolean value = mFavMap.get(id);
        return value == null ? false: value;
    }

    @Override
    public boolean toggle(String id) {
        boolean value = get(id);
        mFavMap.put(id, !value);
        return !value;
    }

    public void put(String id, boolean value){
        mFavMap.put(id,value);
    }
}
