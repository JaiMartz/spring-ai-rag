package guru.springframework.springairag.controllers;

import guru.springframework.springairag.model.GetRecipeResponse;
import guru.springframework.springairag.model.GetRecipeRequest;
import guru.springframework.springairag.services.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private final OpenAIService openAIService;

    public QuestionController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/recipe")
    public GetRecipeResponse getRecipe(@RequestBody GetRecipeRequest getRecipeRequest) {

        return this.openAIService.getRecipe(getRecipeRequest);
    }
}
