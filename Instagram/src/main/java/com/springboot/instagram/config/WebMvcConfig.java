package com.springboot.instagram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${file.path}") // application.yml에서 설정한 변수를 el 표현식으로 사용
	private String filePath;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/images/**") // src/main/resources 이거임
		.addResourceLocations("file:///" + filePath)
		.setCachePeriod(60*60)
		.resourceChain(true)
		.addResolver(new PathResourceResolver());
	}
}
