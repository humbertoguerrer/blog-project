package com.hgn.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("Blog para Segware", "Aplicação para registro de posts", "0.1",
                "Terms of Service",
                new Contact("Humberto Guerrer Neto", "https://github.com/humbertoguerrer", "humberto.guerrer@gmail.com"),
                "Apache License Version 2.0", "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>());

        return apiInfo;
    }

}
