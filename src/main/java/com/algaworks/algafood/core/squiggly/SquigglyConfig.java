package com.algaworks.algafood.core.squiggly;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.web.RequestSquigglyContextProvider;
import com.github.bohnman.squiggly.web.SquigglyRequestFilter;

@Configuration
public class SquigglyConfig {
	
	@Bean
	public FilterRegistrationBean<SquigglyRequestFilter> squigglyRequestFilter(ObjectMapper objectMapper){
		
		//inicializa o squiggly
		//Squiggly.init(objectMapper, new RequestSquigglyContextProvider());
		Squiggly.init(objectMapper, new RequestSquigglyContextProvider("campos",null));//para trocar o padrao de fields para campos
		
		//para limitar onde os filtros vao funcionar
		var urlPatterns = Arrays.asList("/pedidos/*","/restaurantes/*");
		
		var filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new SquigglyRequestFilter());
		filterRegistration.setOrder(1); //muda a ordem das aplicações do filtro...
		filterRegistration.setUrlPatterns(urlPatterns);
		
		return filterRegistration;
		
	}

}
