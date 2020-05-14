package com.sihan.dynamicdatasource.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author zhouj
 * @version 1.0.0
 * @ClassName SwaggerConfig
 * @email zhoujdev@163.com
 * @date 2020/5/13 13:45
 **/
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean(value = "admin")
    public Docket admin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("动态数据源管理员测试")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sihan.dynamicdatasource.modules.admin"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean(value = "tenant")
    public Docket job() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("动态数据源租户测试")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sihan.dynamicdatasource.modules.tenant"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dynamic")
                .description("dynamic接口文档")
                .termsOfServiceUrl("https://sihan2017.github.io")
                .version("1.0.0")
                .build();
    }

}