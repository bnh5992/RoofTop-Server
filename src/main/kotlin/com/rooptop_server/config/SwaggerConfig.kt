package com.example.eyeserver.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig() {

    @Bean
    fun openAPI() : OpenAPI{
        val info = Info().version("v1.0.0")
            .title("RoofTop-Server ")
            .description("아티스트들의 정보와 곡을 설명하기 위한 API")
        val securityScheme = SecurityScheme()
            .type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
            .`in`(SecurityScheme.In.HEADER).name("Authorization")
        val securityRequirement = SecurityRequirement().addList("bearerAuth")

        return OpenAPI().info(info)
            .components(
                Components().addSecuritySchemes("bearerAuth", securityScheme))
            .security(listOf(securityRequirement))

    }

}