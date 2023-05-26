package com.school.managementapi.constant;

public class Authority {
    public static final String[] STUDENT_AUTHORITIES = { "student:read" };
    public static final String[] TEACHER_AUTHORITIES = { "student:read", "student:create", "student:update" };
    public static final String[] DIRECTOR_AUTHORITIES = { "student:read", "student:create", "student:update", "student:delete" };
}
