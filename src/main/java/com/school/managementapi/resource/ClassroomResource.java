package com.school.managementapi.resource;

import com.school.managementapi.domain.Student;
import com.school.managementapi.dto.StudentDto;
import com.school.managementapi.exception.ExceptionHandling;
import com.school.managementapi.mapper.MapperUtil;
import com.school.managementapi.mapper.ModelMapper;
import com.school.managementapi.service.impl.ClassroomServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classrooms")
public class ClassroomResource extends ExceptionHandling {
    private final Logger logger = LoggerFactory.getLogger(ClassroomResource.class);

    @Autowired
    private ClassroomServiceImpl classroomServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/students")
    @PreAuthorize("hasAnyAuthority('student:read')")
    public Page<StudentDto> getStudentsByClassroomOrTeacher(@RequestParam String filter,
                                                            @RequestParam(value = "page", defaultValue = "0") int page,
                                                            @RequestParam(value = "size", defaultValue = "10") int size) {

        logger.info("getStudentsByClassroomOrTeacher using filter: {}", filter);
        Page<Student> students = classroomServiceImpl.getStudentsByClassroomOrTeacher(filter, page, size);
        return MapperUtil.mapStudentPageIntoDTOPage(students, modelMapper);
    }
}
