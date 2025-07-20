package com.h7.synapseai.app.controller;

import com.h7.synapseai.app.dto.RecipeRequest;
import com.h7.synapseai.app.dto.RecipeResponse;
import com.h7.synapseai.app.service.GeminiService;
import com.h7.synapseai.app.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final GeminiService geminiService;
    private final IngredientService ingredientService;

    @Autowired
    public RecipeController(GeminiService geminiService, IngredientService ingredientService) {
        this.geminiService = geminiService;
        this.ingredientService = ingredientService;
    }

    @PostMapping("/api/recipes/generate")
    public RecipeResponse generateRecipe(@RequestBody RecipeRequest request) {
        String generatedText = geminiService.generateRecipe(request);
        return new RecipeResponse(generatedText);
    }

    @GetMapping("/api/recipes/surprise")
    public RecipeResponse surpriseMe() {
        List<String> surpriseIngredients = ingredientService.getSurpriseIngredients();

        RecipeRequest surpriseRequest = new RecipeRequest();
        surpriseRequest.setIngredients(surpriseIngredients);
        // We leave other filters (cuisine, diet, etc.) null for a true surprise

        String generatedText = geminiService.generateRecipe(surpriseRequest);
        return new RecipeResponse(generatedText);
    }
}
