package be.vdab.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class RepositoriesConfig {

	@Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	NamedParameterJdbcTemplate namedParameterJdbcTemplate (DataSource dataSource){
		return new NamedParameterJdbcTemplate(dataSource);
	}
}
