package com.example.wishlistrestapi.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfiguration {

    private final Environment environment;

    @Bean
    @ConditionalOnProperty(prefix = "wishlist", name = "database-used", havingValue = "H2Database")
    public DataSource getH2DatabaseDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:mydb")
                .username("user")
                .password("")
                .build();
    }

    @Bean
    @ConditionalOnProperty(prefix = "wishlist", name = "database-used", havingValue = "PostgreSQL")
    public DataSource getPostgresSQLDatabaseDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url(environment.getProperty("spring.datasource.url"))
                .username(environment.getProperty("spring.datasource.username"))
                .password(environment.getProperty("spring.datasource.password"))
                .build();
    }
}
