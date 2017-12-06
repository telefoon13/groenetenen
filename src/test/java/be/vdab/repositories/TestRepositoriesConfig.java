package be.vdab.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

public class TestRepositoriesConfig extends RepositoriesConfig {
	@Override
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = super.entityManagerFactory(dataSource);
		factory.getJpaPropertyMap().put("javax.persistence.schema-generation.database.action", "create");
		return factory;
	}
}
