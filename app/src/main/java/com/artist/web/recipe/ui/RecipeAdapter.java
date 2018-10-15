package com.artist.web.recipe.ui;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artist.web.recipe.R;
import com.artist.web.recipe.data.local.RecipeStore;
import com.artist.web.recipe.data.model.Recipe;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private RecipeStore mRecipeStore;
    public RecipeAdapter(RecipeStore store){

        mRecipeStore = store;
    }


    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup,false);
       return new RecipeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecipeViewHolder recipeViewHolder, int position) {

        final Recipe recipe = mRecipeStore.getRecipes().get(position);
        recipeViewHolder.mTextView.setText(recipe.getTitle());
        recipeViewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = recipeViewHolder.mTextView.getContext();
                Intent intent = new Intent(context, RecipeActivity.class);
                intent.putExtra(RecipeActivity.KEY_ID,recipe.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipeStore.getRecipes().size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView;
        }
    }
}
