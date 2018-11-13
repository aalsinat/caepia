package com.caepia.app.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.caepia.app.api.repository.authentication",
        entityManagerFactoryRef = "authenticationEntityManagerFactory",
        transactionManagerRef = "authenticationTransactionManager")
public class AuthenticationConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("auth.datasource")
    public DataSourceProperties authenticationDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource authDataSource() {
        return authenticationDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean authenticationEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder.dataSource(authDataSource()).packages("com.caepia.app.api.model.authentication")
                      .persistenceUnit("authentication").build();
    }

    @Bean
    @Primary
    public JpaTransactionManager authenticationTransactionManager(@Qualifier(
            "authenticationEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
