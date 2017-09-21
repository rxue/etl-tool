package ruixue.etl.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class JDBCConfiguration {
	@Bean
	public DataSource dataSourceHSQL() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:datawarehouse");
		//dataSource.setSchema("PUBLIC");
		return dataSource;
	}	
	@Bean
	public DataSource dataSourceMARIADB() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/datawarehouse");
		dataSource.setUsername("rui");
		dataSource.setPassword("1234");
		//dataSource.setSchema("PUBLIC");
		return dataSource;
	}
}
