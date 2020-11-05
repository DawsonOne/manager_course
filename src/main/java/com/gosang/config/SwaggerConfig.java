package com.gosang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author gosang
 * @version 1.0
 * @date 2020/11/5 15:19
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //返回docket的Bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("wd")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gosang.controller"))
                .build();
    }

    public ApiInfo apiInfo(){
        Contact contact = new Contact("wd", "https://github.com/DawsonOne?tab=repositories", "18655451012@163.com");
        return new ApiInfo("Manager Course Api", "Api Documentation", "1.0", "https://blog.csdn.net/wd_888", contact, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
