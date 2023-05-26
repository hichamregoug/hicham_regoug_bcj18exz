package com.school.managementapi.mapper;

import com.school.managementapi.domain.Student;
import com.school.managementapi.dto.StudentDto;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public class MapperUtil {
    public static Page<StudentDto> mapStudentPageIntoDTOPage(Page<Student> studentPage, ModelMapper modelMapper) {
        return studentPage.map(new Function<Student, StudentDto>() {
            @Override
            public StudentDto apply(Student student) {
                return modelMapper.map(student, StudentDto.class);
            }
        });
    }
}
