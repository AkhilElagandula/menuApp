package com.springboot.menuapp.menuapp;

import com.springboot.menuapp.menuapp.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
class MenuAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(MenuAppApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/api/v1/admin/getAllAdmins");
		filterRegistrationBean.addUrlPatterns("/api/v1/admin/delete/**");
		return filterRegistrationBean;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
