package com.revature.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.revature.service", "com.revature.repository", "com.revature.controller" })

@EnableWebMvc
@EnableTransactionManagement
public class AppConfig{

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//"org.postgresql.Driver"
		dataSource.setDriverClassName("org.h2.Driver");
		//System.getenv(null)
		//INIT=RUNSCRIPT FROM 'classpath:init.sql';
		dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
	
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		/*
		 * The EntityManagerFactory needs to know which packages to scan for entities (anything
		 * annotated with @Entity).
		 */
		em.setPackagesToScan("com.revature.model");
		//Now I need to tell Spring ORM what my Jpa provider is. My Jpa provider is Hibernate.
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		//Set some Hibernate properties. We'll use the built-in Java "Properties" class to define these properties.
		Properties hibernateProps = new Properties();
		//This Hibernate property shows the SQL queries that Hibernate writes for you in the console.
		hibernateProps.put("hibernate.show_sql", "true");
		//This property denotes that Hibernate will run in "create" mode, which means it can create our tables for us.
		//validate
		hibernateProps.put("hibernate.hbm2ddl.auto", "create");
		em.setJpaProperties(hibernateProps);
		return em;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}