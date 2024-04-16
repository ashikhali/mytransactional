package com.ingress.mytransactional.repositories;

import com.ingress.mytransactional.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
