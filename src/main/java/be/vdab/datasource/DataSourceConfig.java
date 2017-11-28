package be.vdab.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

public class DataSourceConfig {

	@Bean
	DataSource dataSource(){
		return new JndiDataSourceLookup().getDataSource("jdbc/groenetenen");
	}
}
