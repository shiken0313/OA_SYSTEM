package com.itcast.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.itcast.admin.interceptor.LoginInterceptor;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor())
		.addPathPatterns("/**") //所有請求都被攔截包括靜態資源
		.excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
		
	}

}
