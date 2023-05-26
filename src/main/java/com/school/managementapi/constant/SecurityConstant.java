package com.school.managementapi.constant;

public class SecurityConstant {
    public static final String GET_ISSUER = "School Management";
    public static final String GET_AUDIENCE = "User Administration";
    public static final String AUTHORITIES = "authorities";
    public static final long TOKEN_ROTATION = 432_000_000;
    public static final String TOKEN_VERIFICATION_MESSAGE = "Token cannot be verified";
    public static final String JWT_TOKEN_HEADER = "Jwt-Token";
    public static final String[] PUBLIC_RESOURCES = { "/users/login", "/users/register" };
}
