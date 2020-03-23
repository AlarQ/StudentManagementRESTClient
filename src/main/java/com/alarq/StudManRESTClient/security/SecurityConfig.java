package com.alarq.StudManRESTClient.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	// in memory authentication
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("SELECT username,password,enabled "
										+ "FROM users "
										+ "WHERE username=?")
			.authoritiesByUsernameQuery("SELECT username, authority "
										+"FROM authorities "
										+"WHERE username=?");
	}
	
	//authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/","/student/list","course/list").permitAll()
			.antMatchers("/student/showAddForm","/course/showAddForm").hasRole("ADMIN")
			.and().
			formLogin();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		//just test
		return NoOpPasswordEncoder.getInstance();
	}
}
