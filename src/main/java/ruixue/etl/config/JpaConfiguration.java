package ruixue.etl.config;

import java.sql.SQLException;
import java.util.Properties;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "ruixue.etl.repository")
public class JpaConfiguration {
	@Autowired
	private DataSource dataSourceMARIADB;
	@Autowired
	private Properties hibernateProperties;
	@Autowired
	private JpaVendorAdapter jpaVendorAdapter;
	//JPA (standard)
	@Bean
    public EntityManagerFactory entityManagerFactory() throws SQLException {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(new String[]{"ruixue.etl.entity"});
        factory.setDataSource(dataSourceMARIADB);
        factory.setJpaProperties(hibernateProperties);
        factory.afterPropertiesSet();
        return factory.getNativeEntityManagerFactory();
    }
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(emf);
	    return transactionManager;
	}
//	 @Bean
//	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//	      return new PersistenceExceptionTranslationPostProcessor();
//	   }
	
}
