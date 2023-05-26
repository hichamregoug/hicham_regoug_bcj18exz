package com.school.managementapi.repository;

import com.school.managementapi.domain.Classroom;
import com.school.managementapi.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    @Query(value="select c.students from Classroom c where c.name = :filter or c.teacher.firstName = :filter or c.teacher.lastName = :filter")
    Page<Student> getClassroomByNameOrTeacherFullName(@Param("filter") String filter, Pageable pageable);
}
