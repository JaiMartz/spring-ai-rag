package guru.springframework.springairag.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import java.util.List;

public record GetRecipeResponse(
    @JsonPropertyDescription("recipe") Recipe recipe
) {
}
