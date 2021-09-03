package com.xiefei.bandcommon.config;


import com.xiefei.bandcommon.domian.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {

        return SwaggerProperties.builder()
                .apiBasePackage("com.xiefei.bandportal.controller")
                .title("Welcome")
                .description("band后台相关接口文档")
                .contactName("xiefei")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
