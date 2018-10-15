package com.artist.web.recipe.data.local;

public interface Favorites {
    boolean get(String id);
    boolean toggle(String id);
}
