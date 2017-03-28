package demo;

import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class MultipleDBConfig {
	@Bean(name = "mysqlDb")
	@ConfigurationProperties(prefix = "spring.ds_mysql")
	public DataSource mysqlDataSource() {
		return DataSourceBuilder.create().build();
	}
//	
//	@Bean(name = "postgresDb")
//	@ConfigurationProperties(prefix = "spring.ds_post")
//	public DataSource postgresDataSource() {
//		return  DataSourceBuilder.create().build();
//	}
	
//    @Bean
//    DataSource dataSource() throws SQLException {
// 
//        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        dataSource.setURL(url);
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
//        return dataSource;
//    }
}