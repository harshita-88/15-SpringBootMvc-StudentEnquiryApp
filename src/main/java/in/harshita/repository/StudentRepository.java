package in.harshita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harshita.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
