package com.example.recipe;

import java.util.*;

import com.example.recipe.RecipeRepository;
import com.example.recipe.Recipe;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

// Don't modify the below code

public class RecipeService implements RecipeRepository {

        private static HashMap<Integer, Recipe> recipeBook = new HashMap<>();

        public RecipeService() {
                recipeBook.put(1, new Recipe(1, "Pasta", "veg",
                                Arrays.asList("pasta", "tomatoes", "olive oil", "garlic", "basil")));
                recipeBook.put(2, new Recipe(2, "Chicken Curry", "non-veg",
                                Arrays.asList("chicken", "onion", "tomato", "ginger", "garlic", "spices")));
                recipeBook.put(3, new Recipe(3, "Sushi", "non-veg",
                                Arrays.asList("sushi rice", "tuna fish", "seaweed", "wasabi", "ginger")));
                recipeBook.put(4, new Recipe(4, "Mushroom Risotto", "veg",
                                Arrays.asList("rice", "mushrooms", "onion", "garlic", "butter", "parmesan")));
                recipeBook.put(5, new Recipe(5, "Fish and Chips", "non-veg",
                                Arrays.asList("fish", "potatoes", "flour", "oil", "spices")));
        }

        int uniqueId = 6;

        // Don't modify the above code
        @Override
        public ArrayList<Recipe> getAllRecipe() {
                Collection<Recipe> recipeCollection = recipeBook.values();
                ArrayList<Recipe> recipe = new ArrayList<>(recipeCollection);
                return recipe;
        }

        @Override
        public Recipe getRecipeById(int recipeId) {
                Recipe recipe = recipeBook.get(recipeId);
                if (recipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                return recipe;
        }

        @Override
        public Recipe addRecipe(Recipe recipe) {
                recipe.setRecipeId(uniqueId);
                recipeBook.put(uniqueId, recipe);
                uniqueId += 1;
                return recipe;

        }

        @Override
        public Recipe updateRecipe(int recipeId, Recipe recipe) {
                Recipe exRecipe = recipeBook.get(recipeId);
                if (exRecipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
                if (recipe.getRecipeName() != null) {
                        exRecipe.setRecipeName(recipe.getRecipeName());
                }
                if (recipe.getIngerdients() != null) {
                        exRecipe.setIngerdients(recipe.getIngerdients());
                }
                if (recipe.getRecipeType() != null) {
                        exRecipe.setRecipeType(recipe.getRecipeType());
                }
                return exRecipe;

        }

        @Override
        public void deleteRercipe(int recipeId) {

                Recipe recipe = recipeBook.get(recipeId);
                if (recipe == null) {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                } else {
                        recipeBook.remove(recipeId);
                        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
                }
        }

        // Write your code here
}