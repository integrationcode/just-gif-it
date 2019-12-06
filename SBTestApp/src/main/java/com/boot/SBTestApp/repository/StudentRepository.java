package com.boot.SBTestApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.SBTestApp.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
