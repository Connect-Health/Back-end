package br.com.doctordevs.connecthealth.configuration;

import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Connect Health API")
                        .version("1.0")
                        .description("Connect Health API v1.0")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("MIT license").url("http://springdoc.org")));
    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

        return openApi -> openApi
                .addServersItem(new io.swagger.v3.oas.models.servers.Server().url("https://connect-health.up.railway.app/"));
    }

    private ApiResponse createApiResponse(String mensagem) {
        return new ApiResponse().description(mensagem);
    }

}
