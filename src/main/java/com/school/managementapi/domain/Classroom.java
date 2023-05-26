package com.school.managementapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Classroom {
    private Long id;
    private String name;
    private Teacher teacher;
    private List<Student> students;
}
