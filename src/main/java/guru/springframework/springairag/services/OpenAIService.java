package guru.springframework.springairag.services;

import guru.springframework.springairag.model.GetRecipeResponse;
import guru.springframework.springairag.model.GetRecipeRequest;

public interface OpenAIService {

    GetRecipeResponse getRecipe(GetRecipeRequest recipe);
}
