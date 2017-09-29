package com.room.config;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.room.*")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter {

	

	@Bean(name = "viewResolver")
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsps/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	}
	
	private static final Charset UTF8 = Charset.forName("UTF-8");
	@Override
	   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	       StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
	       stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("text", "plain", UTF8)));
	       converters.add(stringConverter);
	 
	       // Add other converters ...
	   }
	 @Override
	   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	       configurer.enable();
	   }
}
