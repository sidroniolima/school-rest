package br.com.tetrati.school.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	private UserDetailsService userDetailsService;
	
	@Autowired
	public SecurityConfig(UserDetailsService userDetailsService) 
	{
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
			.csrf().disable()
			.cors()
			.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/login").permitAll()
				.antMatchers("api/**").hasAnyRole("USER", "ADMIN")
				.antMatchers("api/admin/**").hasAnyRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			
			//filtra requisições de login
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), 
				UsernamePasswordAuthenticationFilter.class)
			
			.addFilterBefore(new JWTAuthenticationFilter(), 
				UsernamePasswordAuthenticationFilter.class);
	}
	
    @Bean
    protected CorsConfigurationSource corsConfigurationSource() 
    {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        
        CorsConfiguration cors = new CorsConfiguration().applyPermitDefaultValues();
        cors.setExposedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization"));
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.userDetailsService(this.userDetailsService);
	}
}
