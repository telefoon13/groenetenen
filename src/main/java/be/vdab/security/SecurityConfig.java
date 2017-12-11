package be.vdab.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String MANAGER = "manager";
	private static final String HELPDESKMEDEWERKER = "helpdeskmedewerker";
	private static final String MAGAZIJNIER = "magazijnier";
	private final DataSource dataSource;
	private static final String USERS_BY_USERNAME = "SELECT naam AS username, paswoord AS password, actief AS enabled FROM gebruikers WHERE naam = ?";
	private static final String AUTHORITIES_BY_USERNAME = "SELECT gebruikers.naam AS username, rollen.naam AS authorities" +
					" FROM gebruikers INNER JOIN gebruikersrollen" +
					" ON gebruikers.id = gebruikersrollen.gebruikerid" +
					" INNER JOIN rollen" +
					" ON rollen.id = gebruikersrollen.rolid" +
					" WHERE gebruikers.naam= ?";


	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(USERS_BY_USERNAME)
			.authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**").antMatchers("/styles/**").antMatchers("/scripts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/")
			.and().authorizeRequests()
			.antMatchers("/filialen/toevoegen", "/filialen/*/wijzigen", "/filialen/*/verwijderen")
			.hasAuthority(MANAGER)
			.antMatchers(HttpMethod.POST, "/filialen").hasAuthority(MANAGER).antMatchers("/werknemers")
			.hasAnyAuthority(MAGAZIJNIER, HELPDESKMEDEWERKER)
			.antMatchers(HttpMethod.PUT, "/filialen/*").hasAuthority(MANAGER)
			.antMatchers(HttpMethod.DELETE, "filialen/*").hasAuthority(MANAGER)
			.antMatchers("/", "/login").permitAll()
			.antMatchers("/**").authenticated()
			.and().exceptionHandling().accessDeniedPage("/WEB-INF/JSP/forbidden.jsp");
		http.httpBasic();
	}
}
