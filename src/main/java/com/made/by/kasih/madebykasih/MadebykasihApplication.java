package com.made.by.kasih.madebykasih;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//public class MadebykasihApplication extends ServletInitializer{
public class MadebykasihApplication{

	public static void main(String[] args) {
		SpringApplication.run(MadebykasihApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MadebykasihApplication.class);
	}
	
	@Bean
	public FilterRegistrationBean<LoggingInterceptor> loggingFilter() {
		System.out.println("logging filter start here...");
		FilterRegistrationBean<LoggingInterceptor> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(new LoggingInterceptor());
		registrationBean.addUrlPatterns("/madebykasih/*");

		return registrationBean;
	}
}