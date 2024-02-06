package com.imbuka.taskmanagementsystem;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Task Management System API for Smart Access Applications (Secure, Fast, Access)",
                version = "1.0.0",
                description = "A backend application for managing tasks.",
                termsOfService = "imbuka",
                contact = @Contact(
                        name = "Alvin Imbuka",
                        email = "imbuka@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "imbuka"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Smart Access Task Management System Api Documentation",
                url = "https://www.imbuka.com.swagger-ui.html"
        )
)
public class TaskManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagementSystemApplication.class, args);
    }

}
