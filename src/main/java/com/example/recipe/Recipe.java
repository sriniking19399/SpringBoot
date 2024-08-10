// Write your code here
package com.example.recipe;

import java.util.*;

public class Recipe {
    private int recipeId;
    private String recipeName;
    private String recipeType;
    private List<String> ingerdients;

    public Recipe(int recipeId, String recipeName, String recipeType, List<String> ingerdients) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeType = recipeType;
        this.ingerdients = ingerdients;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public List<String> getIngerdients() {
        return ingerdients;
    }

    public void setIngerdients(List<String> ingerdients) {
        this.ingerdients = ingerdients;
    }
}