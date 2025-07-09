package com.h7.synapseai.app.service;

import com.h7.synapseai.app.dto.RecipeRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String generateRecipe(RecipeRequest request) {
        String apiUrl = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash-latest:generateContent?key=" + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String ingredientsString = String.join(", ", request.getIngredients());

        // Build the prompt dynamically
        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append("You are 'Cook AI', a professional and helpful cooking assistant. A user has provided the following ingredients: ")
                .append(ingredientsString)
                .append(". Generate a creative and easy-to-follow recipe using these ingredients.");

        if (request.getCuisine() != null && !request.getCuisine().isEmpty()) {
            promptBuilder.append(" The recipe should be in the '").append(request.getCuisine()).append("' cuisine style.");
        }
        if (request.getDiet() != null && !request.getDiet().isEmpty()) {
            promptBuilder.append(" It must adhere to a '").append(request.getDiet()).append("' diet.");
        }
        if (request.getCookTime() != null && !request.getCookTime().isEmpty()) {
            promptBuilder.append(" The total cooking time should be '").append(request.getCookTime()).append("'.");
        }

        promptBuilder.append(" The recipe must have a title, a short description, an ingredients list, and step-by-step instructions. After the recipe, create a separate section titled 'Estimated Nutritional Information'. In this section, provide your best estimation for the following values for the entire dish: Calories (in kcal), Protein (in grams), and Fat (in grams). Present the final output in a clean, readable format with clear headings.");

        String prompt = promptBuilder.toString();

        Map<String, Object> textPart = Map.of("text", prompt);
        Map<String, Object> content = Map.of("parts", Collections.singletonList(textPart));
        Map<String, Object> requestBody = Map.of("contents", Collections.singletonList(content));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            Map<String, Object> response = restTemplate.postForObject(apiUrl, entity, Map.class);

            if (response != null && response.containsKey("candidates")) {
                List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                if (!candidates.isEmpty()) {
                    Map<String, Object> firstCandidate = candidates.get(0);
                    Map<String, Object> contentMap = (Map<String, Object>) firstCandidate.get("content");
                    List<Map<String, Object>> parts = (List<Map<String, Object>>) contentMap.get("parts");
                    if (!parts.isEmpty()) {
                        return (String) parts.get(0).get("text");
                    }
                }
            }
            return "Sorry, the AI could not generate a recipe at this moment. It might be busy.";

        } catch (Exception e) {
            System.err.println("GEMINI API ERROR: " + e.getMessage());
            return "Error: Could not connect to the AI service. Please check the server logs for more details.";
        }
    }
}
