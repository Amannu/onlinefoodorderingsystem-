package com.g39.onlinefoodorderingsystem.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	UserAuthenticationSuccessHandler userAuthenticationSuccessHandler;
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userDetailsService)
	          .passwordEncoder(bCryptPasswordEncoder);
	  } 
	@Override
	 protected void configure(HttpSecurity http) throws Exception {
		 
		 http.authorizeRequests()
		     .antMatchers("/").permitAll()
		     .antMatchers("/login").permitAll()
		     .antMatchers("/register").permitAll()
		     .antMatchers("/register").permitAll()
		     .antMatchers("/customer","/addorder","/addfeedback","/viewfood","/viewpayment","/payment").hasAuthority("USER")
		     .antMatchers("/admin-page","/edit/{id}","/delete/{id}","/order").hasAuthority("ADMIN")
		     .and()
		        .csrf()
		          .ignoringAntMatchers("/h2-console/**")
		     .and()
		     	.formLogin()
		     			.loginPage("/login")
		     			.failureUrl("/login?error=true")
		     			.successHandler(userAuthenticationSuccessHandler)
		     .and()
		     	.logout()
		     			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		     			.logoutSuccessUrl("/")
	     	.and()
		     	.exceptionHandling()
		     	.accessDeniedPage("/access-denied");
	  }
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/font/**","/css/**","/js/**","/images/**");
		 
	 }

}
