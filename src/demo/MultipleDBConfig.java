package demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class MultipleDBConfig {
	@Bean(name = "mysqlDb")
	@ConfigurationProperties(prefix = "spring.ds_mysql")
	public DataSource mysqlDataSource() {
//		return DataSourceBuilder.create().build();
		return new DataSourceProperties().initializeDataSourceBuilder().build();

	}

	@Bean(name = "mysqlJdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Qualifier("mysqlDb") DataSource dsMySQL) {
		return new JdbcTemplate(dsMySQL);
	}

	//
	// @Bean(name = "postgresDb")
	// @ConfigurationProperties(prefix = "spring.ds_post")
	// public DataSource postgresDataSource() {
	// return DataSourceBuilder.create().build();
	// }

	// @Bean(name = "postgresJdbcTemplate")
	// public JdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDb")
	// DataSource dsPostgres) {
	// return new JdbcTemplate(dsPostgres);
	// }

//	@Bean(name = "oracleDb")
//	@ConfigurationProperties(prefix = "spring.ds_oracle")
//	public DataSource oracleDataSource() {
//		return DataSourceBuilder.create().build();
//	}
}