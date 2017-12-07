package be.vdab.web;

import be.vdab.datasource.DataSourceConfig;
import be.vdab.repositories.RepositoriesConfig;
import be.vdab.restclients.RestClientsConfig;
import be.vdab.restservices.RestControllersConfig;
import be.vdab.services.ServiceConfig;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected String[] getServletMappings() {
		return new String[]{ "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RepositoriesConfig.class, ServiceConfig.class, DataSourceConfig.class, RestClientsConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{ ControllersConfig.class, RestControllersConfig.class};
	}

	@Override
	protected Filter[] getServletFilters(){
		return new Filter[]{new CharacterEncodingFilter("UTF-8"), new OpenEntityManagerInViewFilter()};
	}
}
