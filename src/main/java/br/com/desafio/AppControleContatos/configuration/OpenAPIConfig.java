package br.com.desafio.AppControleContatos.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes("bearerAuth",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer").bearerFormat("JWT")
                        )
                )
                .info(
                        new Info()
                                .title("App de controle de contatos")
                                .description("Faz o controle de contatos das pessoas")
                                .contact(new Contact()
                                        .name("Juan Lucca Santana dos Santos")
                                        .email("lucca470@gmail.com")
                                        .url("http://localhost:8080/swagger-ui.html")
                                )
                                .version("Versão 1.0")
                )
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
