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
@EnableJpaRepositories(basePackages = "com.caepia.app.api.repository.domain",
                       entityManagerFactoryRef = "applicationEntityManagerFactory",
                       transactionManagerRef = "applicationTransactionManager")
public class ApplicationConfiguration {
    @Bean
    @ConfigurationProperties("app.datasource")
    public DataSourceProperties applicationDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource applicationDataSource() {
        return applicationDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean applicationEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(applicationDataSource()).packages("com.caepia.app.api.model.domain")
                      .persistenceUnit("application").build();
    }

    @Bean
    @Primary
    public JpaTransactionManager applicationTransactionManager(@Qualifier(
            "applicationEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
