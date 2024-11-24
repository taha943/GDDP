package com.GDDP.GDDP.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
@OpenAPIDefinition(

        info =@Info(
                contact=@Contact(

                        name="Taha",
                        email ="ext.taha.filali@sncf.fr"
                ),
                description = "Open Api Documentation",
                title = "open Api specification",
                version = "1.0"


        ),
        servers = {
                @Server(
                        description = "local env" ,
                        url ="http://localhost:8088"
                )


        },
        security = {

                @SecurityRequirement(
                        name ="bearerAuth"

                )

        }

)
@SecurityScheme(

        name = "bearerAuth",
        type = SecuritySchemeType.HTTP ,
        description = "JWT auth description",
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}