package com.metasolucoes.prodkit.inspire.config;

import java.beans.PropertyVetoException;
import java.util.HashMap;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.metasolucoes.prodkit.inspire.repository", entityManagerFactoryRef = "printnetCoreEntityManager", transactionManagerRef = "printnetCoreTransactionManager")
@PropertySource(value = { "classpath:env/database-${spring.profiles.active:development}.properties" }, ignoreResourceNotFound = true)
public class JdbcConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource printnetCoreDataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(env.getProperty("datasource.driver"));
		dataSource.setJdbcUrl(env.getProperty("datasource.url"));
		dataSource.setUser(env.getProperty("datasource.user"));
		dataSource.setPassword(env.getProperty("datasource.pass"));
		dataSource.setMinPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.min_size")));
		dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("hibernate.c3p0.max_size")));
		dataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("hibernate.c3p0.idle_test_period")));

		return dataSource;
	}

	@PersistenceContext(unitName = "printnetPersistenceUnitName")
	@Bean(name = "printnetCoreEntityManager")
	public LocalContainerEntityManagerFactoryBean compartCoreEntityManager(EntityManagerFactoryBuilder builder) throws PropertyVetoException {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.put("hibernate.jdbc.lob.non_contextual_creation", true);
		//properties.put("hbm2ddl.auto", "auto");
		properties.put("show_sql", true);

		return builder.dataSource(printnetCoreDataSource()).properties(properties).persistenceUnit("printnetPersistenceUnitName").packages("com.metasolucoes.prodkit.inspire.model").build();
	}

	@Bean(name = "printnetCoreTransactionManager")
	public PlatformTransactionManager compartCoreTransactionManager(EntityManagerFactoryBuilder builder) throws PropertyVetoException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(compartCoreEntityManager(builder).getObject());
		transactionManager.setDataSource(printnetCoreDataSource());
		transactionManager.setPersistenceUnitName("printnetPersistenceUnitName");
		return transactionManager;
	}
}
