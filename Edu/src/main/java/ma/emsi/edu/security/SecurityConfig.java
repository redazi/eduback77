package ma.emsi.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ma.emsi.edu.service.UtilisateurService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UtilisateurService utilisateurService; 
	@Autowired
	PasswordEncoder passwordEncoder ;
	@Autowired
	JWTAuthorizationFilter authorizationFilter ;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
		.antMatchers("/**/signup").permitAll()
		
		.antMatchers("/matiere").permitAll()
		.anyRequest()
				.authenticated()
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				;
		http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(utilisateurService).passwordEncoder(passwordEncoder);
		
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	

}
