package com.dbh.restapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Kazi Mahmud Morshed",
                        email = "dbh@dbh.com"
                        //url = "https://github.com/Mahmud206"
                ),
                description = "OpenApi documentation for DBH",
                title = "OpenApi specification - dbh",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description = "Local environment",
                        url = "http://localhost:8083"
                )
        }
)

public class OpenAPIConfig {
}
