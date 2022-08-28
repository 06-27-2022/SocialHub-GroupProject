package com.revature.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.revature.service", "com.revature.repository", "com.revature.controller" })

@EnableWebMvc
public class AppConfig{


}