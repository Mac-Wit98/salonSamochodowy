package proj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("ADMIN")
		.and()
		.withUser("employee").password("emplo").roles("EMPLO");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/user").hasAnyRole("USER")
			.antMatchers("/emplo").hasAnyRole("EMPLO")
			.antMatchers("/modeleEU","/markiEU","/samochodyEU","/adresyEU","/pocztyEU","/egzemplarzeEU").hasAnyRole("USER","EMPLO")
			.antMatchers("/newKlienci","/klienci").hasAnyRole("ADMIN","EMPLO")
			.antMatchers("/transakcje").hasAnyRole("ADMIN","EMPLO")
			.antMatchers("/admin","/modele","/marki","/samochody","/adresy","/poczty","/pracownicy","/egzemplarze").hasAnyRole("ADMIN")
			.and().exceptionHandling().accessDeniedPage("/brakDostepu").and().formLogin()
			.and()
			.logout()
			.permitAll()
			;
		
	}


	//@Bean
	//@Override
	//public UserDetailsService userDetailsService() {
	//	UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
	//			.build();
	//	UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN")
	//			.build();
	//	return new InMemoryUserDetailsManager(user,admin);
	//}
}
