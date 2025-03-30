package guru.springframework.springairag.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public record Recipe(
        @JsonPropertyDescription("name") String name,
        @JsonPropertyDescription("ingredients") List<Ingredient> ingredients,
        @JsonPropertyDescription("steps") List<String> steps,
        @JsonPropertyDescription("cookingTime") String cookingTime,
        @JsonPropertyDescription("cost") String cost,
        @JsonPropertyDescription("people") String people
) {
}
