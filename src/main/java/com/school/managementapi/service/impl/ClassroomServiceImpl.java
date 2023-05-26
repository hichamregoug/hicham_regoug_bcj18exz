package com.school.managementapi.service.impl;

import com.school.managementapi.domain.Student;
import com.school.managementapi.repository.ClassroomRepository;
import com.school.managementapi.repository.StudentRepository;
import com.school.managementapi.service.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Page<Student> getStudentsByClassroomOrTeacher(String filter, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        if(filterIsProvided(filter)) {
            logger.info("get filtered students");
            return classroomRepository.getClassroomByNameOrTeacherFullName(filter, pageable);
        } else {
            logger.info("No filter provided. get all students");
            return studentRepository.findAll(pageable);
        }
    }

    private boolean filterIsProvided(String filter) {
        return filter.length() > 0 ? true : false;
    }
}
