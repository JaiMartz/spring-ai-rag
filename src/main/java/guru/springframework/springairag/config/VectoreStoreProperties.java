package guru.springframework.springairag.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties("sfg.aiapp")
public class VectoreStoreProperties {

    private String vectorStorePath;
    private List<Resource> documentsToLoad;
}
