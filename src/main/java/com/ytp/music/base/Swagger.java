package com.ytp.music.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger 配置
 *
 * @author ytp
 */
@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket createRestApi() {

        /*ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("token").description("userToken")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());*/

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ytp.music"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "power-music",
                "http://www.slendercloud.com/",
                "");
        return new ApiInfoBuilder()
                .title("音乐接口")
                .description("音乐接口定义")
                .termsOfServiceUrl("http://www.slendercloud.com/")
                .contact(contact)
                .version("1.0")
                .license("")
                .licenseUrl("")
                .build();
    }
}