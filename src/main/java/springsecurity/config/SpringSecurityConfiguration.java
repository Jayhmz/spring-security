package springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity(debug = true)
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username, password, enabled from clients where username = ?")
		.authoritiesByUsernameQuery("select username, authority from clients where username = ?")
		.passwordEncoder(encoder);
	
//		auth.inMemoryAuthentication().withUser("james").password("{noop}1234").roles("admin");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/").authenticated()
		.antMatchers("/admin").hasAuthority("admin")
		.antMatchers("/user").hasAuthority("user")
		.and().formLogin().loginPage("/login")
		.and().exceptionHandling().accessDeniedPage("/accessDenied");
	}
	
	
	
	
}
