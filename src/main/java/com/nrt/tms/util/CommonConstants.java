package com.nrt.tms.util;


public final class CommonConstants {

    private CommonConstants() {} // Prevent instantiation

    // JWT Claims
    public static final String ROLE = "role";
    public static final String PLATFORM = "platform";

    // Platform types
    public static final String WEB = "WEB";
    public static final String APP = "APP";

    // Header / Token prefix
    public static final String BEARER_PREFIX = "Bearer ";

    // Custom claim example for multi-tenancy
    public static final String TENANT_ID = "tenantId";

    // Custom error or log keys
    public static final String AUDIT_USER = "X-Audit-User";
}
