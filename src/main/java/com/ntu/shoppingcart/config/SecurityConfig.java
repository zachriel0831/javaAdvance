package com.ntu.shoppingcart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Qualifier("customSuccessHanler")
	@Autowired
	private AuthenticationSuccessHandler customSuccessHanler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/", "/index", "/login", "/index/login", "/product/**", "/img/**", "/common/**").permitAll()
			.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/index/login")
				.loginProcessingUrl("/logon")
				.usernameParameter("userName")
				.passwordParameter("pwd")
				.successHandler(customSuccessHanler)
				.permitAll()
				.and().logout().permitAll();
		
		
	}
//
//	/**
//	 * 不檢查這些資源(html、js、css或是圖片等等)
//	 */
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/img/**");
//	}
}
