package com.wuliu.fa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ApplicationConfig implements WebMvcConfigurer{
	 // 配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserAuthInteceptor()).addPathPatterns("/vipPage/**");
        registry.addInterceptor(new UserAuthInteceptor()).addPathPatterns("/huser/**");
    }
}
