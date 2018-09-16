package com.dongfangju.hyacinth.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JdbcDatasource {
    @Value("${jdbc.jdbcUrl}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(jdbcUrl);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setMaximumPoolSize(50);
        ds.setMinimumIdle(5);
        ds.setMaxLifetime(1800000);
        ds.setIdleTimeout(600000);
        ds.setConnectionTimeout(30000);
        ds.setLeakDetectionThreshold(60000);

        return ds;
    }
}
