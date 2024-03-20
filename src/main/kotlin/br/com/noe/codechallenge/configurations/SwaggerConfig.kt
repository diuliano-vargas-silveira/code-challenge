package br.com.noe.codechallenge.configurations

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Paths
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.io.path.Path


@Configuration
class SwaggerConfig {

    @Bean
    open fun openApiConfig(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Code Challenge API")
                    .description("Code Challenge API - is a simple API to submit and test code challenges")
                    .version("1.0.0")
                    .license(
                        License().name("Apache 2.0").url("http://springdoc.org")
                    )
            )
    }

}