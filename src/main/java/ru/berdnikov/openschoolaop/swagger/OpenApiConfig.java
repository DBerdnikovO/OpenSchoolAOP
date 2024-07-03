package ru.berdnikov.openschoolaop.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * @author danilaberdnikov on OpenApiConfig.
 * @project OpenSchoolAOP
 */
@OpenAPIDefinition(
        info = @Info(
                title = "Openschool AOP Api",
                description = "Aop project with async and aop switcher", version = "0.0.1",
                contact = @Contact(
                        name = "Berdnikov Danila"
                )
        )
)
public class OpenApiConfig {

}
