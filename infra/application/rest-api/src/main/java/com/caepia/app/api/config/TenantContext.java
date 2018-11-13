package com.caepia.app.api.config;

public class TenantContext {

    private static ThreadLocal<String> currentTenant = new ThreadLocal<>();

    // TODO: Use optinal as returning type
    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }

    public static void clear() {
        currentTenant.remove();
    }
}