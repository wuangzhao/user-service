package org.angzhao.demo.service.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket newsApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.enable(true);
        docket.apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("org.angzhao.demo"))
                .paths(PathSelectors.any()).build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("金溢科技云控平台API").description("金溢科技云控平台API").version("0.0.1").build();
    }
}