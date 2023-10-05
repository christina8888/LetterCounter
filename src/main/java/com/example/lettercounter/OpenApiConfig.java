package com.example.lettercounter;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Letter Counter Api",
                description = "API, позволяющее рассчитать количество каждого из символов в строке.", version = "1.0.0",
                contact = @Contact(
                        name = "Rogozina Christina",
                        email = "kristin.rogozina@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
