package com.caepia.app.api.config;

import com.caepia.app.api.model.authentication.Client;
import com.caepia.app.api.service.authentication.ClientService;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = "com.caepia.app.api.repository.domain",
        entityManagerFactoryRef = "applicationEntityManagerFactory",
        transactionManagerRef = "applicationTransactionManager")
public class ApplicationConfiguration {
    @Autowired
    private JpaProperties jpaProperties;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    @ConfigurationProperties("app.datasource")
//    public DataSourceProperties applicationDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    public DataSource applicationDataSource() {
//        return applicationDataSourceProperties().initializeDataSourceBuilder().build();
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean applicationEntityManagerFactory(EntityManagerFactoryBuilder builder) {
//        return builder.dataSource(applicationDataSource()).packages("com.caepia.app.api.model.domain")
//                      .persistenceUnit("application").build();
//    }


    @Bean(name = "clientDataSources")
    public Map<String, DataSource> clientDataSources(ClientService clientService) {
        final String url = "jdbc:sqlserver://%s;database=%s";
        final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        Map<String, DataSource> dataSourceMap = new HashMap<>();

        Iterable<Client> clients = clientService.getAll();
        clients.forEach(client -> {
            DataSource dataSource = DataSourceBuilder.create()
                                                     .url(String
                                                             .format(url, client.getServerName(), client.getDatabase()))
                                                     .username(client.getUsername())
                                                     .password(client.getPassword())
                                                     .driverClassName(driverName)
                                                     .build();
            dataSourceMap.put(client.getClientId().toString(), dataSource);
        });
        return dataSourceMap;
    }

    @Bean
    public MultiTenantConnectionProvider multiTenantConnectionProvider() {
        return new DataSourceBasedMultiTenantConnectionProviderImpl();
    }

    @Bean
    public CurrentTenantIdentifierResolver currentTenantIdentifierResolver() {
        return new CurrentTenantIdentifierResolverImpl();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean applicationEntityManagerFactory(
            MultiTenantConnectionProvider multiTenantConnectionProvider,
            CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
        Map<String, Object> hibernateProps = new LinkedHashMap<>();
        hibernateProps.putAll(this.jpaProperties.getProperties());
        hibernateProps.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
        hibernateProps.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProvider);
        hibernateProps.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolver);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPackagesToScan(new String[]{"com.caepia.app.api.model.domain"});
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaPropertyMap(hibernateProps);
        em.setPersistenceUnitName("application");

        return em;
    }

    @Bean
    @Primary
    public JpaTransactionManager applicationTransactionManager(@Qualifier(
            "applicationEntityManagerFactory") final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
