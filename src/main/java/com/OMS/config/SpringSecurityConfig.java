package com.OMS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.OMS.service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailService;

	@Override
	public void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests().antMatchers("/api/createOrder").hasAnyRole("CUSTOMER")
		.antMatchers("/api/CustomerOderDetails").hasAnyRole("CUSTOMER")
		
		.antMatchers("/api/OrderListByData").hasAnyRole("SYSTEM_ADMIN")
		
		.antMatchers("/api/OderList").hasAnyRole("SUPER_ADMIN")
		.antMatchers("/api/OrderListByDataAsc").hasAnyRole("SUPER_ADMIN")
		.antMatchers("/api/OrderByCity").hasAnyRole("SUPER_ADMIN");
		
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		super.configure(http);
	}

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Anusuya").password(passwordEncoder().encode("anu@jesus"))
				.roles("CUSTOMER")
				.and().withUser("Anu").password(passwordEncoder().encode("anu@123"))
				.roles("SYSTEM_ADMIN").and().withUser("Ancy").password(passwordEncoder().encode("ancy@123"))
				.roles("SUPER_ADMIN");
	}*/

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}
}