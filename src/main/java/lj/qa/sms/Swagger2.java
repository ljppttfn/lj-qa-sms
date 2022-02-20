package lj.qa.sms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lj
 * date 2019/1/8
 */

@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${swagger.enable}")
    private boolean enableSwagger;


    @Bean
    public Docket encryprionDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("lj SMS平台")
                .description("lj猫池短信平台")
                .termsOfServiceUrl("")
                .version("V1.0")
                .contact(new Contact("lj", "", "tota521@125.com"))
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.lj.qa.sms.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
