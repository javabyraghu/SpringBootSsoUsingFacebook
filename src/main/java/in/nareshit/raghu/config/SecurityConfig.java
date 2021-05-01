package in.nareshit.raghu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("sam").password("{noop}sam").authorities("ADMIN");
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").permitAll()
		.anyRequest().authenticated()
		
		.and().formLogin()
		.and().oauth2Login()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		;
	}
}
