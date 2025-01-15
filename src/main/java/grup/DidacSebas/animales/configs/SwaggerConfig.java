package grup.DidacSebas.animales.configs;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    //COMO ACCEDER A LA DOCUMENTACIÓN DE LA API:
    //http://localhost:9999/swagger-ui.html
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .packagesToScan("grup.DidacSebas.animales.presentation.controllers")
                .build();
    }

}
