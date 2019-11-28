package org.sang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
        * Swagger2配置类
        * 1）在集成spring boot时，放在与Application.java同级目录下
        * 2）@Configuration注解的作用是让spring 来加载该类的配置
        * 3）@EnableSwagger2 是用来启用swagger2
        * @author caiding
        */
@Configuration
@ComponentScan("org.sang.controller")
@EnableSwagger2
public class Swagger2 {

    /**
     * 指定扫描包的路径来指定要创建API的目录
     * @return
     */
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
        @Bean
        public Docket api() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.any())
                    .paths(PathSelectors.any())
                    .build();
        }
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springboot-Swagger示例")//api的标日
                .description("一般常用api信息")//api描述
                .termsOfServiceUrl("https://www.baidu.com/")//服务地址
                .version("1.0")
                .build();
}
}
