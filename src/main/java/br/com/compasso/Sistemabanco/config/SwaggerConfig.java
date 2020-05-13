package br.com.compasso.Sistemabanco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.compasso.Sistemabanco"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(metaInfo());
//                .globalOperationParameters(Arrays.asList(
//                        new ParameterBuilder().name("Saque")
//                        .description("passado o valor do saque, devolve a quantidade de notas.")
//                        .modelRef(new ModelRef("int"))
//                        .parameterType("header")
//                        .required(false)
//                        .build()


    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Caixa Eletronico API REST",
                "API REST com funcao de saque de notas",
                "1.0",
                "Terms of Service",
                new Contact("Matheus Barkert", "https://github.com/Matheus-Barkert",
                        "mbarkert11@hotmail.com"),
                "Apache Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }


}





















