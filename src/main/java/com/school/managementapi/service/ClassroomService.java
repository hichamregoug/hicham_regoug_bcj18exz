package com.school.managementapi.service;

import com.school.managementapi.domain.Student;
import org.springframework.data.domain.Page;

public interface ClassroomService {
    Page<Student> getStudentsByClassroomOrTeacher(String filter, int page, int size);
}
