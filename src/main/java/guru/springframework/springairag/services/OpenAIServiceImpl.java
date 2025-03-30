package guru.springframework.springairag.services;

import guru.springframework.springairag.model.GetRecipeRequest;
import guru.springframework.springairag.model.GetRecipeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class OpenAIServiceImpl implements OpenAIService {

    private final ChatModel chatModel;

    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Value("classpath:templates/get-recipe-prompt.st")
    private Resource getRecipePrompt;

    @Override
    public GetRecipeResponse getRecipe(GetRecipeRequest getRecipeRequest) {
        BeanOutputConverter<GetRecipeResponse> converter = new BeanOutputConverter<>(GetRecipeResponse.class);
        String format = converter.getFormat();

        PromptTemplate promptTemplate = new PromptTemplate(getRecipePrompt);
        Prompt prompt = promptTemplate.create(Map.of(
                "stateOrCountry", getRecipeRequest.stateOrCountry(),
                "format", format
                ));
        log.info("Prompt generado: \n{}", prompt.getContents());
        log.info("************************");
        log.info("Formato esperado: \n{}", format);
        ChatResponse response = chatModel.call(prompt);
        log.info("Respuesta de OpenAI: \n{}", response.getResult().getOutput().getText());
        return converter.convert(response.getResult().getOutput().getText());
    }
}
