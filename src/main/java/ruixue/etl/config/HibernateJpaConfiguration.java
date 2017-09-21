package ruixue.etl.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class HibernateJpaConfiguration {

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		//properties.put("hibernate.dialect", "ruixue.etl.dependency.hibernate5.fix.MyHSQLDialect");
		//properties.put("hibernate.show_sql", "true");
		//properties.put("hibernate.format_sql", "false");
		properties.put("hibernate.hbm2ddl.auto", "create");
		properties.put("hibernate.hbm2ddl.import_files", "import_dev.sql");
		return properties;
	}
	@Bean
	public JpaVendorAdapter hibernateJpaVendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		//vendorAdapter.setDatabase(Database.HSQL);
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(true);
		//vendorAdapter.setGenerateDdl(true);
        //vendorAdapter.set
        return vendorAdapter;
	}
	
}
