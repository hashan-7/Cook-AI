package com.h7.synapseai.app.dto;

public class RecipeResponse {
    private String recipeContent;

    public RecipeResponse(String recipeContent) {
        this.recipeContent = recipeContent;
    }

    public String getRecipeContent() {
        return recipeContent;
    }

    public void setRecipeContent(String recipeContent) {
        this.recipeContent = recipeContent;
    }
}