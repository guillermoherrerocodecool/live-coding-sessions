package com.codecool.hogwartshouses.persistence.repository;

import com.codecool.hogwartshouses.persistence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
