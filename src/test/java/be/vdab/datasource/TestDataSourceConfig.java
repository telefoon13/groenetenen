package be.vdab.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class TestDataSourceConfig {

	@Bean
	DataSource dataSource() {
//		return new DriverManagerDataSource("jdbc:mysql://localhost/groenetenen", "cursist", "cursist");
		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}
}
