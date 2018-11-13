package com.caepia.app.api.config;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.util.Map;

public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    private static final long serialVersionUID = 1L;

    @Autowired
    @Qualifier("clientDataSources")
    private Map<String, DataSource> clientDataSources;

    @Override
    protected DataSource selectAnyDataSource() {
        return this.clientDataSources.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantId) {
        return this.clientDataSources.get(tenantId);
    }

}