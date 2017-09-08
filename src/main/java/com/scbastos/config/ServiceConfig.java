package com.scbastos.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.scbastos.service.CadastroEnderecoService;

@Configuration
@ComponentScan(basePackageClasses = CadastroEnderecoService.class)
public class ServiceConfig {
	
	

}
