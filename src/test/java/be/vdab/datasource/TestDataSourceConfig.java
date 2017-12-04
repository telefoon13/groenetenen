package be.vdab.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class TestDataSourceConfig {

	@Bean
	DataSource dataSource() {
		return new DriverManagerDataSource(
				"jdbc:mysql://localhost/groenetenen?useSSL=false", "cursist", "cursist");
	}
}
