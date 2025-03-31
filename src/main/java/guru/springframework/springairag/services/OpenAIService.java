package guru.springframework.springairag.services;

import guru.springframework.springairag.model.Answer;
import guru.springframework.springairag.model.GetRecipeResponse;
import guru.springframework.springairag.model.GetRecipeRequest;
import guru.springframework.springairag.model.Question;

public interface OpenAIService {

    GetRecipeResponse getRecipe(GetRecipeRequest recipe);

    Answer getAnswer(Question question);
}
