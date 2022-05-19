package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;

	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		String sql = "select u.username,a.authority from sathiyaa_users u,sathiyaa_authorities a where u.username = ?"
					+ "AND u.username = a.username";
		
//		auth.inMemoryAuthentication().withUser("India")
//					.password(encoder.encode("India"))
//					.roles("ADMIN").and().withUser("nepal").password(encoder.encode("nepal")).roles("GUEST");
		
		auth.jdbcAuthentication().dataSource(datasource)
		      .usersByUsernameQuery(
		    		  "select username,password,enabled from sathiyaa_users where username=?")
		         .authoritiesByUsernameQuery(sql).passwordEncoder(encoder);
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		 .authorizeHttpRequests()
		   .antMatchers("/api/v1/**")
			 .authenticated()
			   .and()
				 .httpBasic();
	}
}
