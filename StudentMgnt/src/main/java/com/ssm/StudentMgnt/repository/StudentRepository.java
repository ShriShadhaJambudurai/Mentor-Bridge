package com.ssm.StudentMgnt.repository;

import com.ssm.StudentMgnt.repository.entities.StudentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntities, Long> {

}
