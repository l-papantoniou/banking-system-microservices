package com.lpapantoniou.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST API Documentation",
                version = "1.0",
                description = "Accounts Microservice",
                contact = @Contact(
                        name = "lpapantoniou",
                        email = "lampispapantoniou@gmail.com",
                        url = "https://github.com/l-papantoniou"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/l-papantoniou"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Accounts microservice REST API documentation",
                url = "https://github.com/l-papantoniou"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}

