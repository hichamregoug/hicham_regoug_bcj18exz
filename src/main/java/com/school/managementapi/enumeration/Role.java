package com.school.managementapi.enumeration;

import static com.school.managementapi.constant.Authority.*;

public enum Role {
    ROLE_STUDENT(STUDENT_AUTHORITIES),
    ROLE_TEACHER(TEACHER_AUTHORITIES),
    ROLE_DIRECTOR(DIRECTOR_AUTHORITIES);

    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }
}
