package com.school.managementapi.dto;

import com.school.managementapi.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private Role role;
}
