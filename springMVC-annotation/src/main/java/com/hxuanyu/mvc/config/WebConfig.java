package com.hxuanyu.mvc.config;

import com.hxuanyu.mvc.interceptor.TestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Properties;

/**
 * SpringMVC配置类
 * 1. 扫描组件
 * 2. 视图解析器
 * 3. view-controller
 * 4. default-servlet-handler
 * 5. mvc注解驱动
 * 6. 文件上传解析器
 * 7. 异常处理
 * 8. 拦截器
 *
 * @author hanxuanyu
 * @version 1.0
 */
@Configuration
@ComponentScan("com.hxuanyu.mvc")
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * 视图控制
     * @param registry 视图注册
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }


    /**
     * 启用默认的servlet处理静态资源
     *
     * @param configurer 默认servlet，自动注入
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 配置文件上传解析器
     *
     * @return 文件上传解析器
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    /**
     * 配置拦截器
     * @param registry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        TestInterceptor testInterceptor = new TestInterceptor();
        registry.addInterceptor(testInterceptor).addPathPatterns("/**");
    }


    /**
     * 配置异常处理器
     *
     * @param resolvers 异常处理器列表：数学处理异常
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
        Properties prop = new Properties();
        prop.setProperty("java.lang.ArithmeticException", "error");
        //设置异常映射
        exceptionResolver.setExceptionMappings(prop);
        //设置共享异常信息的键
        exceptionResolver.setExceptionAttribute("ex");
        resolvers.add(exceptionResolver);
    }

    /**
     * 配置生成模板解析器
     *
     * @return 返回模板解析器
     */
    @Bean
    public ITemplateResolver templateResolver() {
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        if (webApplicationContext != null) {
            // ServletContextTemplateResolver需要一个ServletContext作为构造参数
            ServletContext servletContext = webApplicationContext.getServletContext();
            if (servletContext != null) {
                ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
                templateResolver.setPrefix("/WEB-INF/templates/");
                templateResolver.setSuffix(".html");
                templateResolver.setCharacterEncoding("UTF-8");
                templateResolver.setTemplateMode(TemplateMode.HTML);
                return templateResolver;
            }
        }
        return null;
    }

    /**
     * 生成模板引擎并为模板引擎注入模板解析器
     *
     * @param templateResolver 模板解析器，自动注入
     * @return 模板引擎
     */
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 生成视图解析器并为解析器注入模板引擎
     *
     * @param templateEngine 模板引擎，自动注入
     * @return 视图解析器
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }
}
